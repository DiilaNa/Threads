package lk.ijse.project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 1; i <= 10; i++) {
            Runnable runnable = new MyRunnable("Worker Thread" + i);
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }
}