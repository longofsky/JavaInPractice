package cd.litl.countDownLatch.demo2;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable{

	private final CountDownLatch countDownLatch;
	
	public VideoConference (int num) {
		countDownLatch = new CountDownLatch(num);
	}
	
	public synchronized void Arrive (String name) {
		System.out.println(name + "到达会场");
		
		countDownLatch.countDown();
		System.out.println("VideoConference:Waiting for "+countDownLatch.getCount());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("初始化参会人数" + countDownLatch.getCount());
		
		try {
			countDownLatch.await();
			
			System.out.printf("VideoConference: All the participants have come\n");  
            System.out.printf("VideoConference: Let's start...\n");  
			System.out.println("");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
