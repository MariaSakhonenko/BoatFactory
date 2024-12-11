package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONHandler
{

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void writeBoatsToJSON(List<Boat> boats, String fileName) throws IOException
    {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File(fileName), boats);
    }

    public static List<Boat> readBoatsFromJSON(String fileName) throws IOException
    {
        return objectMapper.readValue(new File(fileName),
               objectMapper.getTypeFactory().constructCollectionType(List.class, Boat.class));
    }
}
