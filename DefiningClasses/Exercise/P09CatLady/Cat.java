package com.company.DefiningClasses.Exercise.P09CatLady;

public class Cat {
    private String name;
    private String breed;
    private double measures;

    public Cat( ) {
    }

    public Cat(String name, String breed, double measures) {
        this.name = name;
        this.breed = breed;
        this.measures = measures;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.breed, this.name, this.measures);
    }
}
