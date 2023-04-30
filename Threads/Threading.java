package Threads;
import java.util.Random;
public class Threading {
    public static void main(String[] args) {

        // First task/thread using anonymous function
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Hello World");
                // sleep for .2s
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Second task/thread using anonymous function
        new Thread(() -> {
            Random rand = new Random();
            for (int i = 0; i < 100; i++) {
                int num = rand.nextInt(141) + 110;
                System.out.println(num);
                // sleep for .3s
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
