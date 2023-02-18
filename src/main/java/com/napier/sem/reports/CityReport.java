package com.napier.sem.reports;

import com.napier.sem.businessObjects.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class acting as a container for static function related to creating city reports
 *
 * @Authors: Michael Mackenzie, Nweke Success
 */
public class CityReport {

    /**
     * Creates and executes a sql query that gets all cities in order of population
     * constructs a city, assigns variables based on sql entry
     * then adds the city to an Arraylist which is returned
     *
     * @return all cities in the world db in order of population from largest to smallest
     */
    public static ArrayList<City> getAllCities(Connection con)
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT city.Name, country.Name, city.District, city. population "
                                + "FROM city LEFT JOIN country ON city.CountryCode = country.Code ORDER BY city.population DESC";

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Create arrayList for countries
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
    public static void printAllCities(ArrayList<City> cities){

        try {
            // Print headers
            System.out.println("All the cities in the world from largest population to smallest. \r\n");
            System.out.printf("%-36s %-46s %-22s %-11s%n", "Name", "| Country ", "| District ", "| Population ");
            System.out.println("-------------------------------------|----------------------------------------------|----------------------|-----------");

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
