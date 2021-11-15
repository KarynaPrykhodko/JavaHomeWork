package com.pb.prykhodko.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {
    public Tshirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Футболка мужская: " + size + ", цена: " + cost + ", цвет: " + color);

    }

    @Override
    public void dressWomen() {
        System.out.println("Футболка женская: " + size + ", цена: " + cost + ", цвет: " + color);

    }

    @Override
    public String toString() {
        return "Футболка: размер - " + size + ", стоимость  - " + cost + ", цвет - " + color;
    }
}
