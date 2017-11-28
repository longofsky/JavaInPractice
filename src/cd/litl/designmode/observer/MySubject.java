package cd.litl.designmode.observer;

public class MySubject extends AbstracteSubject{

	@Override
	public void operation() {
		// TODO Auto-generated method stub
		System.out.println("update self!");
		
		notifyObservers();
		
	}
	
}
