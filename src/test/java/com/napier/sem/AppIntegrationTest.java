package com.napier.sem;

import com.napier.sem.businessObjects.reports.CityReport;
import com.napier.sem.businessObjects.reports.CountryReport;
import com.napier.sem.businessObjects.reports.LanguageReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * integration tests for the application
 */
public class AppIntegrationTest
{
    //initialize app
    static App app;

    //initialize database connection
    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    /*
    App integration tests
     */
    /**
     * Tests the main function with no arguments
     */
    @Test
    void mainTestEmpty(){

        String[] connection = {};
        App.main(connection);
    }

    /**
     * Tests the main function with working arguments
     */
    @Test
    void mainTestArgs(){

        String[] connection = {"localhost:33060", "30000"};
        App.main(connection);
    }

    /**
     * Tests the main function with wrong arguments
     */
    @Test
    void mainTestFail(){

        String[] connection = {"Failure", "1"};
        App.main(connection);
    }

    /*
    CountryReport Integration tests
     */
    /**
     * checks ExecuteQuery works when null is passed
     */
    @Test
    void ExecuteCountryQueryNullTest(){
        CountryReport.printCountries(CountryReport.ExecuteQuery(null, null));
    }

    /**
     * checks ExecuteQuery works when null is passed with a valid connection
     */
    @Test
    void ExecuteCountryQueryNullQueryTest(){
        CountryReport.printCountries(CountryReport.ExecuteQuery(App.con, null));
    }

    /**
     * checks ExecuteQuery works when null is passed to the connection with a valid query
     */
    @Test
    void ExecuteCountryQueryNullConTest(){
        CountryReport.printCountries(CountryReport.ExecuteQuery(null, CountryReport.getCountries(5) ));
    }

    /**
     * testing ExecuteQuery
     */
    @Test
    void ExecuteCountryQueryTest(){
        CountryReport.printCountries(CountryReport.ExecuteQuery(App.con, CountryReport.getCountries(5)));
    }

    /**
     * testing buildCountryList with null
     */
    @Test
    void buildCountryListNullTest(){
        CountryReport.printCountries(CountryReport.buildCountryList(null));
    }

    /*
    CityReport integration tests
     */
    /**
     * checks ExecuteQuery works when null is passed
     */
    @Test
    void ExecuteCityQueryNullTest(){
        CityReport.printCities(CityReport.ExecuteQuery(null, null));
    }

    /**
     * checks ExecuteQuery works when null is passed with a valid connection
     */
    @Test
    void ExecuteCityQueryNullQueryTest(){
        CityReport.printCities(CityReport.ExecuteQuery(App.con, null));
    }

    /**
     * checks ExecuteQuery works when null is passed to the connection with a valid query
     */
    @Test
    void ExecuteCityQueryNullConTest(){
        CityReport.printCities(CityReport.ExecuteQuery(null, CityReport.getCities(5)));
    }

    /**
     * testing ExecuteQuery
     */
    @Test
    void ExecuteCityQueryTest(){
        CityReport.printCities(CityReport.ExecuteQuery(App.con, CityReport.getCities(5)));
    }

    /**
     * testing buildCountryList with null
     */
    @Test
    void buildCityListNullTest(){
        CityReport.printCities(CityReport.buildCityList(null));
    }

    /*
    LanguageReport integration tests
     */
    /**
     * testing getLanguages with null
     */
    @Test
    void getLanguagesNullTest(){
        LanguageReport.printLanguages(LanguageReport.getLanguages(null));
    }

    /**
     * testing getLanguages
     */
    @Test
    void getLanguagesTest(){
        LanguageReport.printLanguages(LanguageReport.getLanguages(App.con));
    }

    /*
    PopulationReport integration tests
     */

}

