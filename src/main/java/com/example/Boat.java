package com.example;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.Date;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(
        {
        @JsonSubTypes.Type(value = Sailboat.class, name = "Парусник"),
        @JsonSubTypes.Type(value = Motorboat.class, name = "Моторная лодка"),
        @JsonSubTypes.Type(value = Catamaran.class, name = "Катамаран")
        })
public abstract class Boat implements Serializable
{
    private int id;
    private String type;
    private String model;
    private int enginePower;
    private int maxSpeed;
    private Date releaseDate;
    private double price;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getEnginePower() { return enginePower; }
    public void setEnginePower(int enginePower) { this.enginePower = enginePower; }

    public int getMaxSpeed() { return maxSpeed; }
    public void setMaxSpeed(int maxSpeed) { this.maxSpeed = maxSpeed; }

    public Date getReleaseDate() { return releaseDate; }
    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString()
    {
        return "Boat{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", enginePower=" + enginePower +
                ", maxSpeed=" + maxSpeed +
                ", releaseDate=" + releaseDate +
                ", price=" + price +
                '}';
    }
}
