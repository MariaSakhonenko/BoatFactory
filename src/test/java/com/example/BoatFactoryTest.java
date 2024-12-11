package com.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoatFactoryTest
{

    @Test
    public void testAddBoat()
    {
        BoatList boatList = new BoatList();
        Sailboat sailboat = new Sailboat();
        sailboat.setId(1);
        sailboat.setType("Парусник");
        sailboat.setModel("Model X");
        sailboat.setEnginePower(100);
        sailboat.setMaxSpeed(50);
        sailboat.setReleaseDate(new Date());
        sailboat.setPrice(50000.00);
        sailboat.setSailArea(200);

        boatList.addBoat(sailboat);

        assertEquals(1, boatList.getBoats().size());
        assertEquals("Парусник", boatList.getBoats().get(0).getType());
    }

    @Test
    public void testWriteAndReadBoatsToFile() throws IOException, ClassNotFoundException
    {
        BoatList boatList = new BoatList();
        Sailboat sailboat = new Sailboat();
        sailboat.setId(1);
        sailboat.setType("Парусник");
        sailboat.setModel("Model X");
        sailboat.setEnginePower(100);
        sailboat.setMaxSpeed(50);
        sailboat.setReleaseDate(new Date());
        sailboat.setPrice(50000.00);
        sailboat.setSailArea(200);

        boatList.addBoat(sailboat);

        BoatFileManager.writeBoatsToFile(boatList.getBoats(), "boats_test.dat");
        List<Boat> boatsFromFile = BoatFileManager.readBoatsFromFile("boats_test.dat");

        assertEquals(1, boatsFromFile.size());
        assertEquals("Парусник", boatsFromFile.get(0).getType());
    }

    @Test
    public void testXMLSerialization() throws Exception
    {
        BoatList boatList = new BoatList();
        Sailboat sailboat = new Sailboat();
        sailboat.setId(1);
        sailboat.setType("Парусник");
        sailboat.setModel("Model X");
        sailboat.setEnginePower(100);
        sailboat.setMaxSpeed(50);
        sailboat.setReleaseDate(new Date());
        sailboat.setPrice(50000.00);
        sailboat.setSailArea(200);

        boatList.addBoat(sailboat);

        XMLHandler.writeBoatsToXML(boatList.getBoats(), "boats_test.xml");
        List<Boat> boatsFromXML = XMLHandler.readBoatsFromXML("boats_test.xml");

        assertEquals(1, boatsFromXML.size());
        assertEquals("Парусник", boatsFromXML.get(0).getType());
    }

//    @Test
//    public void testJSONSerialization() throws IOException {
//        BoatList boatList = new BoatList();
//        Sailboat sailboat = new Sailboat();
//        sailboat.setId(1);
//        sailboat.setType("Парусник");
//        sailboat.setModel("Model X");
//        sailboat.setEnginePower(100);
//        sailboat.setMaxSpeed(50);
//        sailboat.setReleaseDate(new Date());
//        sailboat.setPrice(50000.00);
//        sailboat.setSailArea(200);
//
//        boatList.addBoat(sailboat);
//
//        JSONHandler.writeBoatsToJSON(boatList.getBoats(), "boats_test.json");
//        List<Boat> boatsFromJSON = JSONHandler.readBoatsFromJSON("boats_test.json");
//
//        assertEquals(1, boatsFromJSON.size());
//        assertEquals("Парусник", boatsFromJSON.get(0).getType());
//    }
}
