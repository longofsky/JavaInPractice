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
	//���߳� ���ϵؽ�������
	static class TimeWaiting implements Runnable {
		
		public void run () {
			
			while (true) {
				SleepUtils.second(100);
			}
		}
	}
	//���߳���Waiting.calss �ϵȴ�
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
	//���߳���Blocked.calss �ϼ����� �����ͷ���
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
