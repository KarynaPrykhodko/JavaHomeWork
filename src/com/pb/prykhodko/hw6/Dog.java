package com.pb.prykhodko.hw6;

import java.util.Objects;

public class Dog extends Animal {
    private int howManyTimesBarksPerDay;

    public Dog(String food, String location, int howManyTimesBarksPerDay) {
        super(food, location);
        this.howManyTimesBarksPerDay = howManyTimesBarksPerDay;
    }


    @Override
    public void eat() {
        System.out.println(" Кушаю: " + getFood());
    }

    @Override
    public void makeNoise() {
        System.out.println("woof");
    }

    @Override
    public String toString() {
        return "Я собака, и я кушаю: " + getFood() + " и я живу: " + getLocation() + " гавкаю " + howManyTimesBarksPerDay + " раз в день";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return howManyTimesBarksPerDay == dog.howManyTimesBarksPerDay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(howManyTimesBarksPerDay);
    }
}
