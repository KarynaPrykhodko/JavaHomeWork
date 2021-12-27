package com.pb.prykhodko.hw13;

import java.util.ArrayList;
import java.util.List;

public class TestConsumerProducer {

    public static void main(String[] args) {
        List <Integer> integers = new ArrayList<>();
        
        
        Thread tread1 = new Thread(new Consumer(integers), "Consumer1");
        Thread tread2 = new Thread(new Producer(integers), "Producer1");
        Thread tread3 = new Thread(new Consumer(integers), "Consumer2");
        Thread tread4 = new Thread(new Producer(integers), "Producer2");


        tread1.start();
        tread2.start();
        tread3.start();
        tread4.start();



    }
}
