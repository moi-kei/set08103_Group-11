package com.napier.sem;

import com.napier.sem.businessObjects.City;
import com.napier.sem.businessObjects.reports.CityReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
            }
        }
        assertEquals(city.getDistrict(), "New York");
        assertEquals(city.getCountry(), "United States");
        assertEquals(city.getPopulation(), 8008278);
    }
}
