package com.napier.sem.businessObjects.reports;

import com.napier.sem.businessObjects.Population;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PopulationReport {

    public static String getContinentPopulation(String continent) {
        return
                "SELECT SUM(DISTINCT country.Population), SUM(DISTINCT city.Population), SUM(DISTINCT country.Population) - SUM(DISTINCT city.Population) "
                        + "FROM city JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Continent LIKE '" + continent + "'";
    }

    public static String getRegionPopulation(String region) {
        return
                "SELECT SUM(DISTINCT country.Population), SUM(DISTINCT city.Population), SUM(DISTINCT country.Population) - SUM(DISTINCT city.Population) "
                        + "FROM city JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Region LIKE '" + region + "'";
    }

    public static String getCountryPopulation(String country) {
        return
                "SELECT SUM(DISTINCT country.Population), SUM(DISTINCT city.Population), SUM(DISTINCT country.Population) - SUM(DISTINCT city.Population) "
                        + "FROM city JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Name LIKE '" + country + "'";
    }

    public static String getWorldPop() {
        return
                "SELECT SUM(DISTINCT country.Population) "
                        + "FROM country";
    }

    public static String getContinentPop(String continent) {
        return
                "SELECT SUM(DISTINCT Population) "
                        + "FROM country "
                        + "WHERE Continent LIKE '" + continent + "'";
    }

    public static String getRegionPop(String region) {
        return
                "SELECT SUM(DISTINCT Population) "
                        + "FROM country "
                        + "WHERE Region LIKE '" + region + "'";
    }

    public static String getCountryPop(String country) {
        return
                "SELECT Population "
                        + "FROM country "
                        + "WHERE Name LIKE '" + country + "'";
    }

    public static String getDistrictPop(String district) {
        return
                "SELECT SUM(DISTINCT Population) "
                        + "FROM city "
                        + "WHERE District LIKE '" + district + "'";
    }

    public static String getCityPop(String city) {
        return
                "SELECT Population "
                        + "FROM city "
                        + "WHERE Name LIKE '" + city + "'";
    }

    public static Population ExecuteQuery(Connection con, String query, String location){

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            //get ResultSet
            ResultSet rset = stmt.executeQuery(query);
            //return population
            rset.next();
            Population pop = new Population();
            pop.setName(location);
            pop.setPopulation(rset.getLong(1));
            pop.setCityPopulation(rset.getLong(2));
            pop.setOutOfCityPopulation(rset.getLong(3));

                return pop;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public static String ExecuteQuery(Connection con, String query){

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            //get ResultSet
            ResultSet rset = stmt.executeQuery(query);
            //return population
            rset.next();
            return rset.getString(1);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public static void printPopulation(Population population){

        if (population != null) {
            try {
                System.out.println("Total population of " + population.getName() + ": " + population.getPopulation());
                System.out.println("Total population in cities of " + population.getName() + ": " + population.getCityPopulation());
                System.out.println("Total population not in cities of " + population.getName() + ": " + population.getOutOfCityPopulation());
            }
            catch (Exception e) {
                System.out.println("Couldn't print population");
            }
        }
        else {

            System.out.println("couldn't print population details");
        }
    }
}
