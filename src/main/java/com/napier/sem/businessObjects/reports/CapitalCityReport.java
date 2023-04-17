package com.napier.sem.businessObjects.reports;

import com.napier.sem.businessObjects.City;

import java.util.ArrayList;

/**
 * Class acting as a container for static function related to creating capital city reports
 * {@code @Authors:} Michael Mackenzie, Nweke Success
 */
public class CapitalCityReport {

    /**
     * builds SQL query to get city details passed to it
     *
     * @return a query for getting all capital cities from the db
     */
    public static String getCapitalCities() {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                        + "WHERE city.Name IS NOT NULL "
                        + "ORDER BY city.population DESC";
    }

    /**
     * builds SQL query to get city details passed to it
     *
     * @param limit the limit of the number of counties you want listed
     * @return a query for getting a number of capital cities from the db
     */
    public static String getCapitalCities(int limit) {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                        + "WHERE city.Name IS NOT NULL "
                        + "ORDER BY city.population DESC LIMIT " + limit;
    }

    /**
     * builds SQL query to get city details passed to it
     *
     * @param continent the continent the listed countries will be from
     * @return a query for getting all capital cities in a continent from the db
     */
    public static String getCapitalCitiesContinent(String continent) {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                        + "WHERE city.Name IS NOT NULL "
                        + "AND country.Continent LIKE '" + continent
                        + "' ORDER BY city.population DESC";
    }

    /**
     * builds SQL query to get city details passed to it
     *
     * @param continent the continent the listed countries will be from
     * @param limit     the limit of the number of counties you want listed
     * @return a query for getting a number of capital cities in a continent from the db
     */
    public static String getCapitalCitiesContinent(String continent, int limit) {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                        + "WHERE city.Name IS NOT NULL "
                        + "AND country.Continent LIKE '" + continent
                        + "' ORDER BY city.population DESC LIMIT " + limit;
    }

    /**
     * builds SQL query to get city details passed to it
     *
     * @param region the region the listed countries will be from
     * @return a query for getting all capital cities in a region from the db
     */
    public static String getCapitalCitiesRegion(String region) {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                        + "WHERE city.Name IS NOT NULL "
                        + "AND country.Region LIKE '" + region
                        + "' ORDER BY city.population DESC";
    }

    /**
     * builds SQL query to get city details passed to it
     *
     * @param region the region the listed countries will be from
     * @param limit  the limit of the number of counties you want listed
     * @return a query for getting a number of capital cities in a region from the db
     */
    public static String getCapitalCitiesRegion(String region, int limit) {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM country LEFT JOIN city ON country.Capital = city.ID "
                        + "WHERE city.Name IS NOT NULL "
                        + "AND country.Region LIKE '" + region
                        + "' ORDER BY city.population DESC LIMIT " + limit;
    }

    /**
     * prints all cities in the arraylist provided to it
     *
     * @param cities An ArrayList of cities
     */
    public static void printCapitalCities(ArrayList<City> cities) {

        if (cities == null) {
            System.out.println("No cities");
            return;
        }
        // Print headers
        System.out.printf("%-36s %-46s %-11s%n", "Name", "| Country ", "| Population ");
        System.out.printf("%-36s %-46s %-11s%n", " ", "|", "|");

        // Print countries
        for (City c : cities) {
            if (c != null) {
                System.out.printf("%-36s %-46s %-11s%n", c.getName(), "| " + c.getCountry(), "| " + c.getPopulation());
            } else {
                System.out.println("Couldn't print capital city details");
            }
        }
    }
}
