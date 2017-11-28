package cd.litl.chapter1;

public class ThreadLocalTest implements Runnable {

	private static ThreadLocal<Integer> num = new ThreadLocal<Integer>();
	
	static final MyThreadLocal<Integer> seqNum = new MyThreadLocal<Integer>(){
		public Integer initialValue(){
			return 1;
		}
	};
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int n = 8;
		for( int i =0 ;i <n;i++) {
			int m = seqNum.get();
			seqNum.set(seqNum.get()+1);
			System.out.println(Thread.currentThread().getName()+"+++++++++"+seqNum.get());
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(num.get());
//		System.out.println(seqNum.get());
		ThreadLocalTest localTest = new ThreadLocalTest();
		
		Thread thread1 = new Thread(localTest);
		Thread thread2 = new Thread(localTest);
		Thread thread3 = new Thread(localTest);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}
