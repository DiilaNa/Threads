package lk.ijse.project;

public class Main {
    public static void main(String[] args) {
        Runnable a = new A();
        Thread t1 = new Thread(a);
        t1.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Runnable b = new B();
        Thread t2 = new Thread(b);
        t2.start();
    }
}
    class A implements Runnable {


        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    class B implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }