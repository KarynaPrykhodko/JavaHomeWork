package com.pb.prykhodko.hw12;

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


public class Main12 {

    public static void main(String[] args) throws JsonProcessingException {
        ArrayList<Contact12> allContacts = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer12());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer12());
        mapper.registerModule(module);

        generalMenu(allContacts, mapper);

    }

    private static void generalMenu(ArrayList<Contact12> allContacts, ObjectMapper mapper) throws JsonProcessingException {

        navigation();

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
                    addNewContact(allContacts, mapper);
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
                    saveToFile(allContacts, mapper);
                    generalMenu(allContacts, mapper);
                    break;
                case 7:
                    readFromFile(mapper);
                    break;
                case 999:
                    System.out.println("Вы прекрасный юзер, спасибо! До новых встреч! Хорошего времени суток:)");
                    System.exit(0);

                default:
                    System.out.println("Данное действие недоступно, попробуйте еще раз");
            }
        }
    }

    private static void navigation() {
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
        System.out.println();
        System.out.println("Введите Ваш выбор: ");
    }

    private static void saveToFile(ArrayList<Contact12> allContacts, ObjectMapper mapper) throws JsonProcessingException {
        String contactJson = mapper.writeValueAsString(allContacts);
        Path path = Paths.get("C:\\Users\\Aleksandr\\IdeaProjects\\JavaHomeWork\\src\\com\\pb\\prykhodko\\hw12\\jsonFile12.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(contactJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Успешно записано");
    }

    private static void readFromFile(ObjectMapper mapper) {
        Path path1 = Paths.get("C:\\Users\\Aleksandr\\IdeaProjects\\JavaHomeWork\\src\\com\\pb\\prykhodko\\hw12\\jsonFile12.txt");
        try (BufferedReader reader = Files.newBufferedReader(path1)) {
            String line;
            StringBuilder contactJson1 = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                contactJson1.append(line);
            }
            ArrayList<Contact12> allContacts = mapper.readValue(contactJson1.toString(), new TypeReference<ArrayList<Contact12>>() {
            });
            System.out.println("Контакты успешно загружены!!!!!!");
            System.out.println();
            generalMenu(allContacts, mapper);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void editContact(ArrayList<Contact12> allContacts, ObjectMapper mapper) throws JsonProcessingException {
        System.out.println("Введите имя контакта для редактирования, доступные контакты для редактирования: ");
        allContacts.forEach(x -> System.out.println(x.getName()));// Lambda DONE
        Scanner scannerForEdit = new Scanner(System.in);
        String nameForEdit = scannerForEdit.nextLine();
        for (Contact12 nextCont2 : allContacts) {
            if (!nextCont2.getName().equals(nameForEdit)) {
            } else if (nextCont2.getName().equals(nameForEdit)) {
                chooseForEdit(nextCont2, allContacts, mapper);
                break;
            } else {
                System.out.println("Вы ввели, имя контакта, которого не существует");
                System.out.println("попробуйте еще раз");
                editContact(allContacts, mapper);
            }
        }
    }

    private static void chooseForEdit(Contact12 nextCont2, ArrayList<Contact12> allContacts, ObjectMapper mapper) throws JsonProcessingException {
        editNavigation();
        Scanner scannerChooseForEdit = new Scanner(System.in);
        if (scannerChooseForEdit.hasNextInt()) {
            int choose = scannerChooseForEdit.nextInt();
            switch (choose) {
                case 1:
                    changeName(nextCont2, allContacts, mapper);
                    break;

                case 2:
                    addBirthDate(nextCont2);
                    setDateAndTimeEdition(nextCont2);
                    System.out.println("Дата рождения успешно отредактирована, для контакта: " + nextCont2.getName() + ", и теперь значится как: " + nextCont2.getDateOfBirth());
                    break;

                case 3:
                    ArrayList<String> numbersNew = new ArrayList<>();//list for new numbers for this contact
                    addNumber(numbersNew);
                    nextCont2.setPhoneNumbers(numbersNew);
                    setDateAndTimeEdition(nextCont2);
                    System.out.println("Номер(а) телефонов успешно отредактирован(ы), для контакта: " + nextCont2.getName() + ", и теперь записан(ы) как: " + nextCont2.getPhoneNumbers());
                    break;

                case 4:
                    System.out.println("Введите новый адрес: ");
                    Scanner scannerNewAddress = new Scanner(System.in);
                    nextCont2.setAddress(scannerNewAddress.nextLine());
                    setDateAndTimeEdition(nextCont2);
                    System.out.println("Адрес успешно отредактирован, для контакта: " + nextCont2.getName() + ", и теперь его значение: " + nextCont2.getAddress());
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Данное действие недоступно, попробуйте еще раз");
                    chooseForEdit(nextCont2, allContacts, mapper);
            }

        } else {
            System.out.println("Вы ввели не число, попробуйте еще раз");
            chooseForEdit(nextCont2, allContacts, mapper);
        }
    }

    private static void editNavigation() {
        System.out.println("Выберите что нужно отредактировать:");
        System.out.println("Если Вы хотите отредактировать имя нажмите 1");
        System.out.println("Если Вы хотите отредактировать дату рождения нажмите 2");
        System.out.println("Если Вы хотите отредактировать все номера телефона нажмите 3");
        System.out.println("Если Вы хотите отредактировать адрес нажмите 4");
        System.out.println("Ничего не редактировать и выйти в главное меню, нажмите 5");
        System.out.println();
        System.out.println("Введите Ваш выбор:");
    }

    private static void changeName(Contact12 nextCont2, ArrayList<Contact12> allContacts, ObjectMapper mapper) throws JsonProcessingException {
        System.out.println("Введите новое имя: ");
        Scanner scannerNewName = new Scanner(System.in);
        String newName = scannerNewName.nextLine();
        allContacts.stream().filter(contact12 -> contact12.getName().equals(newName)).forEach(contact12 -> {
            System.out.println("Контакт с таким именем уже существует, введите другое имя");
            try {
                changeName(nextCont2, allContacts, mapper);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        });
        nextCont2.setName(newName);
        setDateAndTimeEdition(nextCont2);
        System.out.println("Имя успешно отредактировано, новое имя контакта: " + nextCont2.getName());
        generalMenu(allContacts,mapper);
    }

    private static void setDateAndTimeEdition(Contact12 nextCont2) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        nextCont2.setChangeOrMakeContactDate(dateFormat.format(cal.getTime()));
    }

    private static void sortContacts(ArrayList<Contact12> allContacts) {
        Scanner howToSortScanner = new Scanner(System.in);
        System.out.println("Как будем сортировать? " +
                "Сортироать по имени нажми 1, сортировать по дате рождения нажми 2, " +
                "не сортировать и вернутся в главное меню - введи любой другой символ");
        if (howToSortScanner.hasNextInt()) {
            int chooseSort = howToSortScanner.nextInt();
            if (chooseSort == 1) allContacts.sort(Comparator.comparing(Contact12::getName));
            else if (chooseSort == 2) allContacts.sort(Comparator.comparing(Contact12::getDateOfBirth));
        }
    }

    private static void deleteContact(ArrayList<Contact12> allContacts) {
        Scanner deleteContactScanner = new Scanner(System.in);
        System.out.println("Доступные контакты для удаления:");
        allContacts.forEach(x -> System.out.println(x.getName()));
        System.out.println("Введите имя контакта для удаления: ");
        String nameContactForDelete = deleteContactScanner.nextLine();
        allContacts.removeIf(nextCont -> nextCont.getName().equals(nameContactForDelete));
        System.out.println("Контакт успешно удален");


    }

    private static void addNewContact(ArrayList<Contact12> allContacts, ObjectMapper mapper) throws JsonProcessingException {
        Contact12 contact = new Contact12();
        ArrayList<String> numbers = new ArrayList<>();
        Scanner scannerAddNewContact = new Scanner(System.in);
        System.out.println("Введите имя для Вашего нового контакта");
        String name = scannerAddNewContact.nextLine();
        contact.setName(name);
        allContacts.stream().filter(co -> co.getName().equals(contact.getName())).forEach(co -> {
            System.out.println("Exist");
            try {
                addNewContact(allContacts, mapper);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        addBirthDate(contact);
        System.out.println("Введите адрес контакта");
        Scanner scannerSetAddress = new Scanner(System.in);
        contact.setAddress(scannerSetAddress.nextLine());
        addNumber(numbers);
        contact.setPhoneNumbers(numbers);
        setDateAndTimeEdition(contact);
        allContacts.add(contact);
        generalMenu(allContacts,mapper);

    }

    private static void addBirthDate(Contact12 contact) {
        Scanner scannerForBirthDate = new Scanner(System.in);
        System.out.println("Введите год рождения");
        int year = scannerForBirthDate.nextInt();
        System.out.println("Введите месяц рождения");
        int month = scannerForBirthDate.nextInt();
        System.out.println("Введите день месяца рождения");
        int day = scannerForBirthDate.nextInt();
        contact.setDateOfBirth(LocalDate.of(year, month, day));
    }

    private static void addNumber(ArrayList<String> numbers) {
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

