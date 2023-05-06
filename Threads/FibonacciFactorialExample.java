/*This Java code demonstrates the use of threads to print Fibonacci numbers and calculate the factorial of a number simultaneously. 

The main() method starts two threads using lambda expressions. The first thread prints the Fibonacci numbers by using a loop that calculates each number as the sum of the previous two numbers. The count variable is used to keep track of the number of Fibonacci numbers printed and to insert a two-second delay after printing every ten numbers.

The second thread calculates the factorial of the number 5 using a loop and prints the result. 

Both threads run concurrently, with the Fibonacci thread printing numbers while the factorial thread calculates the result. This code demonstrates the use of lambda expressions to create threads and the concurrent execution of multiple threads. */
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