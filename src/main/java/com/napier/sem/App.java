package com.napier.sem;

import com.napier.sem.businessObjects.*;
import com.napier.sem.businessObjects.reports.*;
import java.sql.*;
import java.util.ArrayList;

public class App
{
    private static Connection con = null;

    /**
     * Main function generates reports in docker outlined in the specification
     * reports generated currently:
     * -All the countries in the world organised by largest population to smallest.
     * -All the countries in a continent organised by largest population to smallest.
     * -All the countries in a region organised by largest population to smallest.
     * -The top N populated countries in the world where N is provided by the user.
     * -The top N populated countries in a continent where N is provided by the user.
     * -The top N populated countries in a region where N is provided by the user.
     * -All the cities in the world organised by largest population to smallest.
     * -All the cities in a continent organised by largest population to smallest.
     **/
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        if(args.length < 1){
            a.connect("localhost:33060", 30000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        //Country reports

        //Report 1
        //create ArrayList containing all countries
        ArrayList<Country> countries = CountryReport.getAllCountries(con);
        // Print all countries in the world db
        CountryReport.printAllCountries(countries);
        System.out.println("\r\n \r\n");

        //Report 2
        //print all countries in a continent (Europe can be changed to whichever continent)
        String continent = "Europe"; //<-change to desired continent
        CountryReport.printCountriesContinent(countries, continent);
        System.out.println("\r\n \r\n");

        //Report 3
        //print all countries in a region (SA can be changed to whichever continent)
        String region = "South America"; //<-change to desired region
        CountryReport.printCountriesRegion(countries, region);
        System.out.println("\r\n \r\n");

        //Report 4
        //print  the "n" highest population countries in the world
        int limit = 5; //<-change to desired number of outputs
        CountryReport.printAllCountries(countries, limit);
        System.out.println("\r\n \r\n");

        //Report 5
        //print  the "n" highest population countries in a continent
        limit = 7; //<-change to desired number of outputs
        continent = "Africa"; //<-change to desired continent
        CountryReport.printCountriesContinent(countries, continent, limit);
        System.out.println("\r\n \r\n");

        //Report 6
        //print  the "n" highest population countries in a Region
        limit = 5; //<-change to desired number of outputs
        region = "Eastern Asia"; //<-change to desired continent
        CountryReport.printCountriesRegion(countries, region, limit);
        System.out.println("\r\n \r\n");


        //City reports

        //Report 7
        //create ArrayList of all cities in the world
        ArrayList<City> cities = CityReport.getAllCities(con);
        //print all cities in the world db in order of population
        System.out.println("All the cities in the world from largest population to smallest. \r\n");
        CityReport.printCities(cities);
        System.out.println("\r\n \r\n");

        //Report 8
        //create ArrayList of all cities in a continent
        continent = "Oceania";  //<-change to desired continent
        ArrayList<City> citiesContinent = CityReport.getAllCitiesContinent(con, continent);
        //print all cities in the world db in order of population
        System.out.println("All the cities in " + continent + " from largest population to smallest. \r\n");
        CityReport.printCities(citiesContinent);
        System.out.println("\r\n \r\n");

        //Report 9
        //create ArrayList of all cities in a region
        region = "Southern Europe";  //<-change to desired continent
        ArrayList<City> citiesRegion = CityReport.getAllCitiesRegion(con, region);
        //print all cities in the world db in order of population
        System.out.println("All the cities in " + region + " from largest population to smallest. \r\n");
        CityReport.printCities(citiesRegion);
        System.out.println("\r\n \r\n");

        //Report 9
        //create ArrayList of all cities in a country
        String country = "United Kingdom";  //<-change to desired continent
        ArrayList<City> citiesCountry = CityReport.getAllCitiesCountry(con, country);
        //print all cities in the world db in order of population
        System.out.println("All the cities in " + country + " from largest population to smallest. \r\n");
        CityReport.printCities(citiesCountry);
        System.out.println("\r\n \r\n");

        //Report 10
        //create ArrayList of all cities in a district
        String district = "Scotland";  //<-change to desired continent
        ArrayList<City> citiesDistrict = CityReport.getAllCitiesDistrict(con, district);
        //print all cities in the world db in order of population
        System.out.println("All the cities in " + district + " from largest population to smallest. \r\n");
        CityReport.printCities(citiesDistrict);
        System.out.println("\r\n \r\n");

        // Disconnect from database
        a.disconnect();
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
                                + "/employees?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
                System.out.println("Successfully closed connection to database");
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
}
