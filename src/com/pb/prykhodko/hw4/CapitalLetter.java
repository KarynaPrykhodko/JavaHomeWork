package com.pb.prykhodko.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class CapitalLetter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        firstLetterToUpperCase(scanner);
    }

    static void firstLetterToUpperCase(Scanner scanner) {

        String str = scanner.nextLine();
        stringToStringArray(str);
        scanner.close();
    }

    static void stringToStringArray(String str) {
        for (String word : str.split(" ")) {
            String toUpperCaseFirstLetter = word.substring(0, 1).toUpperCase() + word.substring(1);
            System.out.print(toUpperCaseFirstLetter + " ");
        }
    }
}
