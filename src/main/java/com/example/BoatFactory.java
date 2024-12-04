package com.example;

import javax.crypto.SecretKey;
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

        System.out.println("Добавление новой моторной лодки");
        Motorboat motorboat = new Motorboat();
        motorboat.setId(2);
        motorboat.setType("Моторная лодка");
        motorboat.setModel("Model Y");
        motorboat.setEnginePower(200);
        motorboat.setMaxSpeed(80);
        motorboat.setReleaseDate(new Date());
        motorboat.setPrice(70000.00);
        motorboat.setFuelCapacity(500);

        System.out.println("Добавление нового катамарана");
        Catamaran catamaran = new Catamaran();
        catamaran.setId(3);
        catamaran.setType("Катамаран");
        catamaran.setModel("Model Z");
        catamaran.setEnginePower(150);
        catamaran.setMaxSpeed(60);
        catamaran.setReleaseDate(new Date());
        catamaran.setPrice(80000.00);
        catamaran.setPassengerCapacity(20);

        boatList.addBoat(sailboat);
        boatList.addBoat(motorboat);
        boatList.addBoat(catamaran);

        boatMap.addBoat(sailboat);
        boatMap.addBoat(motorboat);
        boatMap.addBoat(catamaran);

        System.out.println("\nПервичный вывод списка лодок:");
        boatList.getBoats().forEach(System.out::println);

        try
        {
            BoatFileManager.writeBoatsToFile(boatList.getBoats(), "boats.dat");

            List<Boat> boatsFromFile = BoatFileManager.readBoatsFromFile("boats.dat");
            System.out.println("\nВывод списка лодок после чтения из файла boats.dat:");
            boatsFromFile.forEach(System.out::println);

            XMLHandler.writeBoatsToXML(boatList.getBoats(), "boats.xml");

            List<Boat> boatsFromXML = XMLHandler.readBoatsFromXML("boats.xml");
            System.out.println("\nВывод списка лодок после чтения из XML boats.xml:");
            boatsFromXML.forEach(System.out::println);

            JSONHandler.writeBoatsToJSON(boatList.getBoats(), "boats.json");

            List<Boat> boatsFromJSON = JSONHandler.readBoatsFromJSON("boats.json");
            System.out.println("\nВывод списка лодок после чтения из JSON boats.json:");
            boatsFromJSON.forEach(System.out::println);

            SecretKey secretKey = EncryptionUtil.generateKey();
            EncryptionUtil.encryptFile("boats.json", "boats_encrypted.json", secretKey);
            EncryptionUtil.decryptFile("boats_encrypted.json", "boats_decrypted.json", secretKey);

            List<Boat> originalBoats = JSONHandler.readBoatsFromJSON("boats.json");
            List<Boat> decryptedBoats = JSONHandler.readBoatsFromJSON("boats_decrypted.json");

            if (originalBoats.equals(decryptedBoats))
            {
                System.out.println("\nСодержимое файлов идентично. Шифрование и дешифрование выполнены успешно.");
            }
            else
            {
                System.out.println("\nСодержимое файлов отличается. Проверьте алгоритмы шифрования и дешифрования.");
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
