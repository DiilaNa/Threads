package lk.ijse.project;

public class ExtendsThreadsClass {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();  /*Creating a thread using extending thread class*/

    }
}
    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
        }
    }
