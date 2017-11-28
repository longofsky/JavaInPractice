package cd.litl.chapter1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MyThreadLocal<T> {

	private Map <Thread,T> map = Collections.synchronizedMap(new HashMap<Thread, T>());
	
	public T get () {
		
		Thread thread =Thread.currentThread();
		
		T tmp = map.get(thread);
		
		if (tmp ==null && map.containsKey(thread)) {
			tmp = initialValue();
		}
		return tmp;
		
	}
	
	public void set (T value) {
		map.put(Thread.currentThread(), value);
	}
	
	public void remove() {
		map.remove(Thread.currentThread());
	}
	
	 public T initialValue(){  
	        return null ;  
	 } 
}
