package com.napier.sem.businessObjects;

/**
 * Class representing a Language

 * {@code @Authors:}  Michael Mackenzie, Nweke Success
 */
public class Language {

    /**
     * The name oif the language
     */
    private String name;

    /**
     * The population that speaks it
     */
    private long population;

    /**
     * The percentage of the world population that speaks it
     */
    private Float percentage;

    /**
     * gets the name of the language
     * @return the name f the language
     */
    public String getName(){return name;}

    /**
     * sets the name of the language
     * @param name the name of the language
     */
    public void setName(String name){this.name = name;}

    /**
     * get the number of people that speak the language
     * @return the number of speakers
     */
    public long getPopulation(){return population;}

    /**
     * sets the population of the language
     * @param population the total population that speaks the language
     */
    public void setPopulation(long population){this.population = population;}

    /**
     * gets the percentage of the language
     * @return the percenatge of the language
     */
    public Float getPercentage(){return percentage;}

    /**
     * sets the percentage f the language
     * @param percentage the percentage of the world population that speaks the language
     */
    public void setPercentage(Float percentage){this.percentage = percentage;}
}
