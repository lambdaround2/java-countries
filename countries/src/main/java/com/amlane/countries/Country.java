package com.amlane.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{
    private static final AtomicLong counter = new AtomicLong();

    private long id;
    private String name;
    private int population;
    private int land_mass;
    private int median_age;

    public Country(String name, int population, int land_mass, int median_age)
    {
        this.id = counter.getAndIncrement();
        this.name = name;
        this.population = population;
        this.land_mass = land_mass;
        this.median_age = median_age;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public int getLand_mass()
    {
        return land_mass;
    }

    public void setLand_mass(int land_mass)
    {
        this.land_mass = land_mass;
    }

    public int getMedian_age()
    {
        return median_age;
    }

    public void setMedian_age(int median_age)
    {
        this.median_age = median_age;
    }

    @Override
    public String toString()
    {
        return "CountryList{" + "id=" + id + ", name='" + name + '\'' + ", population=" + population + ", land_mass=" + land_mass + ", median_age=" + median_age + '}';
    }
}
