package com.company.DefiningClasses.Exercise.P03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int traveledKm;

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.traveledKm = 0;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelCostPerKm(double fuelCostPerKm) {
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public boolean canDrive(int distance) {
        double fuelNeeded = this.fuelCostPerKm * distance;

        if (this.fuelAmount >= fuelNeeded) {
            this.fuelAmount -= fuelNeeded;
            this.traveledKm += distance;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.model + " " + String.format("%.2f", this.fuelAmount) + " " + this.traveledKm;
    }
}
