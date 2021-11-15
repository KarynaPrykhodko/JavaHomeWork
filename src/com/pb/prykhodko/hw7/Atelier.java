package com.pb.prykhodko.hw7;

public class Atelier {

    public static void main(String[] args) {

        Pants p1 = new Pants(Size.M,2000,"red");
        Skirt s1 = new Skirt(Size.L, 3000,"Blue");
        Tie t1 = new Tie(Size.S,1000,"multicolored");
        Tshirt ts1 = new Tshirt(Size.L, 1500, "White");
        Clothes [] allClothes = new Clothes[]{p1,s1,t1,ts1};


        dressMan(allClothes);
        dressWomen(allClothes);


    }
    static void dressMan(Clothes[] clothes){
        System.out.println("Мужская одежда: ");
        for (Clothes clothes1:clothes){
            if (clothes1 instanceof ManClothes){
                System.out.println(clothes1);;
            }
        }

    }
    static void dressWomen(Clothes[] clothes){
        System.out.println("Женская одежда: ");
        for (Clothes clothes1:clothes){
            if (clothes1 instanceof WomenClothes){
                System.out.println(clothes1);;
            }
        }

    }
}
