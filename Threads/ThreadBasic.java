// package Threads;
// import java.util.Random;
// public class Threading {
//     public static void main(String[] args) {

//         // First task/thread using anonymous function
//         new Thread(() -> {
//             for (int i = 0; i < 100; i++) {
//                 System.out.println("Hello World");
//                 // sleep for .2s
//                 try {
//                     Thread.sleep(200);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//             }
//         }).start();

//         // Second task/thread using anonymous function
//         new Thread(() -> {
//             Random rand = new Random();
//             for (int i = 0; i < 100; i++) {
//                 int num = rand.nextInt(141) + 110;
//                 System.out.println(num);
//                 // sleep for .3s
//                 try {
//                     Thread.sleep(300);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//             }
//         }).start();
//     }
// }

package Threads;

public class ThreadBasic {

    public static void main(String[] args) throws Exception {

        Thread thi = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hi");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thello = new Thread(new Hello());

        // hi.run();
        // hello.run();

        thi.start();
        thi.join();

        thello.start();
        thello.join();

        System.out.println("Done!!!");
    }

}

class Hello implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}