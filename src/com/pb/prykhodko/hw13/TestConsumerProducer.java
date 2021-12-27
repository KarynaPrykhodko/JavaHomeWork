package com.pb.prykhodko.hw13;

import java.util.ArrayList;
import java.util.List;

public class TestConsumerProducer {

    public static void main(String[] args) {
        List <Integer> integers = new ArrayList<>();
        
        
        Thread tread1 = new Thread(new Consumer(integers));
        Thread tread2 = new Thread(new Producer(integers));

        tread1.start();
        tread2.start();

    }
}
