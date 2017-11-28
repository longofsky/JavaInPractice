package cd.litl.countDownLatch.demo2;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable{

	private VideoConference conference;
	
	private String name;
	
	public Participant(VideoConference conference,String name) {
		this.conference = conference;
		this.name = name;
	}
	
	public void run () {
//		long tiemLong = (long) (Math.random()*1000);
//		
//		try {
//			TimeUnit.SECONDS.sleep(tiemLong);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		conference.Arrive(name);
	}
}
