package com.amlane.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class CountryAgeController
{
    @GetMapping(value = "/{age}", produces = {"application/json"})
    public ResponseEntity<?> getBySmallestMedianAge(@PathVariable int age)
    {
        ArrayList<Country> rtnCountries = CountriesProjectApplication.ourCountryList.findCountries(c -> c.getMedian_age() >= age);
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

}
