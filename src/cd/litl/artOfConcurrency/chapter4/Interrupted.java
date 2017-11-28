package cd.litl.artOfConcurrency.chapter4;

import java.util.concurrent.TimeUnit;

public class Interrupted {

	public static void main(String[] args) throws Exception {
		// sleepThread��ͣ�ĳ���˯��
		Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
		sleepThread.setDaemon(true);
		// busyThread��ͣ������
		Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
		busyThread.setDaemon(true);
		sleepThread.start();
		busyThread.start();
		// ����5�룬��sleepThread��busyThread�������
		TimeUnit.SECONDS.sleep(5);
		sleepThread.interrupt();
 		busyThread.interrupt();
		System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
		System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
		// ��ֹsleepThread��busyThread�����˳�
		SleepUtils.second(2);
	}
	static class SleepRunner implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}
	}
	static class BusyRunner implements Runnable {
		@Override
		public void run() {
			while (true) {
			}
		}
	}
}
