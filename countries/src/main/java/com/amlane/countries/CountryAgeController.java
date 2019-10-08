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

    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getMinMedianAge()
    {
        ArrayList<Country> rtnCountries = CountriesProjectApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> (int)(c1.getMedian_age() - c2.getMedian_age()));
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getMaxMedianAge()
    {
        ArrayList<Country> rtnCountries = CountriesProjectApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> (int)(c2.getMedian_age() - c1.getMedian_age()));
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/median", produces = {"application/json"})
    public ResponseEntity<?> getMedianMedianAge()
    {
        ArrayList<Country> rtnCountries = CountriesProjectApplication.ourCountryList.countryList;
        int median = Math.round(rtnCountries.size() / 2);
        rtnCountries.sort((c1, c2) -> c2.getMedian_age() - c1.getMedian_age());
        return new ResponseEntity<>(rtnCountries.get(median), HttpStatus.OK);
    }
}
