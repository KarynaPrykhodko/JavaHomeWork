package com.pb.prykhodko.hw3;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {

        int[] array = new int[10];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Необходимо заполнить массив целых чисел, размером в 10 элементов.");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите элемент массива " + (i + 1) + ":");
            int x = scanner.nextInt();
            array[i] = x;
        }

        System.out.println("Введенный массив: ");
        for (Integer elem : array) {
            System.out.print(elem + " ");
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count += array[i];

        }
        System.out.println();
        System.out.println("Cумма всех элементов массива: " + count);

        int count2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                count2++;
            }
        }
        System.out.println("Количество положительных элементов массива: " + count2);

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        }

        System.out.println("Сортируем массив пузырьком, и на выходе получаем: ");
        for (Integer elem : array) {
            System.out.print(elem + " ");

        }
    }
}