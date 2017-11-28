package cd.litl.artOfConcurrency.chapter6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Double> {

    private static int THRESHOLD;// ��ֵ

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
        // ��������㹻С�ͼ�������
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // ������������ֵ���ͷ��ѳ��������������
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle,THRESHOLD);
            CountTask rightTask = new CountTask(middle + 1, end,THRESHOLD);
            // ִ��������
            leftTask.fork();
            rightTask.fork();
            // �ȴ�������ִ���꣬���õ�����
            Double leftResult = leftTask.join();
            Double rightResult = rightTask.join();
            // �ϲ�������
            sum = leftResult + rightResult;
        }
        return sum;
    }
    
    public static Double computeByForkJoin (int i, int j,int z) {
        
        Double y = (double) 0;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // ����һ���������񣬸������1+2+3+4
        CountTask task = new CountTask(i, j, z);
        // ִ��һ������
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
