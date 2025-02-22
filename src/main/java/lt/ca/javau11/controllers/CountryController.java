package lt.ca.javau11.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import lt.ca.javau11.entities.Country;
import lt.ca.javau11.repositories.CountryRepository;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin(origins = "http://localhost:3000")  // Allow requests from React app
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
}


//@RestController
//@RequestMapping("/countries")
//public class CountryController {
//
//    @Autowired
//    private CountryService countryService;
//
//    @GetMapping("/region/{regionId}")
//    public List<Country> getCountriesByRegion(@PathVariable Long regionId) {
//        return countryService.getCountriesByRegion(regionId);
//    }
//
//    @GetMapping("/{id}")
//    public Country getCountryById(@PathVariable Long id) {
//        return countryService.getCountryById(id);
//    }
//}
