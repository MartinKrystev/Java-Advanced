package com.company.ExamPrep.Exam1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P03EasterBasket {
    public static void main(String[] args) {

    }
}

//
//package easterBasket;
//
//        import java.util.ArrayList;
//        import java.util.Comparator;
//        import java.util.List;
//
//public class Basket {
//
//    private String material;
//    private int capacity;
//    private List<Egg> data;
//
//    public Basket(String material, int capacity) {
//        this.material = material;
//        this.capacity = capacity;
//        this.data = new ArrayList<>();
//    }
//
//    public void addEgg(Egg egg) {
//        if (data.size() < capacity) {
//            data.add(egg);
//        }
//    }
//
//    public boolean removeEgg(String color) {
//        Egg egg = this.getEgg(color);
//        data.remove(egg);
//        return egg != null;
//    }
//
//    public Egg getStrongestEgg() {
//        return data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
//    }
//
//    public Egg getEgg(String color) {
//        return data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
//    }
//
//    public int getCount() {
//        return data.size();
//    }
//
//    public String report() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("%s basket contains:%n", material));
//
//        data.forEach(egg -> sb.append(egg.toString()).append(String.format("%n")));
//
//        return sb.toString().trim();
//    }
//}
//
//
//package easterBasket;
//
//public class Egg {
//    private String color;
//
//    private int strength;
//
//    private String shape;
//
//    public Egg(String color, int strength, String shape) {
//        this.color = color;
//        this.strength = strength;
//        this.shape = shape;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public int getStrength() {
//        return strength;
//    }
//
//    public void setStrength(int strength) {
//        this.strength = strength;
//    }
//
//    public String getShape() {
//        return shape;
//    }
//
//    public void setShape(String shape) {
//        this.shape = shape;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%s egg, with %d strength and %s shape.", color,strength,shape);
//    }
//}
