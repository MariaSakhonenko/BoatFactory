package com.example;

import java.util.HashMap;
import java.util.Map;

public class BoatMap
{
    private Map<Integer, Boat> boatMap = new HashMap<>();

    public void addBoat(Boat boat)
    {
        boatMap.put(boat.getId(), boat);
    }

    public void removeBoat(int id)
    {
        boatMap.remove(id);
    }

    public Boat getBoat(int id)
    {
        return boatMap.get(id);
    }
}
