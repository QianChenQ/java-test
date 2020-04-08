package chenqian.site.commontest.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
public class ForkJoinTest extends RecursiveTask<Integer> {

    private List<Integer> list;

    public ForkJoinTest(List<Integer> list) {
        this.list = list;
    }


    @Override
    protected Integer compute() {
        Integer sum = 0;
        if (list.size() == 1) {
            sum += list.get(0);
            System.out.println(Thread.currentThread().getName() + list.get(0));
        } else {
            int size = list.size();
            int i = size / 2;
            ForkJoinTest one = new ForkJoinTest(list.subList(0, i));
            ForkJoinTest two = new ForkJoinTest(list.subList(i, size));

            one.fork();
            two.fork();
            sum = one.join() + two.join();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        ForkJoinTest forkJoinTest = new ForkJoinTest(list);
        forkJoinPool.submit(forkJoinTest);
        //System.out.println(forkJoinTest.get());
        System.out.println(forkJoinTest.invoke());
        System.out.println("---------------");
    }
}
