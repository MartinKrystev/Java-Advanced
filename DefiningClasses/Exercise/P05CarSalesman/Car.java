package com.company.DefiningClasses.Exercise.P05CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;


    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}
