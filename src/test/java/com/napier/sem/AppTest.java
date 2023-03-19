package com.napier.sem;
import com.napier.sem.businessObjects.City;
import com.napier.sem.businessObjects.Country;
import com.napier.sem.businessObjects.reports.CityReport;
import com.napier.sem.businessObjects.reports.CountryReport;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

class AppTest {
    static App app;

    /**
     * initialises app for use in the unit tests
     */
    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /**
     * checks that the app doesn't fail when the list is null
     */
    @Test
    void printAllCountriesTestNull()
    {
        CountryReport.printAllCountries(null);
    }

    /**
     * checks that the app doesn't fail when the list is empty
     */
    @Test
    void printAllCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<>();
        CountryReport.printAllCountries(countries);
    }

    /**
     * checks that the app doesn't fail when the list contains null
     */
    @Test
    void printAllCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        CountryReport.printAllCountries(countries);
    }

    /**
     * checks that the app functions with a normal entry
     */
    @Test
    void printAllCountriesTest()
    {
        ArrayList<Country> countries = new ArrayList<>();
        Country c = new Country();
        c.setName("Scotland");
        c.setCapital("Edinburgh");
        c.setCode("1");
        c.setContinent("Europe");
        c.setRegion("United Kingdom");
        c.setPopulation(10);
        countries.add(c);
        CountryReport.printAllCountries(countries);
    }


    /**
     * checks that the app doesn't fail when the list is null
     */
    @Test
    void printCitiesTestNull()
    {
        CityReport.printCities(null);
    }

    /**
     * checks that the app doesn't fail when the list is empty
     */
    @Test
    void printCitiesTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<>();
        CityReport.printCities(cities);
    }

    /**
     * checks that the app doesn't fail when the list contains null
     */
    @Test
    void printCitiesTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        CityReport.printCities(cities);
    }

    /**
     * checks that the app functions with a normal entry
     */
    @Test
    void printCitiesTest()
    {
        ArrayList<City> cities = new ArrayList<>();
        City c = new City();
        c.setCountry("Scotland");
        c.setName("Edinburgh");
        c.setDistrict("Scotland");
        c.setPopulation(27);
        cities.add(c);
        CityReport.printCities(cities);
    }
}
