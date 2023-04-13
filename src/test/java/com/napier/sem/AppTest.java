package com.napier.sem;
import com.napier.sem.businessObjects.City;
import com.napier.sem.businessObjects.Country;
import com.napier.sem.businessObjects.Language;
import com.napier.sem.businessObjects.Population;
import com.napier.sem.businessObjects.reports.*;
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

    /*
    CountryReport unit tests
    */
    /**
     * checks getCountries function
     */
    @Test
    void getCountriesTest()
    {
        System.out.println(CountryReport.getCountries());
    }

    /**
     * checks getCountries function with different limits
     */
    @Test
    void getCountriesTestLimits()
    {
        System.out.println(CountryReport.getCountries(1));
        System.out.println(CountryReport.getCountries(0));
        System.out.println(CountryReport.getCountries(-1));
    }

    /**
     * checks getCountriesContinent function doesn't fail when null is passed
     */
    @Test
    void getCountriesContinentTestNull()
    {
        System.out.println(CountryReport.getCountriesContinent(null));
    }

    /**
     * checks getCountriesContinent function doesn't fail when an empty string is passed
     */
    @Test
    void getCountriesContinentTestEmpty()
    {
        System.out.println(CountryReport.getCountriesContinent(""));
    }

    /**
     * checks getCountriesContinent function
     */
    @Test
    void getCountriesContinentTest()
    {
        System.out.println(CountryReport.getCountriesContinent("Test"));
    }

    /**
     * checks getCountriesContinent function with different limits
     */
    @Test
    void getCountriesContinentTestLimits()
    {
        System.out.println(CountryReport.getCountriesContinent("Test", 1));
        System.out.println(CountryReport.getCountriesContinent("Test", 0));
        System.out.println(CountryReport.getCountriesContinent("Test", -1));
    }

    /**
     * checks getCountriesRegion function doesn't fail when null is passed
     */
    @Test
    void getCountriesRegionTestNull()
    {
        System.out.println(CountryReport.getCountriesRegion(null));
    }

    /**
     * checks getCountriesRegion function doesn't fail when an empty string is passed
     */
    @Test
    void getCountriesRegionTestEmpty()
    {
        System.out.println(CountryReport.getCountriesRegion(""));
    }

    /**
     * checks getCountriesRegion function
     */
    @Test
    void getCountriesRegionTest()
    {
        System.out.println(CountryReport.getCountriesRegion("Test"));
    }

    /**
     * checks getCountriesRegion function with different limits
     */
    @Test
    void getCountriesRegionTestLimits()
    {
        System.out.println(CountryReport.getCountriesRegion("Test", 1));
        System.out.println(CountryReport.getCountriesRegion("Test", 0));
        System.out.println(CountryReport.getCountriesRegion("Test", -1));
    }

    /**
     * checks that the app doesn't fail when the list is null
     */
    @Test
    void printAllCountriesTestNull()
    {
        CountryReport.printCountries(null);
    }

    /**
     * checks that the app doesn't fail when the list is empty
     */
    @Test
    void printCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<>();
        CountryReport.printCountries(countries);
    }

    /**
     * checks that the app doesn't fail when the list contains null
     */
    @Test
    void printCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        CountryReport.printCountries(countries);
    }



    /**
     * checks that the app functions with a normal entry
     */
    @Test
    void printCountriesTest()
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
        CountryReport.printCountries(countries);
    }

    /**
     * checks that the app functions with a normal entry
     */
    @Test
    void printCountriesTest2()
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
        CountryReport.printCountries(countries);
    }

    /*
    CityReport unit tests
     */
    /**
     * checks getCities function
     */
    @Test
    void getCitiesTest()
    {
        System.out.println(CityReport.getCities());
    }

    /**
     * checks getCities function with different limits
     */
    @Test
    void getCitiesTestLimits()
    {
        System.out.println(CityReport.getCities(1));
        System.out.println(CityReport.getCities(0));
        System.out.println(CityReport.getCities(-1));
    }

    /**
     * checks getCitiesContinent function doesn't fail when null is passed
     */
    @Test
    void getCitiesContinentTestNull()
    {
        System.out.println(CityReport.getCitiesContinent(null));
    }

    /**
     * checks getCitiesContinent function doesn't fail when an empty string is passed
     */
    @Test
    void getCitiesContinentTestEmpty()
    {
        System.out.println(CityReport.getCitiesContinent(""));
    }

    /**
     * checks getCitiesContinent function
     */
    @Test
    void getCitiesContinentTest()
    {
        System.out.println(CityReport.getCitiesContinent("Test"));
    }

    /**
     * checks getCitiesContinent function with different limits
     */
    @Test
    void getCitiesContinentTestLimits()
    {
        System.out.println(CityReport.getCitiesContinent("Test", 1));
        System.out.println(CityReport.getCitiesContinent("Test", 0));
        System.out.println(CityReport.getCitiesContinent("Test", -1));
    }

    /**
     * checks getCitiesRegion function doesn't fail when null is passed
     */
    @Test
    void getCitiesRegionTestNull()
    {
        System.out.println(CityReport.getCitiesRegion(null));
    }

    /**
     * checks getCitiesRegion function doesn't fail when an empty string is passed
     */
    @Test
    void getCitiesRegionTestEmpty()
    {
        System.out.println(CityReport.getCitiesRegion(""));
    }

    /**
     * checks getCitiesRegion function
     */
    @Test
    void getCitiesRegionTest()
    {
        System.out.println(CityReport.getCitiesRegion("Test"));
    }

    /**
     * checks getCitiesRegion function with different limits
     */
    @Test
    void getCitiesRegionTestLimits()
    {
        System.out.println(CityReport.getCitiesRegion("Test", 1));
        System.out.println(CityReport.getCitiesRegion("Test", 0));
        System.out.println(CityReport.getCitiesRegion("Test", -1));
    }

    /**
     * checks getCitiesCountry function doesn't fail when null is passed
     */
    @Test
    void getCitiesCountryTestNull()
    {
        System.out.println(CityReport.getCitiesCountry(null));
    }

    /**
     * checks getCitiesCountry function doesn't fail when an empty string is passed
     */
    @Test
    void getCitiesCountryTestEmpty()
    {
        System.out.println(CityReport.getCitiesCountry(""));
    }

    /**
     * checks getCitiesCountryfunction
     */
    @Test
    void getCitiesCountryTest()
    {
        System.out.println(CityReport.getCitiesCountry("Test"));
    }

    /**
     * checks getCitiesCountry function with different limits
     */
    @Test
    void getCitiesCountryTestLimits()
    {
        System.out.println(CityReport.getCitiesCountry("Test", 1));
        System.out.println(CityReport.getCitiesCountry("Test", 0));
        System.out.println(CityReport.getCitiesCountry("Test", -1));
    }

    /**
     * checks getCitiesDistrict function doesn't fail when null is passed
     */
    @Test
    void getCitiesDistrictTestNull()
    {
        System.out.println(CityReport.getCitiesDistrict(null));
    }

    /**
     * checks getCitiesCountry function doesn't fail when an empty string is passed
     */
    @Test
    void getCitiesDistrictTestEmpty()
    {
        System.out.println(CityReport.getCitiesDistrict(""));
    }

    /**
     * checks getCitiesDistrict function
     */
    @Test
    void getCitiesDistrictTest()
    {
        System.out.println(CityReport.getCitiesDistrict("Test"));
    }

    /**
     * checks getCitiesDistrict function with different limits
     */
    @Test
    void getCitiesDistrictTestLimits()
    {
        System.out.println(CityReport.getCitiesDistrict("Test", 1));
        System.out.println(CityReport.getCitiesDistrict("Test", 0));
        System.out.println(CityReport.getCitiesDistrict("Test", -1));
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

    /*
    CapitalCityReport unit tests
     */
    /**
     * checks getCapitalCities function
     */
    @Test
    void getCapitalCitiesTest()
    {
        System.out.println(CapitalCityReport.getCapitalCities());
    }

    /**
     * checks getCapitalCities function with different limits
     */
    @Test
    void getCapitalCitiesTestLimits()
    {
        System.out.println(CapitalCityReport.getCapitalCities(1));
        System.out.println(CapitalCityReport.getCapitalCities(0));
        System.out.println(CapitalCityReport.getCapitalCities(-1));
    }

    /**
     * checks getCapitalCitiesContinent function doesn't fail when null is passed
     */
    @Test
    void getCapitalCitiesContinentTestNull()
    {
        System.out.println(CapitalCityReport.getCapitalCitiesContinent(null));
    }

    /**
     * checks getCapitalCitiesContinent function doesn't fail when an empty string is passed
     */
    @Test
    void getCapitalCitiesContinentTestEmpty()
    {
        System.out.println(CapitalCityReport.getCapitalCitiesContinent(""));
    }

    /**
     * checks getCapitalCitiesContinent function
     */
    @Test
    void getCapitalCitiesContinentTest()
    {
        System.out.println(CapitalCityReport.getCapitalCitiesContinent("Test"));
    }

    /**
     * checks getCapitalCitiesContinent function with different limits
     */
    @Test
    void getCapitalCitiesContinentTestLimits()
    {
        System.out.println(CapitalCityReport.getCapitalCitiesContinent("Test", 1));
        System.out.println(CapitalCityReport.getCapitalCitiesContinent("Test", 0));
        System.out.println(CapitalCityReport.getCapitalCitiesContinent("Test", -1));
    }

    /**
     * checks getCapitalCitiesRegion function doesn't fail when null is passed
     */
    @Test
    void getCapitalCitiesRegionTestNull()
    {
        System.out.println(CapitalCityReport.getCapitalCitiesRegion(null));
    }

    /**
     * checks getCapitalCitiesRegion function doesn't fail when an empty string is passed
     */
    @Test
    void getCapitalCitiesRegionTestEmpty()
    {
        System.out.println(CapitalCityReport.getCapitalCitiesRegion(""));
    }

    /**
     * checks getCapitalCitiesRegion function
     */
    @Test
    void getCapitalCitiesRegionTest()
    {
        System.out.println(CapitalCityReport.getCapitalCitiesRegion("Test"));
    }

    /**
     * checks getCitiesRegion function with different limits
     */
    @Test
    void getCapitalCitiesRegionTestLimits()
    {
        System.out.println(CapitalCityReport.getCapitalCitiesRegion("Test", 1));
        System.out.println(CapitalCityReport.getCapitalCitiesRegion("Test", 0));
        System.out.println(CapitalCityReport.getCapitalCitiesRegion("Test", -1));
    }

    /**
     * checks that the app doesn't fail when the list is null
     */
    @Test
    void printCapitalCitiesTestNull()
    {
        CapitalCityReport.printCapitalCities(null);
    }

    /**
     * checks that the app doesn't fail when the list is empty
     */
    @Test
    void printCapitalCitiesTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<>();
        CapitalCityReport.printCapitalCities(cities);
    }

    /**
     * checks that the app doesn't fail when the list contains null
     */
    @Test
    void printCapitalCitiesTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        CapitalCityReport.printCapitalCities(cities);
    }

    /**
     * checks that the app functions with a normal entry
     */
    @Test
    void printCapitalCitiesTest()
    {
        ArrayList<City> cities = new ArrayList<>();
        City c = new City();
        c.setCountry("Scotland");
        c.setName("Edinburgh");
        c.setDistrict("Scotland");
        c.setPopulation(27);
        cities.add(c);
        CapitalCityReport.printCapitalCities(cities);
    }

    /*
    LanguageReport unit tests
     */
    /**
     * checks that the app doesn't fail when the list is null
     */
    @Test
    void printLanguagesTestNull()
    {
        LanguageReport.printLanguages(null);
    }

    /**
     * checks that the app doesn't fail when the list is empty
     */
    @Test
    void printLanguagesTestEmpty()
    {
        ArrayList<Language> languages = new ArrayList<>();
        LanguageReport.printLanguages(languages);
    }

    /**
     * checks that the app doesn't fail when the list contains null
     */
    @Test
    void printLanguagesTestContainsNull()
    {
        ArrayList<Language> languages = new ArrayList<>();
        languages.add(null);
        LanguageReport.printLanguages(languages);
    }

    /**
     * checks that the app functions with a normal entry
     */
    @Test
    void printLanguagesTest()
    {
        ArrayList<Language> languages = new ArrayList<>();
        Language l = new Language();
        l.setName("Language");
        l.setPopulation(1234567890L);
        l.setPercentage(42.0F);
        languages.add(l);

        LanguageReport.printLanguages(languages);
    }
    /*
    PopulationReport unit tests
     */
    /**
     * checks getContinentPopulation function doesn't fail when null is passed
     */
    @Test
    void getContinentPopulationTestNull()
    {
        System.out.println(PopulationReport.getContinentPopulation(null));
    }

    /**
     * checks getContinentPopulation function doesn't fail when an empty string is passed
     */
    @Test
    void getContinentPopulationTestEmpty()
    {
        System.out.println(PopulationReport.getContinentPopulation(""));
    }

    /**
     * checks getContinentPopulation function
     */
    @Test
    void getContinentPopulationTest()
    {
        System.out.println(PopulationReport.getContinentPopulation("Test"));
    }

    /**
     * checks getRegionPopulation function doesn't fail when null is passed
     */
    @Test
    void getRegionPopulationTestNull()
    {
        System.out.println(PopulationReport.getRegionPopulation(null));
    }

    /**
     * checks getRegionPopulation function doesn't fail when an empty string is passed
     */
    @Test
    void getRegionPopulationTestEmpty()
    {
        System.out.println(PopulationReport.getRegionPopulation(""));
    }

    /**
     * checks getRegionPopulation function
     */
    @Test
    void getRegionPopulationTest()
    {
        System.out.println(PopulationReport.getRegionPopulation("Test"));
    }

    /**
     * checks getCountryPopulation function doesn't fail when null is passed
     */
    @Test
    void getCountryPopulationTestNull()
    {
        System.out.println(PopulationReport.getCountryPopulation(null));
    }

    /**
     * checks getCountryPopulation function doesn't fail when an empty string is passed
     */
    @Test
    void getCountryPopulationTestEmpty()
    {
        System.out.println(PopulationReport.getCountryPopulation(""));
    }

    /**
     * checks getCountryPopulation function
     */
    @Test
    void getCountryPopulationTest()
    {
        System.out.println(PopulationReport.getCountryPopulation("Test"));
    }

    /**
     * checks getWorldPop function
     */
    @Test
    void getWorldPopTest()
    {
        System.out.println(PopulationReport.getWorldPop());
    }

    /**
     * checks getContinentPop function doesn't fail when null is passed
     */
    @Test
    void getContinentPopTestNull()
    {
        System.out.println(PopulationReport.getContinentPop(null));
    }

    /**
     * checks getContinentPop function doesn't fail when an empty string is passed
     */
    @Test
    void getContinentPopTestEmpty()
    {
        System.out.println(PopulationReport.getContinentPop(""));
    }

    /**
     * checks getContinentPop function
     */
    @Test
    void getContinentPopTest()
    {
        System.out.println(PopulationReport.getContinentPop("Test"));
    }

    /**
     * checks getRegionPop function doesn't fail when null is passed
     */
    @Test
    void getRegionPopTestNull()
    {
        System.out.println(PopulationReport.getRegionPop(null));
    }

    /**
     * checks getRegionPop function doesn't fail when an empty string is passed
     */
    @Test
    void getRegionPopTestEmpty()
    {
        System.out.println(PopulationReport.getRegionPop(""));
    }

    /**
     * checks getRegionPop function
     */
    @Test
    void getRegionPopTest()
    {
        System.out.println(PopulationReport.getRegionPop("Test"));
    }

    /**
     * checks getCountryPop function doesn't fail when null is passed
     */
    @Test
    void getCountryPopTestNull()
    {
        System.out.println(PopulationReport.getCountryPop(null));
    }

    /**
     * checks getCountryPop function doesn't fail when an empty string is passed
     */
    @Test
    void getCountryPopTestEmpty()
    {
        System.out.println(PopulationReport.getCountryPop(""));
    }

    /**
     * checks getCountryPop function
     */
    @Test
    void getCountryPopTest()
    {
        System.out.println(PopulationReport.getCountryPop("Test"));
    }

    /**
     * checks getDistrictPop function doesn't fail when null is passed
     */
    @Test
    void getDistrictPopTestNull()
    {
        System.out.println(PopulationReport.getDistrictPop(null));
    }

    /**
     * checks getCountryPop function doesn't fail when an empty string is passed
     */
    @Test
    void getDistrictPopTestEmpty()
    {
        System.out.println(PopulationReport.getDistrictPop(""));
    }

    /**
     * checks getDistrictPop function
     */
    @Test
    void getDistrictPopTest()
    {
        System.out.println(PopulationReport.getDistrictPop("Test"));
    }

    /**
     * checks getCityPop function doesn't fail when null is passed
     */
    @Test
    void getCityPopTestNull()
    {
        System.out.println(PopulationReport.getCityPop(null));
    }

    /**
     * checks getCityPop function doesn't fail when an empty string is passed
     */
    @Test
    void getCityPopTestEmpty()
    {
        System.out.println(PopulationReport.getCityPop(""));
    }

    /**
     * checks getCityPop function
     */
    @Test
    void getCityPopTest()
    {
        System.out.println(PopulationReport.getCityPop("Test"));
    }

    /**
     * checks that the app doesn't fail when null is passed
     */
    @Test
    void printPopulationTestNull()
    {
        PopulationReport.printPopulation(null);
    }

    /**
     * checks that the app doesn't fail when the population is empty
     */
    @Test
    void printPopulationTestEmpty()
    {
        Population population = new Population();
        PopulationReport.printPopulation(population);
    }

    /**
     * checks that the app doesn't fail when the population contains null
     */
    @Test
    void printPopulationTestContainsNull()
    {
        Population population = new Population();
        population.setName(null);
        population.setCityPopulation(1L);
        population.setOutOfCityPopulation(1L);
        population.setPopulation(1L);
        PopulationReport.printPopulation(population);
    }

    /**
     * checks that the app functions with a normal entry
     */
    @Test
    void printPopulationTest()
    {
        Population population = new Population();
        population.setName("Test");
        population.setCityPopulation(1L);
        population.setOutOfCityPopulation(1L);
        population.setPopulation(1L);
        PopulationReport.printPopulation(population);
    }
}
