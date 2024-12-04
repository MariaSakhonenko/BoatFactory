package com.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XMLHandler
{

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

    public static void writeBoatsToXML(List<Boat> boats, String fileName) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element rootElement = doc.createElement("boats");
        doc.appendChild(rootElement);

        for (Boat boat : boats)
        {
            Element boatElement = doc.createElement("boat");

            boatElement.setAttribute("id", String.valueOf(boat.getId()));
            boatElement.setAttribute("type", boat.getType());

            Element model = doc.createElement("model");
            model.appendChild(doc.createTextNode(boat.getModel()));
            boatElement.appendChild(model);

            Element enginePower = doc.createElement("enginePower");
            enginePower.appendChild(doc.createTextNode(String.valueOf(boat.getEnginePower())));
            boatElement.appendChild(enginePower);

            Element maxSpeed = doc.createElement("maxSpeed");
            maxSpeed.appendChild(doc.createTextNode(String.valueOf(boat.getMaxSpeed())));
            boatElement.appendChild(maxSpeed);

            Element releaseDate = doc.createElement("releaseDate");
            releaseDate.appendChild(doc.createTextNode(dateFormat.format(boat.getReleaseDate())));
            boatElement.appendChild(releaseDate);

            Element price = doc.createElement("price");
            price.appendChild(doc.createTextNode(String.valueOf(boat.getPrice())));
            boatElement.appendChild(price);

            if (boat instanceof Sailboat)
            {
                Element sailArea = doc.createElement("sailArea");
                sailArea.appendChild(doc.createTextNode(String.valueOf(((Sailboat) boat).getSailArea())));
                boatElement.appendChild(sailArea);
            }

            rootElement.appendChild(boatElement);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(fileName));
        transformer.transform(source, result);
    }

    public static List<Boat> readBoatsFromXML(String fileName) throws Exception
    {
        List<Boat> boats = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileName));

        NodeList nodeList = doc.getElementsByTagName("boat");

        for (int i = 0; i < nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                int id = Integer.parseInt(element.getAttribute("id"));
                String type = element.getAttribute("type");
                String model = element.getElementsByTagName("model").item(0).getTextContent();
                int enginePower = Integer.parseInt(element.getElementsByTagName("enginePower").item(0).getTextContent());
                int maxSpeed = Integer.parseInt(element.getElementsByTagName("maxSpeed").item(0).getTextContent());
                Date releaseDate = dateFormat.parse(element.getElementsByTagName("releaseDate").item(0).getTextContent());
                double price = Double.parseDouble(element.getElementsByTagName("price").item(0).getTextContent());

                if ("Парусник".equals(type))
                {
                    int sailArea = Integer.parseInt(element.getElementsByTagName("sailArea").item(0).getTextContent());
                    Sailboat sailboat = new Sailboat();
                    sailboat.setId(id);
                    sailboat.setType(type);
                    sailboat.setModel(model);
                    sailboat.setEnginePower(enginePower);
                    sailboat.setMaxSpeed(maxSpeed);
                    sailboat.setReleaseDate(releaseDate);
                    sailboat.setPrice(price);
                    sailboat.setSailArea(sailArea);
                    boats.add(sailboat);
                }
            }
        }

        return boats;
    }
}
