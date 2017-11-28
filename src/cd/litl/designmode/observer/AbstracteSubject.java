package cd.litl.designmode.observer;

import java.util.Enumeration;
import java.util.Vector;

public abstract class AbstracteSubject implements Subject {

	private Vector<Observer> observers = new Vector<Observer>();
	@Override
	public void add(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void del(Observer observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub

		Enumeration<Observer> enumeration = observers.elements();
		
		while (enumeration.hasMoreElements()) {
			enumeration.nextElement().update();
		}
	}

//	@Override
//	public void operation() {
//		// TODO Auto-generated method stub
//
//	}

}
