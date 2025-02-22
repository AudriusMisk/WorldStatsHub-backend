package lt.ca.javau11.entities;

import java.util.List;

import jakarta.persistence.Column;
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
    
    @Column(name = "capital", columnDefinition = "TEXT")
    private String capital;
    
    private Long population;	  // Extract "population"
    
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;        // Extract "region"
    
    @Column(length = 255)
    private String languages;     // Store as comma-separated string

    @Column(length = 255)
    private String currencies; 
    
    public Country() {}

    public Country(Long id, String name, String officialName, String capital, Long population, Region region,
            List<String> languages, List<String> currencies) {
		 this.id = id;
		 this.name = name;
		 this.officialName = officialName;
		 this.capital = capital != null ? String.join(", ", capital) : null;
		 this.population = population;
		 this.region = region;
		 this.languages = languages != null ? String.join(", ", languages) : null;
		 this.currencies = currencies != null ? String.join(", ", currencies) : null;
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

	public void setCapital(List<String> capitals) {
	        this.capital = (capitals != null && !capitals.isEmpty()) ? String.join(", ", capitals) : null;
	}

	    // Convert from String to List<String>
	public List<String> getCapital() {
	        return capital != null ? List.of(capital.split(", ")) : null;
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
	    return languages != null ? List.of(languages.split(", ")) : null;
	 }
	 
	 public void setLanguages(List<String> languages) {
	    this.languages = languages != null ? String.join(", ", languages) : null;
	 }

	 public List<String> getCurrencies() {
	     return currencies != null ? List.of(currencies.split(", ")) : null;
	 }
	 public void setCurrencies(List<String> currencies) {
	     this.currencies = currencies != null ? String.join(", ", currencies) : null;
	 }
    
}
