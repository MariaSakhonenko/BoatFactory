package com.example;

public class Sailboat extends Boat
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
