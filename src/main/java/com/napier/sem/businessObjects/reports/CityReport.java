package com.napier.sem.businessObjects.reports;

import com.napier.sem.businessObjects.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class acting as a container for static function related to creating city reports
 * {@code @Authors:} Michael Mackenzie, Nweke Success
 */
public class CityReport {

    /**
     * builds SQL query to get city details passed to it
     *
     * @return a query for getting all cities from the db
     */
    public static String getCities() {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "ORDER BY city.population DESC";
    }

    /**
     * builds SQL query to get city details passed to it
     *
     * @param limit the number of entries to get from database
     * @return a query for getting a number of cities from the db
     */
    public static String getCities(int limit) {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "ORDER BY city.population DESC LIMIT " + limit;
    }

    /**
     * builds SQL query using the continent string passed to it
     *
     * @param continent the continent the listed cities will be from
     * @return a query for getting all cities in a continent from the db
     */
    public static String getCitiesContinent(String continent) {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Continent LIKE '" + continent
                        + "' ORDER BY city.population DESC";
    }

    /**
     * builds SQL query using the continent string passed to it
     *
     * @param continent the continent the listed cities will be from
     * @param limit     the number of entries to get from database
     * @return a query for getting a number of cities in a continent from the db
     */
    public static String getCitiesContinent(String continent, int limit) {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Continent LIKE '" + continent
                        + "' ORDER BY city.population DESC LIMIT " + limit;
    }

    /**
     * builds SQL query using the region string passed to it
     *
     * @param region the region the listed cities will be from
     * @return a query for getting all cities in a region from the db
     */
    public static String getCitiesRegion(String region) {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Region LIKE '" + region
                        + "' ORDER BY city.population DESC";
    }

    /**
     * builds SQL query using the region string passed to it
     *
     * @param region the region the listed cities will be from
     * @param limit  the number of entries to get from database
     * @return a query for getting a number of cities in a region from the db
     */
    public static String getCitiesRegion(String region, int limit) {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Region LIKE '" + region
                        + "' ORDER BY city.population DESC LIMIT " + limit;
    }

    /**
     * builds SQL query using the region string passed to it
     *
     * @param country the country the listed cities will be from
     * @return a query for getting all cities in a country from the db
     */
    public static String getCitiesCountry(String country) {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Name LIKE '" + country
                        + "' ORDER BY city.population DESC";
    }

    /**
     * builds SQL query using the region string passed to it
     *
     * @param country the country the listed cities will be from
     * @param limit   the number of entries to get from database
     * @return a query for getting a number of cities in a country from the db
     */
    public static String getCitiesCountry(String country, int limit) {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Name LIKE '" + country
                        + "' ORDER BY city.population DESC LIMIT " + limit;
    }

    /**
     * builds SQL query using the region string passed to it
     *
     * @param district the country the listed cities will be from
     * @return a query for getting all cities in a district from the db
     */
    public static String getCitiesDistrict(String district) {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE city.District LIKE '" + district
                        + "' ORDER BY city.population DESC";
    }

    /**
     * builds SQL query using the region string passed to it
     *
     * @param district the country the listed cities will be from
     * @param limit    the number of entries to get from database
     * @return a query for getting a number of cities in a district from the db
     */
    public static String getCitiesDistrict(String district, int limit) {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE city.District LIKE '" + district
                        + "' ORDER BY city.population DESC LIMIT " + limit;
    }

    /**
     * Executes a sql query, builds a list of cities from the result set and returns that list
     *
     * @param con   the connection to the db
     * @param query the query to be executed
     * @return a List of cities
     */
    public static ArrayList<City> ExecuteQuery(Connection con, String query) {

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            //get ResultSet
            ResultSet rset = stmt.executeQuery(query);
            //pass to buildCityList to construct ArrayList of cities
            return buildCityList(rset);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * constructs a city, assigns variables based on sql entry
     * then adds the city to an Arraylist which is returned
     *
     * @param rset ResultSet returned from the SQL query
     * @return all cities in the world db in order of population from largest to smallest
     */
    public static ArrayList<City> buildCityList(ResultSet rset) {
        try {
            // Create arrayList for cities
            ArrayList<City> cities = new ArrayList<>();
            // Create new country and assign variables
            while (rset.next()) {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountry(rset.getString("country.name"));
                c.setDistrict(rset.getString("city.District"));
                c.setPopulation(rset.getInt("city.Population"));
                cities.add(c);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * prints all cities in the arraylist provided to it
     *
     * @param cities An ArrayList of cities
     */
    public static void printCities(ArrayList<City> cities) {

        if (cities == null) {
            System.out.println("No cities");
            return;
        }
        //print headers
        System.out.printf("%-36s %-46s %-22s %-11s%n", "Name", "| Country ", "| District ", "| Population ");
        System.out.printf("%-36s %-46s %-22s %-11s%n", " ", "|", "|", "|");

        // Print countries
        for (City c : cities) {
            if (c != null) {
                System.out.printf("%-36s %-46s %-22s %-11s%n", c.getName(), "| " + c.getCountry(), "| " + c.getDistrict(), "| " + c.getPopulation());
            } else {
                System.out.println("Couldn't print city details");
            }
        }
    }
}
