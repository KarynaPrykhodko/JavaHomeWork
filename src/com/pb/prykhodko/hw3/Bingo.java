package com.pb.prykhodko.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        System.out.println("Программа загадала произволное число от 0 до 100, отгадаете?");
        Random random = new Random();
        int hiddenNumber = random.nextInt(101);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Ваш вариант и да начнется игра");
        System.out.println("Если ты не хочешь продолжать введи 666 ");
        int counter = 0;
        while (counter < 100) {
            counter++;
            System.out.println("Попытка " + counter);
            int x = scanner.nextInt();
            if (x != 666) {
                if (hiddenNumber != x) {
                    System.out.println("Неудачная попытка пробуй еще");
                    if (x > hiddenNumber) {
                        System.out.println("Загаданное число меньше Вашего варианта");
                    }  else System.out.println("Загаданное число больше Вашего варианта");
                } else {
                    System.out.println("Прийми мои поздавления, ты счастливчик");
                    System.out.println("Количество использованных попыток: " + counter);
                    System.exit(0);
                }
            }else{
                System.out.println("Может в следующий раз....");
                System.exit(0);
            }
        }
        System.out.println("Просто не верится, Вы не угадали даже за 100 попыток, из 100 возможных вариантов.....");


    }
}
