package Threads;

public class ThreeThreads {
    
    public static void main(String[] args) {
        // Create three tasks
        TaskA taskA = new TaskA();
        TaskB taskB = new TaskB();
        TaskC taskC = new TaskC();
        
        // Create three threads to run the tasks
        Thread threadA = new Thread(taskA);
        Thread threadB = new Thread(taskB);
        Thread threadC = new Thread(taskC);
        
        // Start the threads
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class TaskA implements Runnable {
    
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("a ");
        }
    }
}

class TaskB implements Runnable {
    
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("b ");
        }
    }
}

class TaskC implements Runnable {
    
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");
        }
    }
}
