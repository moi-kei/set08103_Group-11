package com.napier.sem.businessObjects.reports;

import com.napier.sem.businessObjects.Language;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LanguageReport {

    public static ArrayList<Language> getLanguages(Connection con)
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT countrylanguage.Language, SUM(country.Population * countrylanguage.Percentage / 100) AS speakers, " +
                                "SUM(country.Population * countrylanguage.Percentage / 100) / " +
                                "(SELECT sum(Population)FROM country) * 100 AS percentage_speakers " +
                                " FROM country " +
                                " JOIN countrylanguage ON countrylanguage.CountryCode = country.Code " +
                                " WHERE countrylanguage.Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')" +
                                " GROUP BY countrylanguage.Language" +
                                " ORDER BY speakers DESC;";

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                ArrayList<Language> languages = new ArrayList<>();
                while (rset.next())
                {
                    Language language = new Language();
                    language.setName(rset.getString("countryLanguage.Language"));
                    language.setPopulation(rset.getLong("speakers"));
                    language.setPercentage(rset.getFloat("percentage_speakers"));
                    languages.add(language);
                }
                return languages;

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get language details");
            return null;
        }
    }

    public static void printLanguages(List<Language> languages)
    {
        if(languages != null && !languages.isEmpty()) {
            for (Language l : languages) {
                System.out.println("Language :" + l.getName() + "\nNumber of speakers: " + l.getPopulation() + "\nPercentage of world population: " + l.getPercentage() + "%\n");
            }
        }
        else
        {
            System.out.println("Can't print language report");
        }
    }
}
