package com.napier.sem;

import com.napier.sem.reports.CountryReport;
import java.sql.*;
import java.util.ArrayList;

public class App
{
    /**
     * Main function generates reports in docker outlined in the specification
     * currently:
     * -generates a list of all countries in the world in order of population
     * -generates a list of all countries in a continent in order of population
     * -generates a list of all countries in a region in order of population
     * -The top N populated countries in the world where N is provided by the user.
     * -The top N populated countries in a continent where N is provided by the user.
     * -The top N populated countries in a region where N is provided by the user.
     **/
    private static Connection con = null;
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();


        //create ArrayList containing all countries
        ArrayList<Country> countries = CountryReport.getAllCountries(con);
        // Print all countries in the world db
        CountryReport.printAllCountries(countries);
        System.out.println("\r\n \r\n");
        //print all countries in a continent (Europe can be changed to whichever continent)
        CountryReport.printCountriesContinent(countries, "Europe");
        System.out.println("\r\n \r\n");
        //print all countries in a continent (SA can be changed to whichever continent)
        CountryReport.printCountriesRegion(countries, "South America");
        System.out.println("\r\n \r\n");
        //print  the "n" highest population countries in the world
        CountryReport.printAllCountries(countries,5);
        System.out.println("\r\n \r\n");
        //print  the "n" highest population countries in a continent
        CountryReport.printCountriesContinent(countries, "Africa", 5);
        System.out.println("\r\n \r\n");
        //print  the "n" highest population countries in a Region
        CountryReport.printCountriesRegion(countries, "Eastern Asia", 5);
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
}
