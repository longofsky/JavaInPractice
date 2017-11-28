package cd.litl.chapter1;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
		final Runnable deeper = new Runnable() {
			
			int count = 0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(new Date()+"deep" + (++count));
			}
		};
		//1秒后运行，每隔两秒执行一次
		final ScheduledFuture deeperHandle = executorService.scheduleAtFixedRate(deeper, 1, 2, TimeUnit.SECONDS);
		//2秒后运行，并在上次执行的基础上 5妙后运行一次
		final ScheduledFuture deeperHandle2 = executorService.scheduleWithFixedDelay(deeper, 2, 5, TimeUnit.SECONDS);
		
		//30秒后结束结束程序运行，并且关闭executorService
		executorService.schedule(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				deeperHandle.cancel(true);
				deeperHandle2.cancel(true);
				executorService.shutdown();
			}
		}, 30, TimeUnit.SECONDS);
	}

}
