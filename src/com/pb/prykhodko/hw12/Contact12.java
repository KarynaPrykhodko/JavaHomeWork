package com.pb.prykhodko.hw12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Contact12 implements Comparable<Contact12> {

    static int count = 0;
    private String name;
    private LocalDate dateOfBirth;
    private ArrayList<String> phoneNumbers;
    private String address;
    private String changeOrMakeContactDate;

    public Contact12() {
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getChangeOrMakeContactDate() {
        return changeOrMakeContactDate;
    }

    public void setChangeOrMakeContactDate(String changeOrMakeContactDate) {

        this.changeOrMakeContactDate = changeOrMakeContactDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact12 contact = (Contact12) o;
        return Objects.equals(name, contact.name) &&
                Objects.equals(dateOfBirth, contact.dateOfBirth) &&
                Objects.equals(phoneNumbers, contact.phoneNumbers) &&
                Objects.equals(address, contact.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, phoneNumbers, address);
    }

    @Override
    public String toString() {

        return "Контакт " + "\n" +
                "Имя: " + name + "\n" +
                "Дата Рождения: " + dateOfBirth + "\n" +
                "Телефон(ы): " + phoneNumbers + "\n" +
                "Адрес: " + address + "\n" +
                "Дата создания или изменения контакта: " + changeOrMakeContactDate+ "\n";
    }

    @Override
    public int compareTo(Contact12 o) {

        return 0;
    }
}
