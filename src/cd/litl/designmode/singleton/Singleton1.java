package cd.litl.designmode.singleton;


//简单单例，确定 线程不安全
public class Singleton1 {

	//持有私有的静态实例，防止被引用，此处设值为null，目的 延迟加载
	private static Singleton1 instance = null;
	//构造方法私有，防止被创建
	private Singleton1 () {
		
	}
	//获取实例方法
	public static Singleton1 getInstance () {
		if (null == instance) {
			instance = new Singleton1();
		}
		
		return instance;
	}
	
	public Object readResolve () {
		return instance;
	}
}
