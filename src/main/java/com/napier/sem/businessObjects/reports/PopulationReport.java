package com.napier.sem.businessObjects.reports;

import com.napier.sem.businessObjects.Population;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Class acting as a container for static function related to creating Population reports
 * {@code @Authors:} Michael Mackenzie, Nweke Success
 */
public class PopulationReport {

    /**
     * Builds a sql query for getting the population details of a continent
     *
     * @param continent the continent you want the population of
     * @return a sql query as a string for getting the population details of a continent
     */
    public static String getContinentPopulation(String continent) {
        return
                "SELECT SUM(DISTINCT country.Population), SUM(DISTINCT city.Population), SUM(DISTINCT country.Population) - SUM(DISTINCT city.Population) "
                        + "FROM city JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Continent LIKE '" + continent + "'";
    }

    /**
     * Builds a sql query for getting the population details of a region
     *
     * @param region the region you want the population of
     * @return a sql query as a string for getting the population details of a region
     */
    public static String getRegionPopulation(String region) {
        return
                "SELECT SUM(DISTINCT country.Population), SUM(DISTINCT city.Population), SUM(DISTINCT country.Population) - SUM(DISTINCT city.Population) "
                        + "FROM city JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Region LIKE '" + region + "'";
    }

    /**
     * Builds a sql query for getting the population details of a country
     *
     * @param country the country you want the population of
     * @return a sql query as a string for getting the population details of a country
     */
    public static String getCountryPopulation(String country) {
        return
                "SELECT SUM(DISTINCT country.Population), SUM(DISTINCT city.Population), SUM(DISTINCT country.Population) - SUM(DISTINCT city.Population) "
                        + "FROM city JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Name LIKE '" + country + "'";
    }

    /**
     * Builds a sql query for getting just the population of the world
     *
     * @return a sql query as a string for getting the population details of a continent
     */
    public static String getWorldPop() {
        return
                "SELECT SUM(DISTINCT country.Population) "
                        + "FROM country";
    }

    /**
     * Builds a sql query for getting just the population of a continent
     *
     * @param continent a string representing the continent you want the population of
     * @return a sql query as a string for getting the population details of a continent
     */
    public static String getContinentPop(String continent) {
        return
                "SELECT SUM(DISTINCT Population) "
                        + "FROM country "
                        + "WHERE Continent LIKE '" + continent + "'";
    }

    /**
     * Builds a sql query for getting just the population of a region
     *
     * @param region a string representing the region you want the population of
     * @return a sql query as a string for getting the population details of a region
     */
    public static String getRegionPop(String region) {
        return
                "SELECT SUM(DISTINCT Population) "
                        + "FROM country "
                        + "WHERE Region LIKE '" + region + "'";
    }

    /**
     * Builds a sql query for getting just the population of a country
     *
     * @param country a string representing the country you want the population of
     * @return a sql query as a string for getting the population details of a country
     */
    public static String getCountryPop(String country) {
        return
                "SELECT Population "
                        + "FROM country "
                        + "WHERE Name LIKE '" + country + "'";
    }

    /**
     * Builds a sql query for getting just the population of a district
     *
     * @param district a string representing the district you want the population of
     * @return a sql query as a string for getting the population details of a district
     */
    public static String getDistrictPop(String district) {
        return
                "SELECT SUM(DISTINCT Population) "
                        + "FROM city "
                        + "WHERE District LIKE '" + district + "'";
    }

    /**
     * Builds a sql query for getting just the population of a city
     *
     * @param city a string representing the city you want the population of
     * @return a sql query as a string for getting the population details of a city
     */
    public static String getCityPop(String city) {
        return
                "SELECT Population "
                        + "FROM city "
                        + "WHERE Name LIKE '" + city + "'";
    }

    /**
     * Executes a query on the db and build a detailed population report
     *
     * @param con the connection to the db
     * @param query the query to be executed
     * @param location the place you want the population of
     * @return a detailed Population report
     */
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

    /**
     * Executes a query on the db and returns only the population
     *
     * @param con the connection to the db
     * @param query the query to be executed
     * @return a string with the total population
     */
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

    /**
     * prints a population report
     *
     * @param population the population report you want to be printed
     */
    public static void printPopulation(Population population){

        if (population != null) {

            System.out.println("Total population of " + population.getName() + ": " + population.getPopulation());
            System.out.println("Total population in cities of " + population.getName() + ": " + population.getCityPopulation());
            System.out.println("Total population not in cities of " + population.getName() + ": " + population.getOutOfCityPopulation());
        }
        else {

            System.out.println("couldn't print population details");
        }
    }
}
