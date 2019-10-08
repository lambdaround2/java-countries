package com.amlane.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesProjectApplication
{
    static CountryList ourCountryList;

    public static void main(String[] args)
    {
        ourCountryList = new CountryList();
        SpringApplication.run(CountriesProjectApplication.class, args);
    }

}
