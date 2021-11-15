package com.pb.prykhodko.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {


    public Pants(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public String toString() {
        return "Штаны унисекс: " + "размер - " + size + ", цена: - " + cost + " грн., цвет - " + color;
    }

    @Override
    public void dressMan() {
        System.out.println("Штаны мужские: " + size + ", цена: " + cost + ", цвет: " + color);

    }

    @Override
    public void dressWomen() {
        System.out.println("Штаны женские: " + size + ", цена: " + cost + ", цвет: " + color);
    }
}
