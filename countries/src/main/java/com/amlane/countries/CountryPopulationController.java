package com.amlane.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopulationController
{
    //localhost:2019/population/size/{people}
    @GetMapping(value = "/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getByPopulation(@PathVariable
                                                     int people)
    {
        ArrayList<Country> rtnCountries = CountriesProjectApplication.ourCountryList.findCountries(c -> c.getPopulation() >= people);
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:2019/population/min
    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getSmallestPopulation()
    {
        ArrayList<Country> rtnCountries = CountriesProjectApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> c1.getPopulation() - c2.getPopulation());
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

    //localhost:2019/population/min
    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getLargestPopulation()
    {
        ArrayList<Country> rtnCountries = CountriesProjectApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> c2.getPopulation() - c1.getPopulation());
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

    //localhost:2019/population/median
    @GetMapping(value = "/median", produces = {"application/json"})
    public ResponseEntity<?> getMedianPopulation()
    {
        ArrayList<Country> rtnCountries = CountriesProjectApplication.ourCountryList.countryList;
        int median = Math.round(rtnCountries.size() / 2);
        rtnCountries.sort((c1, c2) -> c2.getPopulation() - c1.getPopulation());
        return new ResponseEntity<>(rtnCountries.get(median), HttpStatus.OK);

    }
}
