package com.napier.sem;

/**
 * Class representing a Country
 */
public class Country
{
    /**
     * Country Code
     */
    private String code;

    /**
     * Country Name
     */
    private String name;

    /**
     * Continent
     */
    private String continent;

    /**
     * Country Region
     */
    private String region;
    /**
     * Population
     */
    private int population;

    /**
     * Capital
     */
    private String capital;

    // Constructors
    /**
     * Default Constructor
     */
    public Country() {}

    // Getters and Setters
    /**
     * Returns code property
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code property
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns name property
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Name Property
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns continent property
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Sets continent property
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Returns region property
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets region property
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Returns population property
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Sets population property
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Returns capital property
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Sets capital property
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * ToString Method for Country Class
     */
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", population=" + population +
                ", capital='" + capital + '\'' +
                '}';
    }
}
