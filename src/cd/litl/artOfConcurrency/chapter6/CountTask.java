package cd.litl.artOfConcurrency.chapter6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Double> {

    private static int THRESHOLD;// 阈值

//    private Double
    private int start;

    private int end;

    public CountTask(int start, int end,int THRESHOLD) {
        this.start = start;
        this.end = end;
        this.THRESHOLD = THRESHOLD;
    }

    @Override
    protected Double compute() {
        Double sum = (double) 0;
        // 如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle,THRESHOLD);
            CountTask rightTask = new CountTask(middle + 1, end,THRESHOLD);
            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            // 等待子任务执行完，并得到其结果
            Double leftResult = leftTask.join();
            Double rightResult = rightTask.join();
            // 合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }
    
    public static Double computeByForkJoin (int i, int j,int z) {
        
        Double y = (double) 0;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 生成一个计算任务，负责计算1+2+3+4
        CountTask task = new CountTask(i, j, z);
        // 执行一个任务
        Future<Double> result = forkJoinPool.submit(task);
        try {
            y =  result.get();
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
        
        return y;
    }
    
    public static Double computeByNomal (int start, int end) {
        
        Double y = (double) 0;
        for (int i = start; i <= end; i++) {
            y += i;
        }
        
        return y;
    }

    public static void main(String[] args) {
        
        long startTime = System.currentTimeMillis();
//        System.out.println(computeByForkJoin(1,4000000,100000));
        System.out.println(computeByNomal(1,4000000));
        System.out.println("run time :" +(System.currentTimeMillis() - startTime));
    }

}
