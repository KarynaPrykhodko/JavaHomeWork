package com.pb.prykhodko.hw11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        ArrayList<Contact> allContacts = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);
        System.out.println("Приветствую Вас в Вашей записной книге: ");
        generalMenu(allContacts, mapper);

    }

    private static void generalMenu(ArrayList<Contact> allContacts, ObjectMapper mapper) throws JsonProcessingException {

        System.out.println("Выберите действие которое Вы хотите совершить: ");
        System.out.println("Доступные действия: ");
        System.out.println("Для просмотра всех доступных контактов нажмите 1");
        System.out.println("Для записи нового контакта нажмите 2");
        System.out.println("Для удаления контакта нажмите 3 ");
        System.out.println("Для сортировки нажмите 4 ");
        System.out.println("Для редактирования контакта нажмите 5 ");
        System.out.println("Для записи в файл всех данных нажмите 6 ");
        System.out.println("Для загрузки всей телефонной книги 7 ");
        System.out.println("Для выхода из программы нажмите 999");
        System.out.println("Введите Ваш выбор: ");

        Scanner scannerGeneralNavigation = new Scanner(System.in);
        if (scannerGeneralNavigation.hasNextInt()) {
            int chooseGeneralDoing = scannerGeneralNavigation.nextInt();
            switch (chooseGeneralDoing) {
                case 1:
                    if (allContacts.isEmpty()) {
                        System.out.println("Телефонная книга пустая :(");
                        System.out.println("");
                    } else {
                        System.out.println(allContacts);
                    }
                    generalMenu(allContacts, mapper);

                    break;
                case 2:
                    addNewContact(allContacts);
                    generalMenu(allContacts, mapper);
                    break;
                case 3:
                    deleteContact(allContacts);
                    generalMenu(allContacts, mapper);
                    break;
                case 4:
                    sortContacts(allContacts);
                    generalMenu(allContacts, mapper);
                    break;
                case 5:
                    editContact(allContacts, mapper);
                    generalMenu(allContacts, mapper);
                    break;
                case 6:
                    String contactJson = mapper.writeValueAsString(allContacts);
                    Path path = Paths.get("C:\\Users\\Aleksandr\\IdeaProjects\\JavaHomeWork\\src\\com\\pb\\prykhodko\\hw11\\jsonFile.txt");
                    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                        writer.write(contactJson);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Успешно записано");
                    generalMenu(allContacts, mapper);

                    break;
                case 7:
                    readFromFile(mapper);


                    break;
                case 999:
                    System.exit(0);

                default:
                    System.out.println("Данное действие недоступно, попробуйте еще раз");


            }
        }
    }

    private static void readFromFile(ObjectMapper mapper) {
        ArrayList<Contact> allContacts;
        Path path1 = Paths.get("C:\\Users\\Aleksandr\\IdeaProjects\\JavaHomeWork\\src\\com\\pb\\prykhodko\\hw11\\jsonFile.txt");
        try (BufferedReader reader = Files.newBufferedReader(path1)) {
            String line;
            String contactJson1 = "";
            while ((line = reader.readLine()) != null) {
                contactJson1 += line;
            }
            allContacts = mapper.readValue(contactJson1, new TypeReference<ArrayList<Contact>>() {
            });
            System.out.println("Контакты успешно загружены");
            generalMenu(allContacts, mapper);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void editContact(ArrayList<Contact> allContacts, ObjectMapper mapper) throws JsonProcessingException {
        System.out.println("Введите имя контакта для редактирования, доступные контакты для редактирования: ");
        Iterator<Contact> contactIterator = allContacts.iterator();
        while (contactIterator.hasNext()) {
            Contact nextCont = contactIterator.next();
            System.out.println(nextCont.getName());
        }
        Scanner scannerForEdit = new Scanner(System.in);
        String nameForEdit = scannerForEdit.nextLine();
        for (Contact nextCont2 : allContacts) {
            if (!nextCont2.getName().equals(nameForEdit)) {
                continue;
            } else if (nextCont2.getName().equals(nameForEdit)) {
                chooseForEdit(nextCont2);
                break;
            } else {
                System.out.println("Вы ввели, имя контакта, которого не существует");
                System.out.println("попробуйте еще раз");
                editContact(allContacts, mapper);
            }
        }
    }

    private static void chooseForEdit(Contact nextCont2) {
        System.out.println("Выберите что нужно отредактировать:");
        System.out.println("Если Вы хотите отредактировать имя нажмите 1");
        System.out.println("Если Вы хотите отредактировать дату рождения нажмите 2");
        System.out.println("Если Вы хотите отредактировать все номера телефона нажмите 3");
        System.out.println("Если Вы хотите отредактировать адрес нажмите 4");
        System.out.println("Ничего не редактировать и выйти в главное меню, нажмите 5");
        Scanner scannerChooseForEdit = new Scanner(System.in);
        if (scannerChooseForEdit.hasNextInt()) {
            int choose = scannerChooseForEdit.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Введите новое имя: ");
                    Scanner scannerNewName = new Scanner(System.in);
                    String newName = scannerNewName.nextLine();
                    nextCont2.setName(newName);
                    setDateAndTimeEdition(nextCont2);
                    System.out.println("Имя успешно отредактировано");
                    System.out.println(nextCont2);
                    break;

                case 2:
                    Scanner scannerChangeBirthDate = new Scanner(System.in);
                    System.out.println("Введите год рождения");
                    int year = scannerChangeBirthDate.nextInt();
                    System.out.println("Введите месяц рождения");
                    int month = scannerChangeBirthDate.nextInt();
                    System.out.println("Введите день месяца рождения");
                    int day = scannerChangeBirthDate.nextInt();
                    nextCont2.setDateOfBirth(LocalDate.of(year, month, day));
                    setDateAndTimeEdition(nextCont2);
                    System.out.println("Дата рождения успешно отредактирована");
                    System.out.println(nextCont2);
                    break;

                case 3:
                    ArrayList<String> numbersNew = new ArrayList<>();//list for new numbers for this contact
                    addNumber(numbersNew);
                    nextCont2.setPhoneNumbers(numbersNew);
                    setDateAndTimeEdition(nextCont2);
                    System.out.println("Номер(а) телефонов успешно отредактирован(ы)");
                    System.out.println(nextCont2);
                    break;

                case 4:
                    System.out.println("Введите новый адрес: ");
                    Scanner scannerNewAddress = new Scanner(System.in);
                    nextCont2.setAddress(scannerNewAddress.nextLine());
                    setDateAndTimeEdition(nextCont2);
                    System.out.println("Адрес успешно отредактирован");
                    System.out.println(nextCont2);
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Данное действие недоступно, попробуйте еще раз");
                    chooseForEdit(nextCont2);
            }

        } else {
            System.out.println("Вы ввели не число, попробуйте еще раз");
            chooseForEdit(nextCont2);
        }
    }

    private static void setDateAndTimeEdition(Contact nextCont2) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        nextCont2.setChangeOrMakeContactDate(dateFormat.format(cal.getTime()));
    }

    private static void sortContacts(ArrayList<Contact> allContacts) {
        Scanner howToSortScanner = new Scanner(System.in);
        System.out.println("Как будем сортировать? " +
                "Сортироать по имени нажми 1, сортировать по дате рождения нажми 2, " +
                "не сортировать и вернутся в главное меню - введи любой другой символ");
        if (howToSortScanner.hasNextInt()) {
            int chooseSort = howToSortScanner.nextInt();
            if (chooseSort == 1) {
                allContacts.sort(Comparator.comparing(Contact::getName));
            } else if (chooseSort == 2) {
                allContacts.sort(Comparator.comparing(Contact::getDateOfBirth));
            }
        }
    }

    private static void deleteContact(ArrayList<Contact> allContacts) {
        Scanner deleteContactScanner = new Scanner(System.in);
        System.out.println("Доступные контакты для удаления:");
        Iterator<Contact> contactIterator = allContacts.iterator();
        while (contactIterator.hasNext()) {
            Contact nextCont = contactIterator.next();
            System.out.println(nextCont.getName());
        }
        System.out.println("Введите имя контакта для удаления: ");
        String nameContactForDelete = deleteContactScanner.nextLine();
        Iterator<Contact> contactIterator1 = allContacts.iterator();
        while (contactIterator1.hasNext()) {
            Contact nextCont = contactIterator1.next();
            if (nextCont.getName().equals(nameContactForDelete)) {
                contactIterator1.remove();
            }
        }
        System.out.println("Контакт успешно удален");
    }

    private static void addNewContact(ArrayList<Contact> allContacts) {// this method add new contact
        Contact contact = new Contact();//new contact
        ArrayList<String> numbers = new ArrayList<>();//list numbers for this contact
        Scanner scannerAddNewContact = new Scanner(System.in);
        System.out.println("Введите имя для Вашего нового контакта");
        contact.setName(scannerAddNewContact.nextLine());
        System.out.println("Введите год рождения");
        int year = scannerAddNewContact.nextInt();
        System.out.println("Введите месяц рождения");
        int month = scannerAddNewContact.nextInt();
        System.out.println("Введите день месяца рождения");
        int day = scannerAddNewContact.nextInt();
        contact.setDateOfBirth(LocalDate.of(year, month, day));
        System.out.println("Введите адрес контакта");
        Scanner scannerSetAddress = new Scanner(System.in);
        contact.setAddress(scannerSetAddress.nextLine());
        addNumber(numbers);
        contact.setPhoneNumbers(numbers);
        setDateAndTimeEdition(contact);

        allContacts.add(contact);

    }

    private static void addNumber(ArrayList<String> numbers) {// this method add all or one number for contact
        Scanner scannerAddNumbers = new Scanner(System.in);
        System.out.println("Введите номер телефона ");
        numbers.add(scannerAddNumbers.nextLine());
        System.out.println("Вы хотите добавить еще один контакт? если да - введите 1, нет - введите любую другую цифру ");
        if (scannerAddNumbers.hasNextInt()) {
            int choose = scannerAddNumbers.nextInt();
            if (choose == 1) {
                addNumber(numbers);
            }

        } else {
            System.out.println("такой вариант выбора невозможен, попробуй еще раз ввести еще один номер телефона для этого контакта ");
            addNumber(numbers);
        }
    }

}

