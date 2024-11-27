package com.example;

import java.util.ArrayList;
import java.util.List;

public class BoatList
{
    private List<Boat> boats = new ArrayList<>();

    public void addBoat(Boat boat)
    {
        boats.add(boat);
    }

    public void removeBoat(Boat boat)
    {
        boats.remove(boat);
    }

    public List<Boat> getBoats()
    {
        return boats;
    }
}
