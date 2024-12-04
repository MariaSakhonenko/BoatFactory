package com.example;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.io.Serializable;

@JsonTypeName("Катамаран")
public class Catamaran extends Boat implements Serializable
{
    private int passengerCapacity;

    public int getPassengerCapacity()
    {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity)
    {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", Catamaran{" +
                "passengerCapacity=" + passengerCapacity +
                '}';
    }
}
