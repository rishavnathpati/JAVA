
/*This Java code demonstrates thread synchronization in a multi-threaded environment. 
The Counter class has an integer count that can be incremented using the increment() method, which is synchronized to ensure that only one thread can access it at a time. 
The main() method creates two threads, t1 and t2, which both call the increment() method of the Counter class 100,000 times. Since both threads are accessing the same Counter object, synchronization is necessary to ensure that each thread accesses the increment() method one at a time. 
The t1 and t2 threads are started and joined to ensure that the main thread waits for both of them to finish before printing the final count. The count variable is printed, which should be equal to 200,000 if the synchronization is working correctly. 
This code demonstrates the use of synchronized methods to ensure thread safety in a multi-threaded environment. */

package Threads;

class Counter {
    int count;

    public synchronized void increment() {
        count++;
    }
}

public class ThreadSync {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                c.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                c.increment();
            }
        });

        t1.start();
        t2.start();
        
        t1.join();
        t2.join();

        System.out.println("\nCount: " + c.count);
    }

}
