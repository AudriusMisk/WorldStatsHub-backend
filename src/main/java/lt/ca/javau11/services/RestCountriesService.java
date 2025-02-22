package lt.ca.javau11.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lt.ca.javau11.dto.CountryDTO;
import lt.ca.javau11.entities.Country;
import lt.ca.javau11.entities.Region;
import lt.ca.javau11.repositories.CountryRepository;
import lt.ca.javau11.repositories.RegionRepository;

import org.springframework.http.ResponseEntity;

import java.util.List;
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
                    continue; // Skip countries with no region
                }

                // Find or create the region
                Optional<Region> existingRegion = regionRepository.findByName(regionName);
                Region region = existingRegion.orElseGet(() -> {
                    Region newRegion = new Region(null, regionName, null);
                    return regionRepository.save(newRegion);
                });

                // Create and save the country
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
	
//    private final String API_URL = "https://restcountries.com/v3.1";
//
//    private final RestTemplate restTemplate;
//
//    public RestCountriesService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//    
//    
//    
//    public void fetchData() {
//        String url = "https://restcountries.com/v3.1/all";
//        String response = restTemplate.getForObject(url, String.class);
//        System.out.println(response);
//    }
//
//    public List<CountryDTO> getAllCountries() {
//        String url = API_URL + "/all";
//        ResponseEntity<CountryDTO[]> response = restTemplate.getForEntity(url, CountryDTO[].class);
//        return List.of(response.getBody());
//    }
//
//    public List<CountryDTO> getCountriesByRegion(String region) {
//        String url = API_URL + "/region/" + region;
//        ResponseEntity<CountryDTO[]> response = restTemplate.getForEntity(url, CountryDTO[].class);
//        return List.of(response.getBody());
//    }
//
//    public CountryDTO getCountryByName(String name) {
//        String url = API_URL + "/name/" + name;
//        ResponseEntity<CountryDTO[]> response = restTemplate.getForEntity(url, CountryDTO[].class);
//        return response.getBody()[0];
//    }
//}