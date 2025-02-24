package lt.ca.javau11;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lt.ca.javau11.repositories.CountryRepository;
import lt.ca.javau11.services.RestCountriesService;

@SpringBootApplication
public class CountryApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryApiProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RestCountriesService restCountriesService, CountryRepository countryRepository) {
	    return args -> {
	        if (countryRepository.count() == 0) {
	            restCountriesService.fetchAndSaveCountries();
	        }
	    };
	}
}
