package com.napier.sem.businessObjects;

public class Population {

    private String name;
    private long population;
    private long cityPopulation;
    private long outOfCityPopulation;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }
    public void setPopulation(long population) {
        this.population = population;
    }

    public long getCityPopulation() {return cityPopulation;}
    public void setCityPopulation(long cityPopulation) {this.cityPopulation = cityPopulation;}

    public long getOutOfCityPopulation() {
        return outOfCityPopulation;
    }
    public void setOutOfCityPopulation(long outOfCityPopulation) {
        this.outOfCityPopulation = outOfCityPopulation;
    }
}
