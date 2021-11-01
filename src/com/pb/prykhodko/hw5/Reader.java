package com.pb.prykhodko.hw5;


public class Reader {

    private String firstAndLastName;
    private int libraryCardNumber;
    private String faculty;
    private String birthDate;
    private String phoneNumber;

    public Reader(String firstAndLastName, int libraryCardNumber, String faculty, String birthDate, String phoneNumber) {
        this.firstAndLastName = firstAndLastName;
        this.libraryCardNumber = libraryCardNumber;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public void setFirstAndLastName(String firstAndLastName) {
        this.firstAndLastName = firstAndLastName;
    }

    public int getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(int libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void takeBook(int takeBooks) {
        System.out.println(getFirstAndLastName() + " взял(а) " + takeBooks + " книг(и)");
    }

    public void takeBook(String... takesBooksTitle) {
        System.out.print(getFirstAndLastName() + " взял(a) книг(и):");
        for (String book : takesBooksTitle) {
            System.out.print(book + ", ");
        }
        System.out.println();
    }

    public void takeBook(Book... books) {
        System.out.print(getFirstAndLastName() + " взял(а) книг(и): ");
        for (Book book : books) {
            System.out.print(book.toString() + ", ");
        }
        System.out.println();
    }

    public void returnBook(int returnBooks) {
        System.out.println(getFirstAndLastName() + " вернул(а) " + returnBooks + " книг(и)");
    }

    public void returnBook(String... takesBooksTitle) {
        System.out.print(getFirstAndLastName() + " вернул(a) книги:");
        for (String book : takesBooksTitle) {
            System.out.print(book + ", ");
        }
        System.out.println();
    }

    public void returnBook(Book... books) {
        System.out.print(getFirstAndLastName() + " вернул(а) книг(и): ");
        for (Book book : books) {
            System.out.print(book.toString() + ", ");
        }
        System.out.println();
    }


    @Override
    public String toString() {
        return "ФИО: " + firstAndLastName + ", Номер карточки: " + libraryCardNumber + ", Факультет: "
                + faculty + ", Дата Рождения: " + birthDate + ", Номер телефона: " + phoneNumber;
    }
}
