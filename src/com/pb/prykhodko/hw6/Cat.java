package com.pb.prykhodko.hw6;

import java.util.Objects;

public class Cat extends Animal {

    private int howManyTimesSharpensClawsPerMonth;

    public Cat(String food, String location, int howManyTimesSharpensClawsPerMonth) {
        super(food, location);
        this.howManyTimesSharpensClawsPerMonth = howManyTimesSharpensClawsPerMonth;
    }


    public void eat() {
        System.out.println(" Кушаю: " + getFood());
    }

    public void makeNoise() {
        System.out.println("Мяу");
    }

    @Override
    public String toString() {
        return "Я кот и я кушаю: " + getFood() + " Я живу: " + getLocation() + " точу когти " + howManyTimesSharpensClawsPerMonth + " в месяц";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return howManyTimesSharpensClawsPerMonth == cat.howManyTimesSharpensClawsPerMonth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(howManyTimesSharpensClawsPerMonth);
    }
}
