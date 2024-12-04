package com.example;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.io.Serializable;

@JsonTypeName("Парусник")
public class Sailboat extends Boat implements Serializable
{
    private int sailArea;

    public int getSailArea()
    {
        return sailArea;
    }

    public void setSailArea(int sailArea)
    {
        this.sailArea = sailArea;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", Sailboat{" +
                "sailArea=" + sailArea +
                '}';
    }
}
