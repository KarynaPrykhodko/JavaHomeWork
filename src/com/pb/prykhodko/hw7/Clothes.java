package com.pb.prykhodko.hw7;

public abstract class Clothes {
    Size size;
    double cost;
    String color;

    public Clothes(Size size, double cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }


}
