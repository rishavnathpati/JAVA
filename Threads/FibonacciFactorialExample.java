package Threads;

public class FibonacciFactorialExample {

    public static void main(String[] args) {

        new Thread(() -> {
            int a = 0;
            int b = 1;
            int count = 0;
            while (true) {
                int fib = a + b;
                System.out.println("Fibonacci number: " + fib);
                a = b;
                b = fib;
                count++;
                if (count % 10 == 0) {
                    // Wait for two seconds after printing every ten numbers
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            int n = 5;
            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            System.out.println("Factorial of " + n + ": " + fact);
        }).start();

    }
}