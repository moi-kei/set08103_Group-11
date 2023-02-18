package com.napier.sem.reports;

import com.napier.sem.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class acting as a container for static function related to creating country reports
 *
 * @Authors: Michael Mackenzie, Nweke Success
 */
public class CountryReport {
    private static final String header1 = String.format("%-3s %-46s %-15s %-29s %-15s %-9s%n", "Code", "| Name", "| Continent", "| Region", " | Population", " | Capital");
    private static final String header2 = "-----|----------------------------------------------|---------------|------------------------------|---------------|--------";

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
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * prints all countries contained in the ArrayList that is supplied to it
     *
     * @param countries An ArrayList of countries
     */
    public static void printAllCountries(ArrayList<Country> countries){

        try {
            // Print headers
            System.out.println("All the countries in the world from largest population to smallest. \r\n");
            System.out.printf(header1);
            System.out.println(header2);
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
     * prints all countries contained in the ArrayList that is supplied to it
     *
     * @param countries An ArrayList of countries
     * @param limit the limit of the number of counties you want listed
     */
    public static void printAllCountries(ArrayList<Country> countries, int limit){

        // Print headers
        try {
            System.out.println("The top " + limit + " the countries in the world from largest population to smallest. \r\n");
            System.out.printf(header1);
            System.out.println(header2);
            // Print countries
            for (int i = 0; i < limit; i++) {
                System.out.printf("%-4s %-46s %-15s %-30s %-15s %-9s%n", countries.get(i).getCode(), "| " + countries.get(i).getName(), "| " + countries.get(i).getContinent(), "| " + countries.get(i).getRegion(), "| " + countries.get(i).getPopulation(), "| " + countries.get(i).getCapital());
            }
        }
        catch (Exception e){
            System.out.println("Could not print any countries");
        }
    }

    /**
     * prints all countries contained in the ArrayList where the continent is equal to the one provided
     *
     * @param countries An ArrayList of countries
     * @param continent A string of the continent to get countries from
     */
    public static void printCountriesContinent(ArrayList<Country> countries, String continent){

        try {
            // Print headers
            System.out.println("All the countries in " + continent + " from largest population to smallest. \r\n");
            System.out.printf(header1);
            System.out.println(header2);
            // Print countries
            for (Country c : countries) {
                //if continent matches the provided continent print the country
                if (c.getContinent().equals(continent)) {
                    System.out.printf("%-4s %-46s %-15s %-30s %-15s %-9s%n", c.getCode(), "| " + c.getName(), "| " + c.getContinent(), "| " + c.getRegion(), "| " + c.getPopulation(), "| " + c.getCapital());
                }
            }
        }
        catch (Exception e){
            System.out.println("Could not print any countries");
        }
    }

    /**
     * prints all countries contained in the ArrayList where the continent is equal to the one provided
     *
     * @param countries An ArrayList of countries
     * @param continent A string of the continent to get countries from
     * @param limit the limit of the number of counties you want listed
     */
    public static void printCountriesContinent(ArrayList<Country> countries, String continent, int limit){

        try {
            // Print headers
            System.out.println("The top " + limit + " the countries in " + continent + " from largest population to smallest. \r\n");
            System.out.printf(header1);
            System.out.println(header2);

            int count = 0;
            // Print countries
            for (Country c : countries) {
                //if continent matches the provided continent print the country and increment counter
                if (c.getContinent().equals(continent)) {
                    System.out.printf("%-4s %-46s %-15s %-30s %-15s %-9s%n", c.getCode(), "| " + c.getName(), "| " + c.getContinent(), "| " + c.getRegion(), "| " + c.getPopulation(), "| " + c.getCapital());
                    count++;

                    if (count == limit) {
                        break;
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("Could not print any countries");
        }
    }

    /**
     * prints all countries contained in the ArrayList where the Region is equal to the one provided
     *
     * @param countries An ArrayList of countries
     * @param region A string of the region to get countries from
     */
    public static void printCountriesRegion(ArrayList<Country> countries, String region){

        try {
            // Print headers
            System.out.println("All the countries in " + region + " from largest population to smallest. \r\n");
            System.out.printf(header1);
            System.out.println(header2);
            // Print countries
            for (Country c : countries) {
                //if Region matches the provided Region print the country
                if (c.getRegion().equals(region)) {
                    System.out.printf("%-4s %-46s %-15s %-30s %-15s %-9s%n", c.getCode(), "| " + c.getName(), "| " + c.getContinent(), "| " + c.getRegion(), "| " + c.getPopulation(), "| " + c.getCapital());
                }
            }
        }
        catch (Exception e){
            System.out.println("Could not print any countries");
        }
    }

    /**
     * prints all countries contained in the ArrayList where the Region is equal to the one provided
     *
     * @param countries An ArrayList of countries
     * @param region A string of the region to get countries from
     * @param limit the limit of the number of counties you want listed
     */
    public static void printCountriesRegion(ArrayList<Country> countries, String region, int limit){

        try {
            // Print headers
            System.out.println("The top " + limit + " the countries in " + region + " from largest population to smallest. \r\n");
            System.out.printf(header1);
            System.out.println(header2);
            // Print countries
            int count = 0;
            for (Country c : countries) {
                if (c.getRegion().equals(region)) {
                    System.out.printf("%-4s %-46s %-15s %-30s %-15s %-9s%n", c.getCode(), "| " + c.getName(), "| " + c.getContinent(), "| " + c.getRegion(), "| " + c.getPopulation(), "| " + c.getCapital());
                    count++;
                    if (count == limit) {
                        break;
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("Could not print any countries");
        }
    }
}
