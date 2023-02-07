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

        // Print all countries in the world db
        a.printAllCountries(a.getAllCountries());

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect to the MySQL database.
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
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
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
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                                + "FROM country ORDER BY country.population DESC";

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Create arrayList for countries
                ArrayList<Country> country = new ArrayList<>();
                // Create new country and assign variables
                while (rset.next())
                {
                    Country c = new Country();
                    c.setCode(rset.getString("country.code"));
                    c.setName(rset.getString("country.name"));
                    c.setContinent(rset.getString("country.continent"));
                    c.setRegion(rset.getString("country.region"));
                    c.setPopulation(rset.getInt("country.population"));
                    c.setCapital(rset.getString("country.capital"));
                    country.add(c);
                }
                return country;

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
    public void printAllCountries(ArrayList<Country> countries){

        // Print headers
        System.out.println("All the countries in the world from largest population to smallest. \r\n");
        System.out.println(String.format("%-3s %-46s %-15s %-30s %15s %-9s", "Code", "| Name", "| Continent", "| Region", " | Population", " | Capital"));
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        // Print countries
        for (Country c : countries){
            System.out.println(String.format("%-3s %-46s %-15s %-30s %15s %-9s", c.getCode(), "| " + c.getName(), "| " + c.getContinent(), "| " + c.getRegion(), "| " + c.getPopulation(), "| " + c.getCapital()));
        }
    }
}
