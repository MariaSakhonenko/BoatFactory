package com.example;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil
{

    public static void zipFile(String inputFile, String outputFile) throws IOException
    {
        try (FileOutputStream fos = new FileOutputStream(outputFile);
             ZipOutputStream zos = new ZipOutputStream(fos))
        {
            File fileToZip = new File(inputFile);
            try (FileInputStream fis = new FileInputStream(fileToZip))
            {
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zos.putNextEntry(zipEntry);
                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0)
                {
                    zos.write(bytes, 0, length);
                }
            }
        }
    }
}
