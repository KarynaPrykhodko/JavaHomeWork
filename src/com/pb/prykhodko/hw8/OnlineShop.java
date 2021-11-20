package com.pb.prykhodko.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {

        Auth auth = new Auth();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать на наш сервис, пройдите регистрацию");
        System.out.println("Введите логин (от 2 до 20 символов, только латинские буквы ");
        String s = scanner.nextLine();
        System.out.println("Введите пароль ( от 5 символов только латинские символы и цифры а также знак _ :");
        String s1 = scanner.nextLine();
        System.out.println("Введите пароль повторно: ");
        String s2 = scanner.nextLine();

        try {
            auth.signUp(s,s1,s2);
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
        }

        System.out.println("Введите логин и пароль для входа на сервис: ");
        System.out.println("Введите логин: ");
        String s3 = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String s4 = scanner.nextLine();
        try {
            auth.signIn(s3,s4);
        } catch (WrongPasswordException | WrongLoginException e) {
            e.printStackTrace();
        }

    }


}
