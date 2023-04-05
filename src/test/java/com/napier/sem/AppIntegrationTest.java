package com.napier.sem;

import com.napier.sem.businessObjects.City;
import com.napier.sem.businessObjects.Country;
import com.napier.sem.businessObjects.reports.CityReport;
import com.napier.sem.businessObjects.reports.CountryReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    //initialize app
    static App app;

    //initialize database connection
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }
}
