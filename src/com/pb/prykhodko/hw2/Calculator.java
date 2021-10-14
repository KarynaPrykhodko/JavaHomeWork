package com.pb.prykhodko.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operand1, operand2;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение для operand1 ");
        operand1 = scanner.nextInt();
        System.out.println("Введите значение для operand2 ");
        operand2 = scanner.nextInt();
        System.out.println("Что Вы хотите сделать с этими операндами? ");
        System.out.println("Вам доступны следующие арифметические операции: +  -  *  /  ");
        String sign = scanner.next();
        scanner.close();
        switch (sign) {
            case ("+"):
                System.out.println(operand1 + operand2);
                break;
            case ("-"):
                System.out.println(operand1 - operand2);
                break;
            case ("*"):
                System.out.println(operand1 * operand2);
                break;
            case ("/"):
                if (operand2 != 0) {
                    System.out.println((double)operand1 / (double)operand2);

                } else System.out.println("Вы не можете делить на ноль");
                break;
            default:
                System.out.println("Это недоступная арифметическая операция или вовсе арифметической операцией не является");
        }
    }
}
