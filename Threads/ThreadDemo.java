package Threads;

// class Hi implements Runnable {
//     public void run() {
//         for (int i = 0; i < 5; i++) {
//             System.out.println("Hi");
//             try {
//                 Thread.sleep(500);
//             } catch (Exception e) {
//             }
//         }
//     }
// }

// class Hello implements Runnable {
//     public void run() {
//         for (int i = 0; i < 5; i++) {
//             System.out.println("Hello");
//             try {
//                 Thread.sleep(500);
//             } catch (Exception e) {
//             }
//         }
//     }
// }

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread Started\n");

        // Runnable obj1 =

        Runnable obj2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
            }
        };

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(obj2, "Hello Thread");

        t1.setName("Hi Thread");
        // t2.setName("Hello Thread");

        t1.start();
        try {
            Thread.sleep(2);
        } catch (Exception e) {
        }
        t2.start();

        System.out.println(t1.getName() + " is alive: " + t1.isAlive());
        System.out.println(t2.getName() + " is alive: " + t2.isAlive());

        t1.join();
        t2.join();

        System.out.println("t1 is alive: " + t1.isAlive());
        System.out.println("t2 is alive: " + t2.isAlive());

        System.out.println("Main Thread Ended");

    }

}
