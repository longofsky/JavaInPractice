package cd.litl.artOfConcurrency.chapter4;

import java.util.concurrent.TimeUnit;

public class Shutdown {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Runner one = new Runner();
		Thread countThread = new Thread(one,"CountThread");
		
		countThread.start();
		
		TimeUnit.SECONDS.sleep(1);
//		countThread.interrupted();
		 
//		Runner two = new Runner();
//		countThread = new Thread(two,"CountThread");
//		
//		countThread.start();
//		TimeUnit.SECONDS.sleep(1);
//		
//		two.cancel();
	}

	private static class Runner implements Runnable {
		
		private long i;
		private volatile boolean on = true;
		public void run () {
			
			while (on && !Thread.currentThread().isInterrupted()) {
				i ++;
			}
			
			System.out.println("count i = " +i);
		}
		
		public void cancel () {
			on = false;
		}
	}
}
