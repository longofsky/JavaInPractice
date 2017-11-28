package cd.litl.Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExchangerTest {

	public static void main ( String []args) {
		ExecutorService service = Executors.newCachedThreadPool();
		
		final Exchanger<String> exchanger = new Exchanger();
		
		exchangerData(service,exchanger,"a");
		exchangerData(service,exchanger,"b");
		exchangerData(service,exchanger,"c");
		exchangerData(service,exchanger,"d");
	}
	
	public static void exchangerData (ExecutorService service,final Exchanger<String> exchanger,final String str) {
		
		service.submit(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				
				try {
					System.out.println(Thread.currentThread().getName() +"is exchanger date "+ str);
					Thread.sleep(1000);
					String str2 = exchanger.exchange(str, 1, TimeUnit.SECONDS);
					System.out.println(Thread.currentThread().getName() +" is exchanger date"+ str2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}
	
}
