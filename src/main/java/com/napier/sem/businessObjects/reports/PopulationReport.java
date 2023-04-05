package com.napier.sem.businessObjects.reports;

import com.napier.sem.businessObjects.Population;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PopulationReport {

    public static String getContinentPopulation(String continent)
    {
        return
                "SELECT SUM(DISTINCT country.Population), SUM(DISTINCT city.Population), SUM(DISTINCT country.Population) - SUM(DISTINCT city.Population) "
                        + "FROM city JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Continent LIKE '" + continent + "'";
    }

    public static String getRegionPopulation(String region)
    {
        return
                "SELECT SUM(DISTINCT country.Population), SUM(DISTINCT city.Population), SUM(DISTINCT country.Population) - SUM(DISTINCT city.Population) "
                        + "FROM city JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Region LIKE '" + region + "'";
    }

    public static String getCountryPopulation(String country)
    {
        return
                "SELECT SUM(DISTINCT country.Population), SUM(DISTINCT city.Population), SUM(DISTINCT country.Population) - SUM(DISTINCT city.Population) "
                        + "FROM city JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Name LIKE '" + country + "'";
    }


    public static Population ExecuteQuery(Connection con, String query, String location){

        try
        {
            {
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
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public static void printPopulation(Population population){

        if (population != null) {

            System.out.println("Total population of " + population.getName() + ": " + population.getPopulation());
            System.out.println("Total population in cities of " + population.getName() + ": " + population.getCityPopulation());
            System.out.println("Total population not in cities of " + population.getName() + ": " + population.getOutOfCityPopulation());
        }
        else{

            System.out.println("couldn't print population details");
        }
    }
}
