package cd.litl.chapter1;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class CompletionServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService exec = Executors.newFixedThreadPool(10);
		
		CompletionService <String> serv = new ExecutorCompletionService<String>(exec);
		
		for (int index = 0; index < 5; index++) {
			final int n = index;
			
			Callable<String> downImg = new Callable<String>() {			
				@Override
				public String call() throws Exception {
					// TODO Auto-generated method stub
					Thread.sleep((long)Math.random()*1000);
					return "downLoad Imge" + n;
				}
			};
			
			serv.submit(downImg);
		}
		
		try {
			Thread.sleep(1000*2);
			
			for (int index = 0; index < 5; index++) {
				Future <String> task = serv.take();
				try {
					String img = task.get();
					
					System.out.println(img);
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("End");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			exec.shutdown();
		}	
	}

}
