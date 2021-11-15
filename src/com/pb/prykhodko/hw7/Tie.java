package com.pb.prykhodko.hw7;

public class Tie extends Clothes implements ManClothes {
    public Tie(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {

    }

    @Override
    public String toString() {
        return "Tie{" +
                "size=" + size +
                ", cost=" + cost +
                ", color='" + color + '\'' +
                '}';
    }
}
