package lk.ijse.project;

public class Main {
    public static void main(String[] args) {

        Thread t1   = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread One - A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread t2   = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread Two - B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t2.start();
    }
}