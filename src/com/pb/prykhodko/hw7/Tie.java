package com.pb.prykhodko.hw7;

public class Tie extends Clothes implements ManClothes {
    public Tie(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Галстук: " + size + ", цена: " + cost + ", цвет: " + color);

    }

    @Override
    public String toString() {
        return "Галстук: размер - " + size + ", цена - " + cost + ", цвет - " + color;
    }
}
