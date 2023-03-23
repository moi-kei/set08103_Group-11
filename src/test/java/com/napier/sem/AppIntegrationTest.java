package com.napier.sem;

import com.napier.sem.businessObjects.City;
import com.napier.sem.businessObjects.Country;
import com.napier.sem.businessObjects.reports.CityReport;
import com.napier.sem.businessObjects.reports.CountryReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    //initialize app
    static App app;

    //initialize database connection
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    /**
     *test the getAllCities function
     */
    @Test
    void testGetAllCountries(){

        ArrayList<Country> countries = CountryReport.getAllCountries(App.con);

        //check if list is not null
        assertNotNull(countries);

        //check list has correct values
        Country country = new Country();
        for (Country c : countries)
        {
            if(c.getCode().equals("ITA"))
            {
                country = c;
                break;
            }
        }
        assertEquals(country.getName(), "Italy");
        assertEquals(country.getContinent(), "Europe");
        assertEquals(country.getRegion(), "Southern Europe");
        assertEquals(country.getPopulation(), 57680000);
        assertEquals(country.getCapital(), "Roma");
    }

    /**
     *test the getAllCitiesLimit function
     */
    @Test
    void testGetAllCountriesLimit(){

        ArrayList<Country> countries = CountryReport.getAllCountriesLimit (App.con, 10);

        //check if list is not null
        assertNotNull(countries);

        //check list has correct values
        Country country = new Country();
        for (Country c : countries)
        {
            if(c.getCode().equals("CHN"))
            {
                country = c;
                break;
            }
        }
        assertEquals(country.getName(), "China");
        assertEquals(country.getContinent(), "Asia");
        assertEquals(country.getRegion(), "Eastern Asia");
        assertEquals(country.getPopulation(), 1277558000);
        assertEquals(country.getCapital(), "Peking");

        //check list has correct number of entries
        assertEquals(countries.size(), 10);
    }

    /**
     *test the getAllCitiesContinent function
     */
    @Test
    void testGetAllCountriesContinent(){

        String continent = "Europe";
        ArrayList<Country> countries = CountryReport.getAllCountriesContinent(App.con, continent);

        //check if list is not null
        assertNotNull(countries);

        //check list has correct values
        Country country = new Country();
        for (Country c : countries)
        {
            if(c.getCode().equals("GRC"))
            {
                country = c;
                break;
            }
        }
        assertEquals(country.getName(), "Greece");
        assertEquals(country.getContinent(), "Europe");
        assertEquals(country.getRegion(), "Southern Europe");
        assertEquals(country.getPopulation(), 10545700);
        assertEquals(country.getCapital(), "Athenai");
    }

    /**
     *test the getAllCitiesContinent function
     */
    @Test
    void testGetAllCountriesContinentLimit(){

        String continent = "South America";
        ArrayList<Country> countries = CountryReport.getAllCountriesContinentLimit(App.con, continent, 5);

        //check if list is not null
        assertNotNull(countries);

        //check list has correct values
        Country country = new Country();
        for (Country c : countries)
        {
            if(c.getCode().equals("ARG"))
            {
                country = c;
                break;
            }
        }
        assertEquals(country.getName(), "Argentina");
        assertEquals(country.getContinent(), "South America");
        assertEquals(country.getRegion(), "South America");
        assertEquals(country.getPopulation(), 37032000);
        assertEquals(country.getCapital(), "Buenos Aires");

        //check list has correct number of entries
        assertEquals(countries.size(), 5);
    }

    /**
     *test the getAllCitiesContinent function
     */
    @Test
    void testGetAllCountriesRegion(){

        String region = "South America";
        ArrayList<Country> countries = CountryReport.getAllCountriesRegion(App.con, region);

        //check if list is not null
        assertNotNull(countries);

        //check list has correct values
        Country country = new Country();
        for (Country c : countries)
        {
            if(c.getCode().equals("BRA"))
            {
                country = c;
                break;
            }
        }
        assertEquals(country.getName(), "Brazil");
        assertEquals(country.getContinent(), "South America");
        assertEquals(country.getRegion(), "South America");
        assertEquals(country.getPopulation(), 170115000);
        assertEquals(country.getCapital(), "Brasília");
    }

    /**
     *test the getAllCitiesContinent function
     */
    @Test
    void testGetAllCountriesRegionLimit(){

        String region = "Southeast Asia";
        ArrayList<Country> countries = CountryReport.getAllCountriesRegionLimit(App.con, region, 5);

        //check if list is not null
        assertNotNull(countries);

        //check list has correct values
        Country country = new Country();
        for (Country c : countries)
        {
            if(c.getCode().equals("PHL"))
            {
                country = c;
                break;
            }
        }
        assertEquals(country.getName(), "Philippines");
        assertEquals(country.getContinent(), "Asia");
        assertEquals(country.getRegion(), "Southeast Asia");
        assertEquals(country.getPopulation(), 75967000);
        assertEquals(country.getCapital(), "Manila");

        //check list has correct number of entries
        assertEquals(countries.size(), 5);
    }

    /**
     *test the getAllCities function
     */
    @Test
    void testGetAllCities(){

        List<City> cities = CityReport.getAllCities(App.con);

        //check if list is not null
        assertNotNull(cities);

        //check list has correct values
        City city = new City();
        for (City c : cities)
        {
            if(c.getName().equals("Edinburgh"))
            {
                city = c;
                break;
            }
        }
        assertEquals(city.getDistrict(), "Scotland");
        assertEquals(city.getCountry(), "United Kingdom");
        assertEquals(city.getPopulation(), 450180);

    }

    /**
     *test the getAllCitiesContinent function
     */
    @Test
    void testGetAllCitiesContinent(){

        String continent = "South America";
        List<City> cities = CityReport.getAllCitiesContinent(App.con, continent);

        //check if list is not null
        assertNotNull(cities);

        //check list has correct values
        City city = new City();
        for (City c : cities)
        {
            if(c.getName().equals("Rio de Janeiro"))
            {
                city = c;
                break;
            }
        }
        assertEquals(city.getDistrict(), "Rio de Janeiro");
        assertEquals(city.getCountry(), "Brazil");
        assertEquals(city.getPopulation(), 5598953);
    }

    /**
     *test the getAllCitiesRegion function
     */
    @Test
    void testGetAllCitiesRegion(){

        String region = "Eastern Asia";
        List<City> cities = CityReport.getAllCitiesRegion(App.con, region);

        //check if list is not null
        assertNotNull(cities);

        //check list has correct values
        City city = new City();
        for (City c : cities)
        {
            if(c.getName().equals("Tokyo"))
            {
                city = c;
                break;
            }
        }
        assertEquals(city.getDistrict(), "Tokyo-to");
        assertEquals(city.getCountry(), "Japan");
        assertEquals(city.getPopulation(), 7980230);
    }

    /**
     *test the getAllCitiesCountry function
     */
    @Test
    void testGetAllCitiesCountry(){

        String country = "Belgium";
        List<City> cities = CityReport.getAllCitiesCountry(App.con, country);

        //check if list is not null
        assertNotNull(cities);

        //check list has correct values
        City city = new City();
        for (City c : cities)
        {
            if(c.getName().equals("Brugge"))
            {
                city = c;
                break;
            }
        }
        assertEquals(city.getDistrict(), "West Flanderi");
        assertEquals(city.getCountry(), "Belgium");
        assertEquals(city.getPopulation(), 116246);
    }

    /**
     *test the getAllCitiesCountry function
     */
    @Test
    void testGetAllCitiesDistrict(){

        String district = "New York";
        List<City> cities = CityReport.getAllCitiesDistrict(App.con, district);

        //check if list is not null
        assertNotNull(cities);

        //check list has correct values
        City city = new City();
        for (City c : cities)
        {
            if(c.getName().equals("New York"))
            {
                city = c;
                break;
            }
        }
        assertEquals(city.getDistrict(), "New York");
        assertEquals(city.getCountry(), "United States");
        assertEquals(city.getPopulation(), 8008278);
    }
}
