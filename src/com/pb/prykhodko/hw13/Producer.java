package com.pb.prykhodko.hw13;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    final List<Integer> integers;
    Random random = new Random();
    Consumer consumer;

    public Producer(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 15; i++) {
            while (integers.size() >= 5) {
                System.out.println("Производитель пытается положить, но буфер полный, ждет потребителя");
                try {
                    synchronized (integers){

                        integers.wait(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int number = random.nextInt(100);
            System.out.println("Производитель положил в буфер " + number);
            integers.add(number);
            System.out.println("Количество объектов в буфере: " + integers.size());
            System.out.println(integers);
            notifyAll();
        }

    }
}
