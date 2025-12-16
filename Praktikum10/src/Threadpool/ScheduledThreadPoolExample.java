package Threadpool;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

    public static void main(String[] args) {
        int corePoolSize = 2;

        ScheduledExecutorService threadPool =
                Executors.newScheduledThreadPool(corePoolSize);

        Runnable task1 = new Command("task-1");
        Runnable task2 = new Command("task-2");

        System.out.println("Waktu mulai : " + Calendar.getInstance().get(Calendar.SECOND));

        threadPool.scheduleWithFixedDelay(task1, 2, 5, TimeUnit.SECONDS);
        threadPool.scheduleWithFixedDelay(task2, 5, 5, TimeUnit.SECONDS);

        try {
            Thread.sleep(30000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        threadPool.shutdown();
    }
}
