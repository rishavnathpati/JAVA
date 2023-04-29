package Threads;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // First thread using anonymous function
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Hello World");
                // sleep for .2s
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Second thread using anonymous function
        Thread thread2 = new Thread(() -> {
            Random rand = new Random();
            for (int i = 0; i < 100; i++) {
                int num = rand.nextInt(141) + 110;
                System.out.println(num);
                // sleep for .2s
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
