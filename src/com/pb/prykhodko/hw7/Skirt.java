package com.pb.prykhodko.hw7;

public class Skirt extends Clothes implements WomenClothes {


    public Skirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressWomen() {
        System.out.println( Pants.class.getSimpleName() + " size: "+ size + " price "+ cost + " color "+ color);

    }

    @Override
    public String toString() {
        return "Юбка: " + "Размер - " + size + ", Цена - " + cost + " грн., цвет - " + color;
    }
}
