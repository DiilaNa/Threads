package lk.ijse.project;

public class ImplementsRunnableInterFace {
    public static void main(String[] args) {
        MyNewThread myThread = new MyNewThread();
        Thread thread = new Thread(myThread);
        thread.start();
    }

}
    class MyNewThread implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello MyNewThread");
        }
    }
