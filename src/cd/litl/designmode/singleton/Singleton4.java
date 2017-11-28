package cd.litl.designmode.singleton;

//单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。
//这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心上面的问题。
//同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。这样我们暂时总结一个完美的单例模式

//缺点：如果在构造函数中抛出异常，实例将永远得不到创建，也会出错。所以说，十分完美的东西是没有的
public class Singleton4 {

	//持有私有的静态实例，防止被引用，此处设值为null，目的 延迟加载
	private static Singleton4 instance = null;
	//构造方法私有，防止被创建
	private Singleton4 () {
		
	}
	//内部静态类的方式创建对象
	private static class SingletonFactory {
		
		private static Singleton4 instance = new Singleton4();
	}
	//获取实例方法,synchronized 和 static的位置顺序
	public  static Singleton4 getInstance () {
		
		
		return SingletonFactory.instance;
	}
	
	public Object readResolve () {
		return instance;
	}
}
