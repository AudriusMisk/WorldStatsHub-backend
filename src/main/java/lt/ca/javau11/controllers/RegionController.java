package lt.ca.javau11.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import lt.ca.javau11.entities.Country;
import lt.ca.javau11.entities.Region;
import lt.ca.javau11.repositories.CountryRepository;
import lt.ca.javau11.repositories.RegionRepository;

@RestController
@RequestMapping("/api/regions")
@CrossOrigin(origins = "http://localhost:3000")
public class RegionController {

    private final RegionRepository regionRepository;
    private final CountryRepository countryRepository;

    public RegionController(RegionRepository regionRepository, CountryRepository countryRepository) {
        this.regionRepository = regionRepository;
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable Long id) {
        return regionRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/countries")
    public List<Country> getCountriesByRegion(@PathVariable Long id) {
        Region region = regionRepository.findById(id).orElse(null);
        if (region != null) {
            return countryRepository.findByRegion(region);
        } else {
            return null;
        }
    }
}
