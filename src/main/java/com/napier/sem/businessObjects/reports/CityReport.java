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
     * @return all cities in the world db in order of population from largest to smallest
     */
    public static String getAllCities()
    {
        return
                "SELECT city.Name, country.Name, city.District, city. population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code ORDER BY city.population DESC";
    }

    /**
     * builds SQL query to get city details passed to it
     *
     * @param limit the number of entries to get from database
     * @return all cities in the world db in order of population from largest to smallest
     */
    public static String getAllCitiesLimit(int limit)
    {
        return
                "SELECT city.Name, country.Name, city.District, city. population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code ORDER BY city.population DESC LIMIT " + limit;
    }

    /**
     * builds SQL query using the continent string passed to it
     *
     * @return all cities in the supplied continent from the world db in order of population from largest to smalles
     * @param continent the continent the listed cities will be from
     */
    public static String getAllCitiesContinent(String continent)
    {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Continent LIKE '" + continent + "' ORDER BY city.population DESC";
    }

    /**
     * builds SQL query using the continent string passed to it
     *
     * @return all cities in the supplied continent from the world db in order of population from largest to smallest
     * @param continent the continent the listed cities will be from
     * @param limit the number of entries to get from database
     */
    public static String getAllCitiesContinentLimit(String continent, int limit)
    {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Continent LIKE '" + continent + "' ORDER BY city.population DESC LIMIT " + limit;
    }

    /**
     * builds SQL query using the region string passed to it
     *
     * @return all cities in the supplied region from the world db in order of population from largest to smallest
     * @param region the region the listed cities will be from
     */
    public static String getAllCitiesRegion(String region)
    {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Region LIKE '" + region + "' ORDER BY city.population DESC";
    }

    /**
     * builds SQL query using the region string passed to it
     *
     * @return all cities in the supplied region from the world db in order of population from largest to smallest
     * @param region the region the listed cities will be from
     * @param limit the number of entries to get from database
     */
    public static String getAllCitiesRegionLimit(String region, int limit)
    {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Region LIKE '" + region + "' ORDER BY city.population DESC LIMIT " + limit;
    }

    /**
     * builds SQL query using the region string passed to it
     *
     * @return all cities in the supplied region from the world db in order of population from largest to smallest
     * @param country the country the listed cities will be from
     */
    public static String getAllCitiesCountry(String country)
    {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Name LIKE '" + country + "' ORDER BY city.population DESC";
    }

    /**
     * builds SQL query using the region string passed to it
     *
     * @return all cities in the supplied region from the world db in order of population from largest to smallest
     * @param country the country the listed cities will be from
     * @param limit the number of entries to get from database
     */
    public static String getAllCitiesCountryLimit(String country, int limit)
    {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Name LIKE '" + country + "' ORDER BY city.population DESC LIMIT " + limit;
    }

    /**
     * builds SQL query using the region string passed to it
     *
     * @return all cities in the supplied district from the world db in order of population from largest to smallest
     * @param district the country the listed cities will be from
     */
    public static String getAllCitiesDistrict(String district)
    {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE city.District LIKE '" + district + "' ORDER BY city.population DESC";
    }

    /**
     * builds SQL query using the region string passed to it
     *
     * @return all cities in the supplied district from the world db in order of population from largest to smallest
     * @param district the country the listed cities will be from
     * @param limit the number of entries to get from database
     */
    public static String getAllCitiesDistrictLimit(String district, int limit)
    {
        return
                "SELECT city.Name, country.Name, city.District, city.population "
                        + "FROM city LEFT JOIN country ON city.CountryCode = country.Code "
                        + "WHERE city.District LIKE '" + district + "' ORDER BY city.population DESC LIMIT " + limit;
    }

    public static ArrayList<City> ExecuteQuery(Connection con, String query){

        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                //get ResultSet
                ResultSet rset = stmt.executeQuery(query);
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
