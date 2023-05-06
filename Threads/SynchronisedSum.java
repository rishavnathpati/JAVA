package Threads;

import java.util.Random;

public class SynchronisedSum {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        GenerateThread genThread = new GenerateThread(sumThread);

        // start the threads
        sumThread.start();
        genThread.start();

        // wait for the threads to finish
        try {
            sumThread.join();
            genThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SumThread extends Thread {
    private int sum;
    private int count;

    public SumThread() {
        sum = 0;
        count = 0;
    }

    public synchronized void add(int value) {
        sum += value;
        count++;
        if (count == 10) {
            System.out.println("Sum: " + sum);
            sum = 0;
            count = 0;
            notify(); // wake up the waiting thread
        }
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (this) {
                while (count < 10) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // display the sum
                System.out.println("Sum for iteration " + (i + 1) + ": " + sum);
            }
        }
    }
}

class GenerateThread extends Thread {
    private SumThread sumThread;

    public GenerateThread(SumThread sumThread) {
        this.sumThread = sumThread;
    }

    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                int num = rand.nextInt(101); // generate a random number from 0 to 100
                sum += num;
                System.out.println("Generated number: " + num);
            }
            sumThread.add(sum);
        }
    }
}