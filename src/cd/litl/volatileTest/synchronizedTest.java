package cd.litl.volatileTest;

public class synchronizedTest {

	public int inc = 0;
	
	public synchronized void increase () {
		
//		synchronized (this) {
			inc++;
//		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final synchronizedTest volatileTest1 = new synchronizedTest();
		
		for (int i = 0; i < 10 ;i++) {
			
			new Thread () {
				public void run() {
					for (int j = 0; j < 1000 ;j++) {
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
