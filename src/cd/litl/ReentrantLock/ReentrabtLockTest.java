package cd.litl.ReentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrabtLockTest {

	public static void main (String [] args) {
		
		final ExecutorService exe = Executors.newFixedThreadPool(4);
		
		final Lock lock = new ReentrantLock();
		
		final Condition con = lock.newCondition();
		
		final int time = 5;
		
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Pre " + lock);
				 
				lock.tryLock();
				
				try {
					con.await(time, TimeUnit.SECONDS);
//					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					System.out.println("Post " + lock.toString());
					lock.unlock();
				}
			}
		};
		
		for (int i =0; i <4 ;i++) {
			exe.submit(run);
		}
		exe.shutdown();
	}
	
}
