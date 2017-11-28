package cd.litl.artOfConcurrency.chapter4;

public class Deamon {

	public static void main(String[] args) {
		
		Thread thread  = new Thread(new DaemonRunner(),"DaemonRunner");
		
		thread.setDaemon(true);
		thread.start();
	}
	
	static class DaemonRunner implements Runnable {
		
		public void run () {
			try {
				SleepUtils.second(10);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("DaemonRunner finally run");
			}
			
		}
	}
}
