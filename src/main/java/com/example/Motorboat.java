package com.example;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.io.Serializable;

@JsonTypeName("Моторная лодка")
public class Motorboat extends Boat implements Serializable
{
    private int fuelCapacity;

    public int getFuelCapacity()
    {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity)
    {
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", Motorboat{" +
                "fuelCapacity=" + fuelCapacity +
                '}';
    }
}
