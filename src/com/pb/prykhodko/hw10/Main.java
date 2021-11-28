package com.pb.prykhodko.hw10;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        NumBox<Integer> numBox = new NumBox<>(5);
        numBox.add(1);
        numBox.add(2);
        numBox.add(4);
        numBox.add(3);

        NumBox<Float> numBox1 = new NumBox<>(4);
        numBox1.add(10.34f);
        numBox1.add(15.34f);
        numBox1.add(12.34f);

        System.out.println("Элемент массива под индексом 4 : " + numBox.get(4));//Сознательная проверка незаполненного участка массива
        System.out.println("Элемент массива типа Integer под индексом 1 : " + numBox.get(1));
        System.out.println("Элемент массива типа Float под индексом 2 : " + numBox1.get(2));
        System.out.println("Текущее количествор элементов массива типа Integer: " + numBox.length());
        System.out.println("Текущее количествор элементов массива типа Float: " + numBox1.length());
        System.out.println("Среднее значение всех элементов массива типа Integer: " + numBox.average());
        System.out.println("Среднее значение всех элементов массива типа Float: " + numBox1.average());
        System.out.println("Сумма всех элементов массива типа Integer: " + numBox.sum());
        System.out.println("Сумма всех элементов массива типа Float: " + numBox1.sum());
        System.out.println("Максимальный элемент массива типа Integer: " + numBox.max());
        System.out.println("Максимальный элемент массива типа Float: " + numBox1.max());


    }
}
