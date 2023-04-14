package com.napier.sem.businessObjects;

/**
 * Class representing a population
 * {@code @Authors:}  Michael Mackenzie, Nweke Success
 */
public class Population {

    /**
     * The name of the population
     * e.g. can be a country, city, continent any group
     */
    private String name;

    /**
     * The total population
     */
    private long population;

    /**
     * the population living in cities
     */
    private long cityPopulation;

    /**
     * the population not living in cities
     */
    private long outOfCityPopulation;

    /**
     * gets the name of the population
     * @return the name of the population grouping
     */
    public String getName() { return name; }

    /**
     * sets the name of the population
     * @param name the name for the poopulation
     */
    public void setName(String name) { this.name = name; }

    /**
     * gets the total population
     * @return the total population
     */
    public long getPopulation() { return population; }

    /**
     * sets the total population
     * @param population the total population
     */
    public void setPopulation(long population) { this.population = population; }

    /**
     * gets the number living in cities
     * @return the population living in cities
     */
    public long getCityPopulation() {return cityPopulation;}

    /**
     * sets the cityPopulation
     * @param cityPopulation the population living inside cities
     */
    public void setCityPopulation(long cityPopulation) {this.cityPopulation = cityPopulation;}

    /**
     * gets the outOfCityPopulation
     * @return the number of people not living in cities
     */
    public long getOutOfCityPopulation() { return outOfCityPopulation; }

    /**
     * sets the outOfCityPopulation
     * @param outOfCityPopulation the number of people not living in cities
     */
    public void setOutOfCityPopulation(long outOfCityPopulation) { this.outOfCityPopulation = outOfCityPopulation; }
}
