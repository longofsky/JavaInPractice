package cd.litl.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest1 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final CountDownLatch begin = new CountDownLatch(1);
		
		final CountDownLatch end = new CountDownLatch(10);
		
		final ExecutorService exe = Executors.newFixedThreadPool(10);
		
		for (int i =0; i< 10 ;i++) {
			final int num = i+1;
			Runnable run = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						begin.await();
						Thread.sleep((long) (Math.random()*10000));
						
						System.out.println("第"+num+"名选手到达终点");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						end.countDown();
					}	
				}
			};
			
			exe.submit(run);
		}
		
		begin.countDown();
		System.out.println("比赛开始");
		
		end.await();
		System.out.println("比赛结束");
		
		
		exe.shutdown();
	}
}
