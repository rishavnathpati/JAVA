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

public class InterThread {
    public static void main(String[] args) {

        Q q = new Q();
        new Producer(q);
        new Consumer(q);

    }
}