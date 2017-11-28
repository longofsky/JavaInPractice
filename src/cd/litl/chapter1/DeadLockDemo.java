package cd.litl.chapter1;

public class DeadLockDemo {

	
	private String A = "A";
	
	private String B = "B";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DeadLockDemo deadLockDemo = new DeadLockDemo();
		
		deadLockDemo.deadLock();
	}
	
	private void deadLock () {
		
		Thread threada = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (A) {
					System.out.println("AA");
					try {
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					synchronized (B) {
						System.out.println("AB");
					}
				}
			}
		});
		
		Thread threadb = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (B){
					
					System.out.println("BB");
					synchronized (A) {
						System.out.println("BA");
					}
				}
			}
		});
		
		threada.start();
		threadb.start();
	}

}
