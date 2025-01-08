package lt.ca.javau11.entities;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;          // Extract "name.common"
    private String officialName;  // Extract "name.official"
    private String capital;       // Extract "capital[0]"
    private Long population;	  // Extract "population"
    
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;        // Extract "region"
    
    @ElementCollection
    private List<String> languages; // List of languages as Strings

    @ElementCollection
    private List<String> currencies; // List of currencies as Strings
    
    public Country() {}

	public Country(Long id, String name, String officialName, String capital, Long population, Region region,
			List<String> languages, List<String> currencies) {
		this.id = id;
		this.name = name;
		this.officialName = officialName;
		this.capital = capital;
		this.population = population;
		this.region = region;
		this.languages = languages;
		this.currencies = currencies;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfficialName() {
		return officialName;
	}

	public void setOfficialName(String officialName) {
		this.officialName = officialName;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<String> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<String> currencies) {
		this.currencies = currencies;
	}

    
}
