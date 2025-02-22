package lt.ca.javau11.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lt.ca.javau11.entities.Country;
import lt.ca.javau11.services.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/region/{regionId}")
    public List<Country> getCountriesByRegion(@PathVariable Long regionId) {
        return countryService.getCountriesByRegion(regionId);
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }
}
