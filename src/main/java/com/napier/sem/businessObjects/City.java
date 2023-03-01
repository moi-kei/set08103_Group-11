package com.napier.sem.businessObjects;

/**
 * Class representing a City

 * {@code @Authors:}  Michael Mackenzie, Nweke Success
 */
public class City {

    /**
     * Name of the City
     */
    private String name;

    /**
     * Country the city is in
     */
    private String country;

    /**
     * District the city is in
     */
    private String district;

    /**
     * Population of the city
     */
    private int population;

    //getters and setters

    /**
     * gets the name of the city
     *
     * @return the name of the city
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the city
     *
     * @param name the name of the city
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the country of the city
     *
     * @return the country of the city
     */
    public String getCountry() {
        return country;
    }

    /**
     * sets the country of the city
     *
     * @param country the name of the city
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * gets the district of the city
     *
     * @return the district of the city
     */
    public String getDistrict() {
        return district;
    }

    /**
     * sets the country of the city
     *
     * @param district the name of the city
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * sets the population of the city
     *
     * @param population the name of the city
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * gets the population of the city
     *
     * @return the population of the city
     */
    public int getPopulation() {
        return population;
    }
}
