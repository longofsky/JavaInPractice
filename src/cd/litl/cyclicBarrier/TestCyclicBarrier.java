package cd.litl.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

	public static class WorkerThread implements Runnable {

		CyclicBarrier barrier;
		
		public WorkerThread (CyclicBarrier barrier) {
			this.barrier = barrier;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			try {
				System.out.println("Worker's waiting");
				//线程在这里等待，直到所有线程都到达barrier。
				barrier.await();
				
				System.out.println("Worker's work");
			} catch (InterruptedException | BrokenBarrierException e) {
				System.out.println("ID:"+Thread.currentThread().getId()+" Working");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CyclicBarrier barrier =new CyclicBarrier(5, new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("进入CyclicBarrier");
				// TODO Auto-generated method stub
				
			}
		});
		
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(new WorkerThread(barrier));
			
			thread.start();
		}
		
		
		
	}

}
