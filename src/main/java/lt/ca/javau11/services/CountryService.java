package lt.ca.javau11.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ca.javau11.entities.Country;
import lt.ca.javau11.entities.Region;
import lt.ca.javau11.repositories.CountryRepository;
import lt.ca.javau11.repositories.RegionRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RegionRepository regionRepository;

    public List<Country> getCountriesByRegion(Long regionId) {
        Region region = regionRepository.findById(regionId).orElse(null);
        return countryRepository.findByRegion(region);
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }
}
