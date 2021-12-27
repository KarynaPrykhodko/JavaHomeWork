package com.pb.prykhodko.hw13;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {
//    private final Lock consumerLock;
    final List<Integer> integers;


    public Consumer(List<Integer> integers) {
        this.integers = integers;
    }


    @Override
    public synchronized void run() {
        synchronized (integers) {
            for (int i = 0; i < 15; i++) {
                while (integers.isEmpty()) {
                    System.out.println("Потребитель пытается забрать, но буфер пустой, ждем производителя");
                    try {
                        synchronized (integers) {
                            integers.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                int number = integers.get(0);
                System.out.println(Thread.currentThread().getName() + " забрал " + number);
                integers.remove(0);
                System.out.println("Количество элементов в буфере, после того как потребитель забрал: " + integers.size());
                System.out.println(integers);
                integers.notifyAll();
            }
        }
    }
}