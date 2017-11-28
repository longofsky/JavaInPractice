package cd.litl.designmode.observer;

public interface Subject {

	public void add (Observer Observer);
	
	public void del (Observer Observer);
	
	public void notifyObservers ();
	
	public void operation();
}
