package lk.ijse.project;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1");
            }
        /*    try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 2");
            }
        /*    try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        });
        t1.start();
        System.out.println(t1.isAlive());

       /* try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
*/
        t2.start();
        System.out.println(t2.isAlive());

        try {
            t1.join();
            System.out.println(t1.isAlive());
            t2.join();
            System.out.println(t2.isAlive());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("BYE");
        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
    }
}