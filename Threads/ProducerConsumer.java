/*This Java code demonstrates the producer-consumer problem, which is a classic multi-threading synchronization problem. It uses the Q class to simulate a shared resource between the Producer and Consumer threads. 

The Producer thread continuously generates an integer value and sets it in the shared resource using the set() method of the Q class. The Consumer thread continuously reads the value from the shared resource using the get() method of the Q class.

The Q class uses a boolean flag, valueSet, to ensure that the Producer thread sets the value only when the Consumer thread has consumed the previous value. If the flag is set to true, the Producer thread waits until the Consumer thread consumes the value and sets the flag to false. Similarly, if the flag is set to false, the Consumer thread waits until the Producer thread sets the value and sets the flag to true.

Both the Producer and Consumer threads are implemented as Runnable classes and are started using separate threads in the main() method of the ProducerConsumer class.

This code demonstrates the use of synchronized methods and wait-notify mechanism for thread synchronization. */

package Threads;

class Q {
    int num;
    boolean valueSet = false;

    public synchronized void set(int num) {
        while (valueSet) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        this.num = num;
        System.out.println("Set: " + num);
        valueSet = true;
        notify();
    }

    public synchronized void get() {
        while (!valueSet) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        System.out.println("Get: " + num);
        valueSet = false;
        notify();
    }
}

class Producer implements Runnable {

    Q q;

    public Producer(Q q) {
        this.q = q;
        Thread producer = new Thread(this, "Producer");
        producer.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.set(i++);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }

    }
}

class Consumer implements Runnable {
    Q q;

    public Consumer(Q q) {
        this.q = q;
        Thread consumer = new Thread(this, "Consumer");
        consumer.start();
    }

    @Override
    public void run() {
        while (true) {
            q.get();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {

        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}