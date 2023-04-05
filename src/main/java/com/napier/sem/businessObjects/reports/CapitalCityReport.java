package com.napier.sem.businessObjects.reports;

import com.napier.sem.businessObjects.City;
import java.util.ArrayList;

public class CapitalCityReport {

    /**
     * builds SQL query to get city details passed to it
     * @return all capital cities in the world db in order of population from largest to smallest
     */
    public static String getCapitalCities()
    {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                        + "WHERE city.Name IS NOT NULL "
                        + "ORDER BY city.population DESC";
    }

    /**
     * builds SQL query to get city details passed to it
     * @return all capital cities in the world db in order of population from largest to smallest
     * @param limit the limit of the number of counties you want listed
     */
    public static String getCapitalCities(int limit)
    {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                        + "WHERE city.Name IS NOT NULL "
                        + "ORDER BY city.population DESC LIMIT " + limit ;
    }

    /**
     * builds SQL query to get city details passed to it
     * @return all capital cities in the world db in order of population from largest to smallest
     * @param continent the continent the listed countries will be from
     */
    public static String getCapitalCitiesContinent(String continent)
    {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                        + "WHERE city.Name IS NOT NULL "
                        + "AND country.Continent LIKE '" + continent
                        + "' ORDER BY city.population DESC";
    }

    /**
     * builds SQL query to get city details passed to it
     * @return all capital cities in the world db in order of population from largest to smallest
     * @param continent the continent the listed countries will be from
     * @param limit the limit of the number of counties you want listed
     */
    public static String getCapitalCitiesContinent(String continent, int limit)
    {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                        + "WHERE city.Name IS NOT NULL "
                        + "AND country.Continent LIKE '" + continent
                        + "' ORDER BY city.population DESC LIMIT " + limit ;
    }

    /**
     * builds SQL query to get city details passed to it
     * @return all capital cities in the world db in order of population from largest to smallest
     * @param region the region the listed countries will be from
     */
    public static String getCapitalCitiesRegion(String region)
    {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                        + "WHERE city.Name IS NOT NULL "
                        + "AND country.Region LIKE '" + region
                        + "' ORDER BY city.population DESC";
    }

    /**
     * builds SQL query to get city details passed to it
     * @return all capital cities in the world db in order of population from largest to smallest
     * @param region the region the listed countries will be from
     * @param limit the limit of the number of counties you want listed
     */
    public static String getCapitalCitiesRegion(String region, int limit)
    {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                        + "WHERE city.Name IS NOT NULL "
                        + "AND country.Region LIKE '" + region
                        + "' ORDER BY city.population DESC LIMIT " + limit ;
    }

    /**
     * prints all cities in the arraylist provided to it
     *
     * @param cities An ArrayList of cities
     */
    public static void printCapitalCities(ArrayList<City> cities){

        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        try {
            // Print headers
            System.out.printf("%-36s %-46s %-11s%n", "Name", "| Country ", "| Population ");
            System.out.printf("%-36s %-46s %-11s%n", " ", "|", "|");

            // Print countries
            for (City c : cities) {
                System.out.printf("%-36s %-46s %-11s%n", c.getName(), "| " + c.getCountry(), "| " + c.getPopulation());
            }
        }
        catch (Exception e){
            System.out.println("Could not print any cities");
        }
    }
}
