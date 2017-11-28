package cd.litl.volatileTest;

public class VolatileTest1 {

	public volatile int inc = 0;
	
	public void increase() {
		inc++;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final VolatileTest1 volatileTest1 = new VolatileTest1();
		
		for (int i = 0; i < 10 ;i++) {
			
			new Thread () {
				public void run() {
					for (int i = 0; i < 1000 ;i++) {
						volatileTest1.increase();
					}
					
				}
			}.start();
		}
		
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		
		System.out.println(volatileTest1.inc);
	}

}
