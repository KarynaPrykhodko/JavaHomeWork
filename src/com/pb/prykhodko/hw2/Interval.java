package com.pb.prykhodko.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число для проверки: ");
        number = scanner.nextInt();
        scanner.close();
        if (number >= 0 && number <= 14) {
            System.out.println("Введенное число находится в интервале от 0 до 14");
        } else if (number >= 15 && number <= 35) {
            System.out.println("Введенное число находится в интервале от 15 до 35");
        } else if (number >= 36 && number <= 50) {
            System.out.println("Введенное число находится в интервале от 36 до 50");
        } else if (number >= 51 && number <= 100) {
            System.out.println("Введенное число находится в интервале от 51 до 100");
        } else System.out.println("Ваше число не попадает ни в один из возможных интервалов");

    }
}
