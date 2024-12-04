package com.example;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BoatFactory
{
    private static BoatList boatList = new BoatList();
    private static BoatMap boatMap = new BoatMap();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добавление нового парусника");
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
        boatMap.addBoat(sailboat);

        boatList.getBoats().forEach(System.out::println);

        try
        {
            BoatFileManager.writeBoatsToFile(boatList.getBoats(), "boats.dat");
            List<Boat> boatsFromFile = BoatFileManager.readBoatsFromFile("boats.dat");
            boatsFromFile.forEach(System.out::println);

            XMLHandler.writeBoatsToXML(boatList.getBoats(), "boats.xml");
            List<Boat> boatsFromXML = XMLHandler.readBoatsFromXML("boats.xml");
            boatsFromXML.forEach(System.out::println);

            JSONHandler.writeBoatsToJSON(boatList.getBoats(), "boats.json");
            List<Boat> boatsFromJSON = JSONHandler.readBoatsFromJSON("boats.json");
            boatsFromJSON.forEach(System.out::println);

            SecretKey secretKey = EncryptionUtil.generateKey();
            EncryptionUtil.encryptFile("boats.json", "boats_encrypted.json", secretKey);
            System.out.println("Файл boats.json успешно зашифрован в boats_encrypted.json");

            EncryptionUtil.decryptFile("boats_encrypted.json", "boats_decrypted.json", secretKey);
            System.out.println("Файл boats_encrypted.json успешно расшифрован в boats_decrypted.json");

            List<Boat> originalBoats = JSONHandler.readBoatsFromJSON("boats.json");
            List<Boat> decryptedBoats = JSONHandler.readBoatsFromJSON("boats_decrypted.json");

            if (originalBoats.equals(decryptedBoats))
            {
                System.out.println("Содержимое файлов идентично. Шифрование и дешифрование выполнены успешно.");
            }
            else
            {
                System.out.println("Содержимое файлов отличается. Проверьте алгоритмы шифрования и дешифрования.");
            }

            ZipUtil.zipFile("boats.json", "boats.zip");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        scanner.close();
    }
}
