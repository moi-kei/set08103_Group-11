package com.napier.sem;

/**
 * Class representing a Country
 */
public class Country
{

    // Class Properties
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

    /**
     * Country Constructor
     * @param code Country's Code
     * @param name Name of the country
     * @param continent continent where the country is
     * @param region region of the world of the country
     * @param population Population of the country
     * @param capital Country's Capital city
     */
    public Country(String code, String name, String continent, String region, int population, String capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }


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
        return code + " | " + name + " | " + continent + " | " + region + " | " + population + " | " + capital;
    }
}
