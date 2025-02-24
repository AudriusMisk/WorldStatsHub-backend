package lt.ca.javau11.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import lt.ca.javau11.entities.Country;
import lt.ca.javau11.repositories.CountryRepository;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin(origins = "http://localhost:3000")
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable Long id) {
        return countryRepository.findById(id).orElse(null);
    }
    
    @GetMapping
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
    
    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryRepository.save(country);
    }
    
    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable Long id, @RequestBody Country updatedCountry) {
        return countryRepository.findById(id)
            .map(country -> {
                country.setName(updatedCountry.getName());
                country.setOfficialName(updatedCountry.getOfficialName());
                country.setCapital(updatedCountry.getCapital());
                country.setPopulation(updatedCountry.getPopulation());
                country.setLanguages(updatedCountry.getLanguages());
                country.setCurrencies(updatedCountry.getCurrencies());
                return countryRepository.save(country);
            })
            .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryRepository.deleteById(id);
    }
}
