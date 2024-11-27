package com.example;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EncryptionUtil
{

    private static final String ALGORITHM = "AES";

    public static SecretKey generateKey() throws Exception
    {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(256);
        return keyGen.generateKey();
    }

    public static void encryptFile(String inputFile, String outputFile, SecretKey key) throws Exception
    {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] inputBytes = Files.readAllBytes(Paths.get(inputFile));
        byte[] outputBytes = cipher.doFinal(inputBytes);

        Files.write(Paths.get(outputFile), outputBytes);
    }

    public static void decryptFile(String inputFile, String outputFile, SecretKey key) throws Exception
    {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] inputBytes = Files.readAllBytes(Paths.get(inputFile));
        byte[] outputBytes = cipher.doFinal(inputBytes);

        Files.write(Paths.get(outputFile), outputBytes);
    }
}
