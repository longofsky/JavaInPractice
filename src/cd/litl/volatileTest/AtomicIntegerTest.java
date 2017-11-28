package cd.litl.volatileTest;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	public AtomicInteger integer = new AtomicInteger(0);
	
	public void inrease () {
		integer.getAndIncrement();
	}
	
	public static void main (String [] args) { 
		final AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
		
		for (int i = 0; i< 10; i++) {
			new Thread() {
				public void run () {
					for ( int j = 0; j < 1000; j++) {
						atomicIntegerTest.inrease();
					}
				}
			}.start();
		}
		
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		
		System.out.println(atomicIntegerTest.integer);
	}
}
