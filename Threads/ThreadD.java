package Threads;

public class ThreadD {
    public static void main(String[] args) {
        Task1 ob1 = new Task1();
        Task2 ob2 = new Task2();
        Thread t1 = new Thread(ob1);
        Thread t2 = new Thread(ob2);
        t1.start();
        t2.start();

        // ob1.fun();
        // ob2.fun();
    }

}

class Task1 extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Hello World");
            //sleep(1000);
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
    }
}

class Task2 extends Thread {
    public void run() {
        int min = 110, max = 250;
        for (int i = 1; i <= 100; i++) {
            int x = (int) (Math.random() * (max - min + 1) + min);
            System.out.println(x);
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
    }
}