package lt.ca.javau11.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lt.ca.javau11.dto.CountryDTO;
import lt.ca.javau11.entities.Country;
import lt.ca.javau11.entities.Region;
import lt.ca.javau11.repositories.CountryRepository;
import lt.ca.javau11.repositories.RegionRepository;

import java.util.Optional;

@Service
public class RestCountriesService {
	

	private final RestTemplate restTemplate;
    private final CountryRepository countryRepository;
    private final RegionRepository regionRepository;

    public RestCountriesService(RestTemplate restTemplate, CountryRepository countryRepository, RegionRepository regionRepository) {
        this.restTemplate = restTemplate;
        this.countryRepository = countryRepository;
        this.regionRepository = regionRepository;
    }

    public void fetchAndSaveCountries() {
        String url = "https://restcountries.com/v3.1/all";
        CountryDTO[] countryDTOs = restTemplate.getForObject(url, CountryDTO[].class);

        if (countryDTOs != null) {
            for (CountryDTO dto : countryDTOs) {
                String regionName = dto.getRegion();
                if (regionName == null || regionName.isBlank()) {
                    continue;
                }

                Optional<Region> existingRegion = regionRepository.findByName(regionName);
                Region region = existingRegion.orElseGet(() -> {
                    Region newRegion = new Region(null, regionName, null);
                    return regionRepository.save(newRegion);
                });

                Country country = new Country();
                country.setName(dto.getName());
                country.setOfficialName(dto.getOfficialName());
                country.setPopulation(dto.getPopulation());
                country.setCapital(dto.getCapital());
                country.setRegion(region);
                country.setLanguages(dto.getLanguages());
                country.setCurrencies(dto.getCurrencies());

                countryRepository.save(country);
            }
        }
    }
}