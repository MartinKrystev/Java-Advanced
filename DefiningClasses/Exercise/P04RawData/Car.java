package com.company.DefiningClasses.Exercise.P04RawData;

public class Car {
    private int speed;
    private int engine;
    private int cargo;
    private String cargoType;


    private double tire1Pressure;
    private int tire1Age;
    private double tire2Pressure;
    private int tire2Age;
    private double tire3Pressure;
    private int tire3Age;
    private double tire4Pressure;
    private int tire4Age;


    public Car(int speed, int engine, int cargo, String cargoType,
               double tire1Pressure, int tire1Age,
               double tire2Pressure, int tire2Age,
               double tire3Pressure, int tire3Age,
               double tire4Pressure, int tire4Age) {
        this.speed = speed;
        this.engine = engine;
        this.cargo = cargo;
        this.cargoType = cargoType;
        this.tire1Pressure = tire1Pressure;
        this.tire1Age = tire1Age;
        this.tire2Pressure = tire2Pressure;
        this.tire2Age = tire2Age;
        this.tire3Pressure = tire3Pressure;
        this.tire3Age = tire3Age;
        this.tire4Pressure = tire4Pressure;
        this.tire4Age = tire4Age;
    }

    public String getCargoType() {
        return cargoType;
    }

    public double getTire1Pressure() {
        return tire1Pressure;
    }

    public double getTire2Pressure() {
        return tire2Pressure;
    }

    public double getTire3Pressure() {
        return tire3Pressure;
    }

    public double getTire4Pressure() {
        return tire4Pressure;
    }

    public int getEngine() {
        return engine;
    }
}
