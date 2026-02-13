package com.java.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    private final Queue<String> que;
    private final int MAX_CAPACITY ;

    public ProducerConsumer(int capacity) {
        this.que = new LinkedList<>();
        MAX_CAPACITY = capacity;
    }

    public synchronized void produce(String message) throws InterruptedException {
        while(que.size() == MAX_CAPACITY){
            wait();
        }

        que.offer(message);
        System.out.println("Message is produced");
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while(que.isEmpty()){
            wait();
        }

        String message = que.poll();
        System.out.println("Message consumed: "+ message);
        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer(5);
        Thread producerThread = new Thread(()->
        {
            for(int i=0; i<10; i++){
                try {
                    producerConsumer.produce("Id: "+ i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerThread = new Thread(()->{
           for(int i=0; i<10; i++){
               try {
                   producerConsumer.consume();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
        System.out.println("Finished:::::::::::::::::::::::::::::::");
    }
}
