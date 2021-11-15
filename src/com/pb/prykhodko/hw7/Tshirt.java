package com.pb.prykhodko.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {
    public Tshirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {

    }

    @Override
    public void dressWomen() {

    }

    @Override
    public String toString() {
        return "Tshirt{" +
                "size=" + size +
                ", cost=" + cost +
                ", color='" + color + '\'' +
                '}';
    }
}
