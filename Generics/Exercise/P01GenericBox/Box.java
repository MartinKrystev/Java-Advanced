package com.company.Generics.Exercise.P01GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstIndexEl = elements.get(firstIndex);
        T secondIndexEl = elements.get(secondIndex);

        elements.set(secondIndex, firstIndexEl);
        elements.set(firstIndex, secondIndexEl);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T el : elements) {
            if (el.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T element : elements) {
            sb.append(element.getClass().getName()).append(": ").append(element).append("\n");
        }
        return sb.toString();
    }

}
