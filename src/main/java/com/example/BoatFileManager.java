package com.example;

import java.io.*;
import java.util.List;

public class BoatFileManager
{
    public static void writeBoatsToFile(List<Boat> boats, String fileName) throws IOException
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
            oos.writeObject(boats);
        }
    }

    public static List<Boat> readBoatsFromFile(String fileName) throws IOException, ClassNotFoundException
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
        {
            return (List<Boat>) ois.readObject();
        }
    }
}
