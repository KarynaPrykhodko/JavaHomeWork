package com.pb.prykhodko.hw5;

import java.util.Arrays;

public class Library {

    public static void main(String[] args) {
        Book[] allBooks = new Book[6];
        allBooks[0] = new Book("Война и мир", "Лев Толстой", 1869);
        allBooks[1] = new Book("Гордость и предубеждение", "Джейн Остин", 1813);
        allBooks[2] = new Book("Божественная комедия", "Данте Алигьери", 1321);
        allBooks[3] = new Book("Унесённые ветром", "Маргарет Митчелл", 1936);
        allBooks[4] = new Book("Сто лет одиночества", "Габриэль Гарсия Маркес", 1967);
        allBooks[5] = new Book("Над пропастью во ржи", "Джером Д. Сэлинджер", 1951);

        System.out.println("Все доступные книги: ");
        int countBooks = 1;
        for (Book book : allBooks) {
            System.out.println(countBooks + ") " + book.toString());
            countBooks++;
        }

        Reader[] allReaders = new Reader[6];
        allReaders[0] = new Reader("Гаврилюк Марина", 324, "Экономический", "19.09.1990", "380981111111");
        allReaders[1] = new Reader("Номеровский Сергей", 325, "Иностранных языков", "20.09.1990", "38099222222");
        allReaders[2] = new Reader("Анциферов Дмитрий", 326, "Географический", "21.09.1990", "380983333333");
        allReaders[3] = new Reader("Рогожев Владислав", 327, "Исторический", "22.09.1990", "380984444444");
        allReaders[4] = new Reader("Приходько Карина", 328, "По завоеванию мира", "23.09.1990", "380985555555");
        allReaders[5] = new Reader("Мустафаев Эльдар", 329, "Шашлыковединие", "24.09.1990", "380986666666");

        System.out.println("Все зарегистрированные читатели библиотеки:");
        int countReaders = 1;
        for (Reader reader : allReaders) {
            System.out.println(countReaders + ") " + reader.toString());
            countReaders++;
        }


        allReaders[0].takeBook(5);
        allReaders[1].takeBook(allBooks[0].getBookTitle(), allBooks[1].getBookTitle(), allBooks[2].getBookTitle());
        allReaders[2].takeBook(allBooks[0], allBooks[1], allBooks[2]);
        allReaders[3].returnBook(4);
        allReaders[4].returnBook(allBooks[3].getBookTitle(), allBooks[4].getBookTitle(), allBooks[5].getBookTitle());
        allReaders[5].returnBook(allBooks[3], allBooks[4], allBooks[5]);

    }


}
