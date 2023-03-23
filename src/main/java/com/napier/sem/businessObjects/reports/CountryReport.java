package com.napier.sem.businessObjects.reports;

import com.napier.sem.businessObjects.Country;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class acting as a container for static function related to creating country reports
 * {@code @Authors:} Michael Mackenzie, Nweke Success
 */
public class CountryReport {
    private static final String header1 = String.format("%-3s %-46s %-15s %-29s %-15s %-9s%n", "Code", "| Name", "| Continent", "| Region", " | Population", " | Capital");
    private static final String header2 = String.format("%-4s %-46s %-15s %-30s %-15s %-9s%n", " ", "|", "|", "|", "|", "|");

    /**
     * Creates and executes a sql query that gets all countries in order of population
     * constructs a country, assigns variables based on sql entry
     * then adds the country to an Arraylist which is returned
     *
     * @return all countries in the world db in order of population from largest to smallest
     */
    public static ArrayList<Country> getAllCountries(Connection con)
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                                + "FROM country LEFT JOIN city ON country.Capital = city.ID ORDER BY country.population DESC";

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);

                return buildCountryList(rset);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * prints all countries contained in the ArrayList that is supplied to it
     *
     * @param con The connection to the database
     * @param limit the limit of the number of counties you want listed
     */
    public static ArrayList<Country> getAllCountriesLimit(Connection con, int limit)
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                                + "FROM country LEFT JOIN city ON country.Capital = city.ID ORDER BY country.population DESC LIMIT " + limit ;

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);

                return buildCountryList(rset);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * builds SQL query using the continent string passed to it
     * returns the list of cities that it created
     *
     * @return all countries in the supplied continent from the world db in order of population from largest to smallest
     * @param con the connection to the database
     * @param continent the continent the listed countries will be from
     */
    public static ArrayList<Country> getAllCountriesContinent(Connection con, String continent)
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                //construct SQL query
                String strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                                + "WHERE country.Continent LIKE '" + continent + "' ORDER BY country.population DESC";
                //get ResultSet
                ResultSet rset = stmt.executeQuery(strSelect);
                //pass to buildCityList to construct ArrayList of countries and return it
                return buildCountryList(rset);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * builds SQL query using the continent string passed to it
     * returns the list of cities that it created
     *
     * @return all countries in the supplied continent from the world db in order of population from largest to smallest
     * @param con the connection to the database
     * @param continent the continent the listed coountries will be from
     * @param limit the number of entries to get from database
     */
    public static ArrayList<Country> getAllCountriesContinentLimit(Connection con, String continent, int limit)
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                //construct SQL query
                String strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                                + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                                + "WHERE country.Continent LIKE '" + continent + "' ORDER BY country.population DESC LIMIT " + limit;
                //get ResultSet
                ResultSet rset = stmt.executeQuery(strSelect);
                //pass to buildCityList to construct ArrayList of countries and return it
                return buildCountryList(rset);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * builds SQL query using the region string passed to it
     * returns the list of cities that it created
     *
     * @return all countries in the supplied region from the world db in order of population from largest to smallest
     * @param con the connection to the database
     * @param region the continent the listed countries will be from
     */
    public static ArrayList<Country> getAllCountriesRegion(Connection con, String region)
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                //construct SQL query
                String strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                                + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                                + "WHERE country.Continent LIKE '" + region + "' ORDER BY country.population DESC";
                //get ResultSet
                ResultSet rset = stmt.executeQuery(strSelect);
                //pass to buildCityList to construct ArrayList of countries and return it
                return buildCountryList(rset);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * builds SQL query using the region string passed to it
     * returns the list of cities that it created
     *
     * @return all countries in the supplied region from the world db in order of population from largest to smallest
     * @param con the connection to the database
     * @param region the continent the listed countries will be from
     * @param limit the number of entries to get from database
     */
    public static ArrayList<Country> getAllCountriesRegionLimit(Connection con, String region, int limit)
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                //construct SQL query
                String strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                                + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                                + "WHERE country.Continent LIKE '" + region + "' ORDER BY country.population DESC LIMIT " + limit;
                //get ResultSet
                ResultSet rset = stmt.executeQuery(strSelect);
                //pass to buildCityList to construct ArrayList of countries and return it
                return buildCountryList(rset);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * prints all countries contained in the ArrayList that is supplied to it
     *
     * @param countries An ArrayList of countries
     */
    public static void printCountries(ArrayList<Country> countries){

        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        try {
            // Print headers
            System.out.printf(header1);
            System.out.printf(header2);
            // Print countries
            for (Country c : countries) {
                System.out.printf("%-4s %-46s %-15s %-30s %-15s %-9s%n", c.getCode(), "| " + c.getName(), "| " + c.getContinent(), "| " + c.getRegion(), "| " + c.getPopulation(), "| " + c.getCapital());
            }
        }
        catch (Exception e){
        System.out.println("Could not print any countries");
        }
    }

    /**
     * constructs a country, assigns variables based on sql entry
     * then adds the country to an Arraylist which is returned
     *
     * @return all countries in the world db in order of population from largest to smallest
     * @param rset ResultSet returned from the SQL query
     */
    public static ArrayList<Country> buildCountryList(ResultSet rset)
    {
        try
        {
            {
                // Create arrayList for countries
                ArrayList<Country> countries = new ArrayList<>();
                // Create new country and assign variables
                while (rset.next())
                {
                    Country c = new Country();
                    c.setCode(rset.getString("country.code"));
                    c.setName(rset.getString("country.name"));
                    c.setContinent(rset.getString("country.continent"));
                    c.setRegion(rset.getString("country.region"));
                    c.setPopulation(rset.getInt("country.population"));
                    c.setCapital(rset.getString("city.Name"));
                    countries.add(c);
                }
                return countries;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }
}
