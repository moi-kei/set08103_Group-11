package com.napier.sem;

import com.napier.sem.businessObjects.Population;
import com.napier.sem.businessObjects.reports.*;

import java.sql.*;

/**
 * Main entry point for the application
 * SET08103
 * Group 11 coursework
 * {@code @Authors:}  Michael Mackenzie, Nweke Success
 */
public class App {
    static Connection con = null;

    /**
     * All the countries in the world organised by largest population to smallest.
     * All the countries in a continent organised by largest population to smallest.
     * All the countries in a region organised by largest population to smallest.
     * The top N populated countries in the world where N is provided by the user.
     * The top N populated countries in a continent where N is provided by the user.
     * The top N populated countries in a region where N is provided by the user.
     * All the cities in the world organised by largest population to smallest.
     * All the cities in a continent organised by largest population to smallest.
     * All the cities in a region organised by largest population to smallest.
     * All the cities in a country organised by largest population to smallest.
     * All the cities in a district organised by largest population to smallest.
     * The top N populated cities in the world where N is provided by the user.
     * The top N populated cities in a continent where N is provided by the user.
     * The top N populated cities in a region where N is provided by the user.
     * The top N populated cities in a country where N is provided by the user.
     * The top N populated cities in a district where N is provided by the user.
     * All the capital cities in the world organised by largest population to smallest.
     * All the capital cities in a continent organised by largest population to smallest.
     * All the capital cities in a region organised by largest to smallest.
     * The top N populated capital cities in the world where N is provided by the user.
     * The top N populated capital cities in a continent where N is provided by the user.
     * The top N populated capital cities in a region where N is provided by the user.
     * The population of people, people living in cities, and people not living in cities in each continent.
     * The population of people, people living in cities, and people not living in cities in each region.
     * The population of people, people living in cities, and people not living in cities in each country.
     * The population of the world.
     * The population of a continent.
     * The population of a region.
     * The population of a country.
     * The population of a district.
     * The population of a city.
     * Produces a report of the number of people speaking:
     * Chinese.
     * English.
     * Hindi.
     * Spanish.
     * Arabic.
     **/
    public static void main(String[] args) {
        // Create new Application
        App a = new App();
        // Connect to database
        if (args.length < 1) {
            a.connect("localhost:33060", 30000);
        } else {
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        if (con != null) {

        /*
          Country reports
        */

            //Report 1
            // All the countries in the world organised by largest population to smallest.
            System.out.println("All the countries in the world from largest population to smallest. \r\n");
            CountryReport.printCountries(CountryReport.ExecuteQuery(con, CountryReport.getCountries()));
            System.out.println("\r\n \r\n");

            //Report 2
            //All the countries in a continent organised by largest population to smallest.
            String continent = "Europe"; //<-change to desired continent
            System.out.println("All the countries in " + continent + " from largest population to smallest. \r\n");
            CountryReport.printCountries(CountryReport.ExecuteQuery(con, CountryReport.getCountriesContinent(continent)));
            System.out.println("\r\n \r\n");

            //Report 3
            //All the countries in a region organised by largest population to smallest.
            String region = "South America"; //<-change to desired region
            System.out.println("All the countries in " + region + " from largest population to smallest. \r\n");
            CountryReport.printCountries(CountryReport.ExecuteQuery(con, CountryReport.getCountriesRegion(region)));
            System.out.println("\r\n \r\n");

            //Report 4
            //The top N populated countries in the world where N is provided by the user.
            int limit = 5; //<-change to desired number of outputs
            System.out.println("The top " + limit + " countries in the world from largest population to smallest. \r\n");
            CountryReport.printCountries(CountryReport.ExecuteQuery(con, CountryReport.getCountries(limit)));
            System.out.println("\r\n \r\n");

            //Report 5
            //The top N populated countries in a continent where N is provided by the user.
            limit = 7; //<-change to desired number of outputs
            continent = "Africa"; //<-change to desired continent
            System.out.println("The top " + limit + " countries in " + continent + " from largest population to smallest. \r\n");
            CountryReport.printCountries(CountryReport.ExecuteQuery(con, CountryReport.getCountriesContinent(continent, limit)));
            System.out.println("\r\n \r\n");

            //Report 6
            //The top N populated countries in a region where N is provided by the user.
            limit = 5; //<-change to desired number of outputs
            region = "Eastern Asia"; //<-change to desired region
            System.out.println("The top " + limit + " the countries in " + region + " from largest population to smallest. \r\n");
            CountryReport.printCountries(CountryReport.ExecuteQuery(con, CountryReport.getCountriesRegion(region, limit)));
            System.out.println("\r\n \r\n");


        /*
          City reports
        */

            //Report 7
            //All the cities in the world organised by largest population to smallest.
            System.out.println("All the cities in the world from largest population to smallest. \r\n");
            CityReport.printCities(CityReport.ExecuteQuery(con, CityReport.getCities()));
            System.out.println("\r\n \r\n");

            //Report 8
            //All the cities in a continent organised by largest population to smallest.
            continent = "Oceania";  //<-change to desired continent
            System.out.println("All the cities in " + continent + " from largest population to smallest. \r\n");
            CityReport.printCities(CityReport.ExecuteQuery(con, CityReport.getCitiesContinent(continent)));
            System.out.println("\r\n \r\n");

            //Report 9
            //All the cities in a region organised by largest population to smallest.
            region = "Southern Europe";  //<-change to desired region
            System.out.println("All the cities in " + region + " from largest population to smallest. \r\n");
            CityReport.printCities(CityReport.ExecuteQuery(con, CityReport.getCitiesRegion(region)));
            System.out.println("\r\n \r\n");

            //Report 10
            //All the cities in a country organised by largest population to smallest.
            String country = "United Kingdom";  //<-change to desired country
            System.out.println("All the cities in " + country + " from largest population to smallest. \r\n");
            CityReport.printCities(CityReport.ExecuteQuery(con, CityReport.getCitiesCountry(country)));
            System.out.println("\r\n \r\n");

            //Report 11
            //All the cities in a district organised by largest population to smallest.
            String district = "Scotland";  //<-change to desired district
            System.out.println("All the cities in " + district + " from largest population to smallest. \r\n");
            CityReport.printCities(CityReport.ExecuteQuery(con, CityReport.getCitiesDistrict(district)));
            System.out.println("\r\n \r\n");

            //Report 12
            //The top N populated cities in the world where N is provided by the user.
            limit = 10;  //<-change to desired number of outputs
            System.out.println("The top " + limit + " cities in the world from largest population to smallest. \r\n");
            CityReport.printCities(CityReport.ExecuteQuery(con, CityReport.getCities(limit)));
            System.out.println("\r\n \r\n");

            //Report 13
            //The top N populated cities in a continent where N is provided by the user.
            continent = "Asia";  //<-change to desired continent
            limit = 8;  //<-change to desired number of outputs

            System.out.println("The top " + limit + " cities in " + continent + " from largest population to smallest. \r\n");
            CityReport.printCities(CityReport.ExecuteQuery(con, CityReport.getCitiesContinent(continent, limit)));
            System.out.println("\r\n \r\n");

            //Report 14
            //The top N populated cities in a region where N is provided by the user.
            region = "Southern Europe";  //<-change to desired region
            limit = 5;  //<-change to desired number of outputs
            System.out.println("The top " + limit + " cities in " + region + " from largest population to smallest. \r\n");
            CityReport.printCities(CityReport.ExecuteQuery(con, CityReport.getCitiesRegion(region, limit)));
            System.out.println("\r\n \r\n");

            //Report 15
            //The top N populated cities in a country where N is provided by the user.
            country = "United Kingdom";  //<-change to desired country
            limit = 7;  //<-change to desired number of outputs
            System.out.println("The top " + limit + " cities in " + country + " from largest population to smallest. \r\n");
            CityReport.printCities(CityReport.ExecuteQuery(con, CityReport.getCitiesCountry(country, limit)));
            System.out.println("\r\n \r\n");

            //Report 16
            //The top N populated cities in a district where N is provided by the user.
            district = "Scotland";  //<-change to desired district
            limit = 3;  //<-change to desired number of outputs
            System.out.println("The top " + limit + " cities in " + district + " from largest population to smallest. \r\n");
            CityReport.printCities(CityReport.ExecuteQuery(con, CityReport.getCitiesDistrict(district, limit)));
            System.out.println("\r\n \r\n");

        /*
        Capital City reports
        */

            //Report 17
            //All the capital cities in the world organised by largest population to smallest.
            System.out.println("All the capital cities in the world from largest population to smallest. \r\n");
            CapitalCityReport.printCapitalCities(CityReport.ExecuteQuery(con, CapitalCityReport.getCapitalCities()));
            System.out.println("\r\n \r\n");

            //Report 18
            //All the capital cities in a continent organised by largest population to smallest.
            continent = "Europe";  //<-change to desired continent
            System.out.println("All the capital cities in " + continent + " from largest population to smallest. \r\n");
            CapitalCityReport.printCapitalCities(CityReport.ExecuteQuery(con, CapitalCityReport.getCapitalCitiesContinent(continent)));
            System.out.println("\r\n \r\n");

            //Report 19
            //All the capital cities in a region organised by largest to smallest.
            region = "South America";  //<-change to desired region
            System.out.println("All the capital cities in " + region + " from largest population to smallest. \r\n");
            CapitalCityReport.printCapitalCities(CityReport.ExecuteQuery(con, CapitalCityReport.getCapitalCitiesRegion(region)));
            System.out.println("\r\n \r\n");

            //Report 20
            //The top N populated capital cities in the world where N is provided by the user.
            limit = 10;  //<-change to desired number of outputs
            System.out.println("The top " + limit + " capital cities in the world from largest population to smallest. \r\n");
            CapitalCityReport.printCapitalCities(CityReport.ExecuteQuery(con, CapitalCityReport.getCapitalCities(limit)));
            System.out.println("\r\n \r\n");

            //Report 21
            //The top N populated capital cities in a continent where N is provided by the user.
            limit = 5;  //<-change to desired number of outputs
            continent = "Africa";  //<-change to desired continent
            System.out.println("The top " + limit + " capital cities in " + continent + " from largest population to smallest. \r\n");
            CapitalCityReport.printCapitalCities(CityReport.ExecuteQuery(con, CapitalCityReport.getCapitalCitiesContinent(continent, limit)));
            System.out.println("\r\n \r\n");

            //Report 22
            //The top N populated capital cities in a region where N is provided by the user.
            region = "Southern Europe";  //<-change to desired region
            limit = 4; //<-change to desired number of outputs
            System.out.println("The top " + limit + " capital cities in " + region + " from largest population to smallest. \r\n");
            CapitalCityReport.printCapitalCities(CityReport.ExecuteQuery(con, CapitalCityReport.getCapitalCitiesRegion(region, limit)));
            System.out.println("\r\n \r\n");

        /*
        Population reports
        */

            //Report 23
            //The population of people, people living in cities, and people not living in cities in each continent.
            continent = "Europe"; //<-change to desired continent
            Population continentPopulation = PopulationReport.ExecuteQuery(con, PopulationReport.getContinentPopulation(continent), continent);
            PopulationReport.printPopulation(continentPopulation);
            System.out.println("\r\n \r\n");

            //Report 24
            //The population of people, people living in cities, and people not living in cities in each region.
            region = "Caribbean"; //<-change to desired region
            Population regionPopulation = PopulationReport.ExecuteQuery(con, PopulationReport.getRegionPopulation(region), region);
            PopulationReport.printPopulation(regionPopulation);
            System.out.println("\r\n \r\n");

            //Report 25
            //The population of people, people living in cities, and people not living in cities in each country.
            country = "ThaiLand"; //<-change to desired country
            Population countryPopulation = PopulationReport.ExecuteQuery(con, PopulationReport.getCountryPopulation(country), country);
            PopulationReport.printPopulation(countryPopulation);
            System.out.println("\r\n \r\n");

            //report 26
            //The population of the world.
            System.out.println("The population of the world is: " + PopulationReport.ExecuteQuery(con, PopulationReport.getWorldPop()));
            System.out.println("\r\n \r\n");

            //report 27
            //The population of a continent.
            continent = "Africa"; //<-change to desired continent
            System.out.println("The population of " + continent + " is: " + PopulationReport.ExecuteQuery(con, PopulationReport.getContinentPop(continent)));
            System.out.println("\r\n \r\n");

            //report 28
            //The population of a region.
            region = "Eastern Europe"; //<-change to desired region
            System.out.println("The population of " + region + " is: " + PopulationReport.ExecuteQuery(con, PopulationReport.getRegionPop(region)));
            System.out.println("\r\n \r\n");

            //report 29
            //The population of a country.
            country = "United States"; //<-change to desired country
            System.out.println("The population of " + country + " is: " + PopulationReport.ExecuteQuery(con, PopulationReport.getCountryPop(country)));
            System.out.println("\r\n \r\n");

            //report 30
            //The population of a district.
            district = "Scotland"; //<-change to desired district
            System.out.println("The population of " + district + " is: " + PopulationReport.ExecuteQuery(con, PopulationReport.getDistrictPop(district)));
            System.out.println("\r\n \r\n");

            //report 31
            //The population of a city.
            String city = "Edinburgh"; //<-change to desired city
            System.out.println("The population of " + city + " is: " + PopulationReport.ExecuteQuery(con, PopulationReport.getCityPop(city)));
            System.out.println("\r\n \r\n");

        /*
        Language reports
        */

            //report 32
            //Produces a report of the number of people speaking: Chinese, English, Hindi, Spanish, Arabic.
            LanguageReport.printLanguages(LanguageReport.getLanguages(con));

            // Disconnect from database
            a.disconnect();
        } else {
            System.out.println("Couldn't generate reports");
        }
    }

    /**
     * Connect to the MySQL database
     */
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
                con = null;
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
                System.out.println("Successfully closed connection to database");
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }
}
