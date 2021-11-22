package com.pb.prykhodko.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class FileNumbers {

    public static void main(String[] args) {
        createNumbersFile();
        createOddNumbersFile();
    }

    static void createNumbersFile() {
        Path path = Paths.get("C:\\Users\\Aleksandr\\IdeaProjects\\JavaHomeWork\\src\\com\\pb\\prykhodko\\hw9\\numbers.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            Random random = new Random();
            int count = 0;
            while (count < 100) {
                writer.write(random.nextInt(99) + 1 + " ");
                count++;
                if (count % 10 == 0) {
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void createOddNumbersFile() {
        Path path = Paths.get("C:\\Users\\Aleksandr\\IdeaProjects\\JavaHomeWork\\src\\com\\pb\\prykhodko\\hw9\\numbers.txt");
        Path path1 = Paths.get("C:\\Users\\Aleksandr\\IdeaProjects\\JavaHomeWork\\src\\com\\pb\\prykhodko\\hw9\\odd-numbers.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            try(BufferedWriter writer = Files.newBufferedWriter(path1)){
            String s;
            while ((s = reader.readLine()) != null) {
                String[] str = s.split(" ");
                for (String strNumb : str) {
                        if (Integer.parseInt(strNumb) % 2 == 0) {
                            writer.write(0 + " ");
                        } else {writer.write(Integer.parseInt(strNumb) + " ");}
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}