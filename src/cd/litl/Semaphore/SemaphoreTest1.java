package cd.litl.Semaphore;

import java.awt.image.SampleModel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService exe = Executors.newCachedThreadPool();
		
		final Semaphore semaphore = new Semaphore(5);
		
		for (int i = 0;i < 20;i++) {
			final int no = i;
			
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						semaphore.acquire();
						
						System.out.println("Accessing +" +no);
						Thread.sleep(10000);
						semaphore.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			
			exe.submit(runnable);
		}
		
		exe.shutdown();
	}

}
