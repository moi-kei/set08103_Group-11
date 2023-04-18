package com.napier.sem.businessObjects;

/**
 * Class representing a Country
 * {@code @Authors:}  Michael Mackenzie, Nweke Success
 */
public class Country {
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
    public Country() {
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
     *
     * @param code the countries code
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
     *
     * @param name the name ofd the country
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
     *
     * @param continent the continent the country is on
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
     *
     * @param region the region the country is in
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
     *
     * @param population the population of the country
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
     *
     * @param capital the capital city of the country
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }
}
