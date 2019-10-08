package com.amlane.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/")
public class CountryController
{
    //localhost:2019/names/all
    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        CountriesProjectApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountriesProjectApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    //localhost:2019/names/start/{letter}
    @GetMapping(value = "/names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountryByFirstLetter(@PathVariable char letter)
    {
        ArrayList<Country> rtnCountries = CountriesProjectApplication.ourCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:2019/names/size/{number}
    @GetMapping(value = "/names/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountryByNameLength(@PathVariable int number)
    {
        ArrayList<Country> rtnCountries = CountriesProjectApplication.ourCountryList.findCountries(c -> c.getName().length() >= number);
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:2019/population/size/{people}
    @GetMapping(value = "/population/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getByPopulation(@PathVariable int people)
    {
        ArrayList<Country> rtnCountries = CountriesProjectApplication.ourCountryList.findCountries(c -> c.getPopulation() >= people);
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //localhost:2019/population/min
    @GetMapping(value = "/population/min", produces = {"application/json"})
    public ResponseEntity<?> getSmallestPopulation()
    {
        ArrayList<Country> rtnCountries = CountriesProjectApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> c1.getPopulation() - c2.getPopulation());
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

    //localhost:2019/population/min
    @GetMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> getLargestPopulation()
    {
        ArrayList<Country> rtnCountries = CountriesProjectApplication.ourCountryList.countryList;
        rtnCountries.sort((c1, c2) -> c2.getPopulation() - c1.getPopulation());
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }
}