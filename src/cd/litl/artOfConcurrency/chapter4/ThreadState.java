package cd.litl.artOfConcurrency.chapter4;

public class ThreadState {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Thread(new TimeWaiting(),"TimeWaiting").start();
		new Thread(new Waiting(),"Waiting").start();
		new Thread(new Blocked(),"Blocked1").start();
		new Thread(new Blocked(),"Blocked2").start();
	}
	//该线程 不断地进行休眠
	static class TimeWaiting implements Runnable {
		
		public void run () {
			
			while (true) {
				SleepUtils.second(100);
			}
		}
	}
	//该线程在Waiting.calss 上等待
	static class Waiting implements Runnable {
		
		public void run () {
			
			while (true) {
				synchronized (Waiting.class) {
					
					try {
						Waiting.class.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	//该线程在Blocked.calss 上枷锁后 不会释放锁
	static class Blocked implements Runnable {
		
		public void run () {
			
				synchronized (Blocked.class) {
					while (true) {
						SleepUtils.second(100);
					}
				}
			
		}
	}
}
