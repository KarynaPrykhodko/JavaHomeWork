package com.pb.prykhodko.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {


    public Pants(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public String toString() {
        return "Pants{" +
                "size=" + size +
                ", cost=" + cost +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void dressMan() {
        System.out.println(Pants.class.getSimpleName() + " size: "+ size + " price "+ cost + " color "+ color);

    }

    @Override
    public void dressWomen() {
        System.out.println( Pants.class.getSimpleName() + " size: "+ size + " price "+ cost + " color "+ color);
    }
}
