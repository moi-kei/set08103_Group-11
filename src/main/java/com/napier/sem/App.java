package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    private Connection con = null;
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Create ArrayList containing all countries
        ArrayList<Country> countries = a.getAllCountries();
        // Print all countries in the world db
        a.printAllCountries(countries);
        System.out.println("\r\n \r\n");
        // Print all countries in a continent (Europe can be changed to whichever continent)
        a.printCountriesContinent(countries, "Europe");
        System.out.println("\r\n \r\n");
        // Print all countries in a continent (SA can be changed to whichever continent)
        a.printCountriesRegion(countries, "South America");
        System.out.println("\r\n \r\n");

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect to the MySQL database
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
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

    /**
     * Creates and executes a sql query that gets all countries in order of population
     * constructs a country, assigns variables based on sql entry
     * then adds the country to an Arraylist which is returned
     *
     * @return all countries in the world db in order of population from largest to smallest
     */
    public ArrayList<Country> getAllCountries()
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
     * Prints all countries contained in the ArrayList that is supplied to it
     *
     * @param countries Ann ArrayList of countries
     */
    public void printAllCountries(ArrayList<Country> countries){

        // Print headers
        System.out.println("All the countries in the world from largest population to smallest. \r\n");
        System.out.printf("%-3s %-46s %-15s %-29s %-15s %-9s%n", "Code", "| Name", "| Continent", "| Region", " | Population", " | Capital");
        System.out.println("-----|----------------------------------------------|---------------|------------------------------|---------------|--------");
        // Print countries
        for (Country c : countries){
            System.out.printf("%-4s %-46s %-15s %-30s %-15s %-9s%n", c.getCode(), "| " + c.getName(), "| " + c.getContinent(), "| " + c.getRegion(), "| " + c.getPopulation(), "| " + c.getCapital());
        }
    }

    /**
     * Prints all countries contained in the ArrayList where the continent is equal to the one provided
     *
     * @param countries Ann ArrayList of countries
     */
    public void printCountriesContinent(ArrayList<Country> countries, String continent){

        // Print headers
        System.out.println("All the countries in " + continent + " from largest population to smallest. \r\n");
        System.out.printf("%-3s %-46s %-15s %-29s %-15s %-9s%n", "Code", "| Name", "| Continent", "| Region", " | Population", " | Capital");
        System.out.println("-----|----------------------------------------------|---------------|------------------------------|---------------|--------");
        // Print countries
        for (Country c : countries){
            if(c.getContinent().equals(continent)) {
                System.out.printf("%-4s %-46s %-15s %-30s %-15s %-9s%n", c.getCode(), "| " + c.getName(), "| " + c.getContinent(), "| " + c.getRegion(), "| " + c.getPopulation(), "| " + c.getCapital());
            }
        }
    }

    /**
     * Prints all countries contained in the ArrayList where the Region is equal to the one provided
     *
     * @param countries Ann ArrayList of countries
     */
    public void printCountriesRegion(ArrayList<Country> countries, String region){

        // Print headers
        System.out.println("All the countries in " + region + " from largest population to smallest. \r\n");
        System.out.printf("%-3s %-46s %-15s %-29s %-15s %-9s%n", "Code", "| Name", "| Continent", "| Region", " | Population", " | Capital");
        System.out.println("-----|----------------------------------------------|---------------|------------------------------|---------------|--------");
        // Print countries
        for (Country c : countries){
            if(c.getRegion().equals(region)) {
                System.out.printf("%-4s %-46s %-15s %-30s %-15s %-9s%n", c.getCode(), "| " + c.getName(), "| " + c.getContinent(), "| " + c.getRegion(), "| " + c.getPopulation(), "| " + c.getCapital());
            }
        }
    }
}
