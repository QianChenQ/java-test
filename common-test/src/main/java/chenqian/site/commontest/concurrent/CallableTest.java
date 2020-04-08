package chenqian.site.commontest.concurrent;

import java.util.concurrent.*;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> submit = executorService.submit(task);
        System.out.println("结束");
        System.out.println(submit.get());
        executorService.shutdown();
        FutureTask<Integer> taskFutureTask = new FutureTask<>(task);
        Thread thread = new Thread(taskFutureTask);
        thread.start();
        System.out.println(taskFutureTask.get());
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(3000);
            return 1;
        }
    }
}
