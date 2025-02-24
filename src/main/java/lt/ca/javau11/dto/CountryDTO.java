package lt.ca.javau11.dto;

import java.util.List;
import java.util.Map;

import lt.ca.javau11.support.Currency;
import lt.ca.javau11.support.Name;

public class CountryDTO {
    private Name name;
    private List<String> capital;
    private Long population;
    private Map<String, String> flags;
    private String region;
    private Map<String, String> languages;
    private Map<String, Currency> currencies;

    public String getName() {
        return name.common;
    }

    public String getOfficialName() {
        return name.official;
    }

    public String getFlagUrl() {
        return (flags != null && flags.containsKey("png")) ? flags.get("png") : null;
    }

    public List<String> getCapital() {
        return capital;
    }

    public Long getPopulation() {
        return population;
    }

    public String getRegion() {
        return region;
    }

    public List<String> getLanguages() {
        return languages != null ? List.copyOf(languages.values()) : null;
    }

    public List<String> getCurrencies() {
        return currencies != null ? currencies.keySet().stream().toList() : null;
    }
}