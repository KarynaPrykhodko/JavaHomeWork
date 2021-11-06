package com.pb.prykhodko.hw6;

import java.util.Objects;

public class Horse extends Animal {

    private int runningSpeed;

    public Horse(String food, String location, int runningSpeed) {
        super(food, location);
        this.runningSpeed = runningSpeed;
    }


    @Override
    public void eat() {
        System.out.println(" Кушаю: " + getFood());
    }

    @Override
    public void makeNoise() {
        System.out.println("neigh");
    }

    @Override
    public String toString() {
        return "Я лошадь, я кушаю: " + getFood() + " и я живу: "+ getLocation() + " скачу со скоростью " + runningSpeed + " километров в час";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Horse horse = (Horse) o;
        return runningSpeed == horse.runningSpeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), runningSpeed);
    }
}
