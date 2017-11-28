package cd.litl.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductQueue<T> {

	private T [] items;
	
	private Lock lock = new ReentrantLock();
	
	private Condition notFull = lock.newCondition();
	
	private Condition notEmpty = lock.newCondition();
	
	private int head,tail,count;
	
	public ProductQueue (int init) {
		items = (T[]) new Object[init];
	}
	
	public ProductQueue () {
		this(10);
	}
	
	public void put (T t) {
		lock.tryLock();
		try {
			while (count == getCapacity()) {
				
				try {
					notFull.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			items[tail] = t;
			
			if (++tail == getCapacity()) {
				tail = 0;
			}
			
			++count;
			
			notEmpty.signal();
			
		}finally {
			lock.unlock();
		}
		
	}
	
	public T take () {
		lock.tryLock();

		
		try {
			
			while (count == 0) {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			T t = items[head];
			
			if (++head == getCapacity()) {
				head = 0;
			}
			--count;
			
			notFull.signal();
			
			return t;
		}finally {
			lock.unlock();
		}
	}
	
	public int getCapacity () {
		return items.length;
	}
	
	public int size () {
		lock.tryLock();
		
		try {
			return count;
		} finally {
			lock.unlock();
		}
	}
}
