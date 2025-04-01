package lk.ijse.project;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Calculation cal = new Calculation();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                cal.Increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                cal.Increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Value of t1: " + cal.num);
    }
}
class Calculation{
    int num;
    public synchronized void Increment () {  /*solve the error of sync */
       num++;
    }

}
