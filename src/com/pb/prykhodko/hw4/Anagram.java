package com.pb.prykhodko.hw4;

import com.pb.prykhodko.hw3.Array;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Приветствую, давай проверим является ли первое введенное предложение анаграммой второго");
        System.out.println("Введите первое предложение для проверки ");
        String str1 = scanner.nextLine();
        System.out.println("Введите второе предложение для проверки");
        String str2 = scanner.nextLine();
        anagramCheck(str1, str2);
    }

    private static void anagramCheck(String str1, String str2) {
        String str1ToCheck = getString(str1);
        String str2ToCheck = getString(str2);
        if (str1ToCheck.equals(str2ToCheck)){
            System.out.println("Это анаграмма");
        }else System.out.println("Это не анаграмма");
    }

    private static String getString(String str) {
        str = str.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ]", "").toLowerCase();
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return Arrays.toString(charArr);
    }
}
