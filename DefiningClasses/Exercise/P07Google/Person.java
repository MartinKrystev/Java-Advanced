package com.company.DefiningClasses.Exercise.P07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private Car car;

    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;


    public Person(String name) {
        this.name = name;
        this.company = null;
        this.car = null;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Child> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("\n");

        sb.append("Company:").append("\n");
        if (this.company != null) {
            sb.append(company.toString()).append("\n");
        }

        sb.append("Car:").append("\n");
        if (this.car != null) {
            sb.append(car.toString()).append("\n");
        }

        sb.append("Pokemon:").append("\n");
        if (this.pokemons.size() != 0) {
            for (Pokemon pokemon : pokemons) {
                sb.append(pokemon.toString()).append("\n");
            }
        }

        sb.append("Parents:").append("\n");
        if (this.parents.size() != 0) {
            for (Parent parent : parents) {
                sb.append(parent.toString()).append("\n");
            }
        }

        sb.append("Children:").append("\n");
        if (this.children.size() != 0) {
            for (Child child : children) {
                sb.append(child.toString()).append("\n");
            }
        }

        return sb.toString();
    }
}
