package com.napier.sem.businessObjects.reports;

import com.napier.sem.businessObjects.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class acting as a container for static function related to creating city reports*
 * {@code @Authors:} Michael Mackenzie, Nweke Success
 */
public class CityReport {

    /**
     * builds SQL query to get city details passed to it
     * passes the query to the executeCityQuery function to execute
     * then returns the list of cities that it created
     *
     * @return all cities in the world db in order of population from largest to smallest
     * @param con the connection to the database
     */
    public static ArrayList<City> getAllCities(Connection con){

        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                //construct SQL query
                String strSelect =
                        "SELECT city.Name, country.Name, city.District, city. population "
                                + "FROM city LEFT JOIN country ON city.CountryCode = country.Code ORDER BY city.population DESC";
                //get ResultSet
                ResultSet rset = stmt.executeQuery(strSelect);
                //pass to buildCityList to construct ArrayList of cities
                return buildCityList(rset);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * builds SQL query using the continent string passed to it
     * passes the query to the executeCityQuery function to execute
     * then returns the list of cities that it created
     *
     * @return all cities in the supplied continent from the world db in order of population from largest to smallest
     * @param con the connection to the database
     * @param continent the continent the listed cities will be from
     */
    public static ArrayList<City> getAllCitiesContinent(Connection con, String continent)
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                //construct SQL query
                String strSelect =
                        "SELECT city.Name, country.Name, city.District, city.population "
                                + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                                + "WHERE country.Continent LIKE '" + continent + "' ORDER BY city.population DESC";
                //get ResultSet
                ResultSet rset = stmt.executeQuery(strSelect);
                //pass to buildCityList to construct ArrayList of cities and return it
                return buildCityList(rset);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * builds SQL query using the region string passed to it
     * passes the query to the executeCityQuery function to execute
     * then returns the list of cities that it created
     *
     * @return all cities in the supplied region from the world db in order of population from largest to smallest
     * @param con the connection to the database
     * @param region the region the listed cities will be from
     */
    public static ArrayList<City> getAllCitiesRegion(Connection con, String region)
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                //construct SQL query
                String strSelect =
                        "SELECT city.Name, country.Name, city.District, city.population "
                                + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                                + "WHERE country.Region LIKE '" + region + "' ORDER BY city.population DESC";
                //get ResultSet
                ResultSet rset = stmt.executeQuery(strSelect);
                //pass to buildCityList to construct ArrayList of cities and return it
                return buildCityList(rset);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * builds SQL query using the region string passed to it
     * passes the query to the executeCityQuery function to execute
     * then returns the list of cities that it created
     *
     * @return all cities in the supplied region from the world db in order of population from largest to smallest
     * @param con the connection to the database
     * @param country the country the listed cities will be from
     */
    public static ArrayList<City> getAllCitiesCountry(Connection con, String country)
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                //construct SQL query
                String strSelect =
                        "SELECT city.Name, country.Name, city.District, city.population "
                                + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                                + "WHERE country.Name LIKE '" + country + "' ORDER BY city.population DESC";
                //get ResultSet
                ResultSet rset = stmt.executeQuery(strSelect);
                //pass to buildCityList to construct ArrayList of cities and return it
                return buildCityList(rset);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * builds SQL query using the region string passed to it
     * passes the query to the executeCityQuery function to execute
     * then returns the list of cities that it created
     *
     * @return all cities in the supplied district from the world db in order of population from largest to smallest
     * @param con the connection to the database
     * @param district the country the listed cities will be from
     */
    public static ArrayList<City> getAllCitiesDistrict(Connection con, String district)
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                //construct SQL query
                String strSelect =
                        "SELECT city.Name, country.Name, city.District, city.population "
                                + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                                + "WHERE city.District LIKE '" + district + "' ORDER BY city.population DESC";
                //get ResultSet
                ResultSet rset = stmt.executeQuery(strSelect);
                //pass to buildCityList to construct ArrayList of cities and return it
                return buildCityList(rset);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * constructs a city, assigns variables based on sql entry
     * then adds the city to an Arraylist which is returned
     *
     * @return all cities in the world db in order of population from largest to smallest
     * @param rset ResultSet returned from the SQL query
     */
    public static ArrayList<City> buildCityList(ResultSet rset)
    {
        try
        {
            {
                // Create arrayList for cities
                ArrayList<City> cities = new ArrayList<>();
                // Create new country and assign variables
                while (rset.next())
                {
                    City c = new City();
                    c.setName(rset.getString("city.Name"));
                    c.setCountry(rset.getString("country.name"));
                    c.setDistrict(rset.getString("city.District"));
                    c.setPopulation(rset.getInt("city.Population"));
                    cities.add(c);
                }
                return cities;
            }
        }
        catch (Exception e)
        {
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
    public static void printCities(ArrayList<City> cities){

        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        try {
            // Print headers
            System.out.printf("%-36s %-46s %-22s %-11s%n", "Name", "| Country ", "| District ", "| Population ");
            System.out.printf("%-36s %-46s %-22s %-11s%n", " ", "|", "|" , "|");

            // Print countries
            for (City c : cities) {
                System.out.printf("%-36s %-46s %-22s %-11s%n", c.getName(), "| " + c.getCountry(), "| " + c.getDistrict(), "| " + c.getPopulation());
            }
        }
        catch (Exception e){
            System.out.println("Could not print any cities");
        }
    }
}
