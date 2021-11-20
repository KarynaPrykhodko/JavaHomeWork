package com.pb.prykhodko.hw8;

import java.util.Scanner;
import java.util.regex.Pattern;

public class OnlineShop {
    public static void main(String[] args) {
        int count = 0;
        Auth auth = new Auth();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать на наш сервис, пройдите регистрацию");
        System.out.println("Введите логин (от 2 до 20 символов, только латинские буквы ");
        checkLoginForCompliance(scanner.nextLine(), auth);
//        System.out.println("Введите пароль: ");
//        auth.setPassword(scanner.nextLine());
//        System.out.println("Введите пароль повторно: ");
//        String confPas = scanner.nextLine();
    }
    static void checkLoginForCompliance(String str, Auth auth){

        if (str.matches("^[a-zA-Z][a-zA-Z0-9]{2,19}$")) {
            auth.setLogin(str);
        }else {
            System.out.println("Введенный логин не соответствует условиям");
        }
    }
    static void checkPasswordForCompliance(String str, Auth auth){
        if (str.matches("'/^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{8,20}$/'")) {
            auth.setLogin(str);
        }else {
            System.out.println("Введенный логин не соответствует условиям");
        }
    }
}
