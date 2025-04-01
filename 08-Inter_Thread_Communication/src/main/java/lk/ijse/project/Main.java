package lk.ijse.project;

public class Main {
    public static void main(String[] args) {
        A  a = new A();
        new Producer(a);
        new Consumer(a);
    }
}
class Producer implements Runnable {
   A a;
   public Producer(A a) {
       this.a = a;
       Thread t = new Thread(this, "Producer");
       t.start();
   }
    @Override
    public void run() {
        int i = 0 ;
        while (true){
            a.put(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Consumer implements Runnable {
    A a;
    public Consumer(A a) {
        this.a = a;
        Thread t2 = new Thread(this, "Consumer");
        t2.start();
    }
    @Override
    public void run() {
        while (true){
            a.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                    throw new RuntimeException(e);
            }
        }
    }
}
class A {
   int num;
   boolean flag = false;

    public synchronized void put(int num) {
        while (flag) {
            try{
                wait();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        System.out.println("PUT : " + num);
        this.num = num;
        flag = false;
        notify();
    }

    public synchronized void get() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Get num: " + num);
        flag = false;
        notify();
    }
}
