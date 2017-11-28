package cd.litl.Exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;
//”–Œ Ã‚
public class ExchangerTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Exchanger<List<Integer>> exchanger = new Exchanger<>();  
		
		Thread threadProduct = new Thread(new Consumer(exchanger));
		Thread threadConsumer = new Thread(new Consumer(exchanger));
		threadConsumer.start();
		threadProduct.start();
		
	}

}

class Product implements Runnable {
	List<Integer> list = new ArrayList<Integer>();
	Exchanger<List<Integer>> exchanger ;
	
	public Product (Exchanger<List<Integer>> exchanger) {
		super();
		this.exchanger = exchanger;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			list.clear();  
            list.add(random.nextInt(10000));  
            list.add(random.nextInt(10000));  
            list.add(random.nextInt(10000));  
            list.add(random.nextInt(10000));  
            list.add(random.nextInt(10000)); 
		}
		
		try {
			list = exchanger.exchange(list);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class Consumer implements Runnable {

	List<Integer> list = new ArrayList<>();  
    Exchanger<List<Integer>> exchanger = null;  
    
    public Consumer (Exchanger<List<Integer>> exchanger) {
    	super();
    	this.exchanger = exchanger;
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		for (int i = 0; i < 10 ;i++) {
			try {
				list = exchanger.exchange(list);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.print(list.toString());  
//            System.out.print(list.get(1)+", ");  
//            System.out.print(list.get(2)+", ");  
//            System.out.print(list.get(3)+", ");  
//            System.out.println(list.get(4)+", "); 
//		}
	}
	
}