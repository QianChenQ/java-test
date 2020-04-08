package chenqian.site.commontest.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
public class SemaphoreTest {

    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    doSomeThing();
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"刚刚执行完");
            });
        }
        executorService.shutdown();
    }


    public static void doSomeThing() throws InterruptedException {
        semaphore.acquire();
        System.out.println("懂 some thing");
        Thread.sleep(4000);
        semaphore.release();
    }


}
