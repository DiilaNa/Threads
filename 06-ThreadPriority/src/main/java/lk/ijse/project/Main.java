package lk.ijse.project;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.setPriority(Thread.MAX_PRIORITY);/*10*/
        t2.setPriority(Thread.MIN_PRIORITY);/*1*/
        /*t1.setPriority(Thread.NORM_PRIORITY) 5 */;
        t1.start();
        t2.start();

        System.out.println(t1.getPriority()); /*Check priority*/
        System.out.println(Thread.currentThread().getPriority()); /*get the current thread and its priority*/
        t1.setName("Thread one");
        t2.setName("Thread two");
        System.out.println(t1.getName());
        System.out.println(t2.getName());
    }
}