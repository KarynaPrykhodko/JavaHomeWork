package com.pb.prykhodko.hw13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Consumer implements Runnable {
    public Consumer(List<Integer> integers) {
        this.integers = integers;
    }

    List<Integer> integers;


    @Override
    public synchronized void run() {
        for (int i = 0; i < 100; i++) {
            while (integers.isEmpty()) {
                System.out.println("Потребитель пытается забрать, но буфер пустой, ждем производителя");
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            int number = integers.get(0);
            System.out.println("Потребитель забрал " + number);
            integers.remove(0);
            System.out.println("Количество элементов в буфере, после того как потребитель забрал: " + integers.size());
            System.out.println(integers);
            notify();
        }

    }
}
