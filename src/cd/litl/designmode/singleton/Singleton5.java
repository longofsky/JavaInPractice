package cd.litl.designmode.singleton;


//第一次创建对象时 线程同步  相比Singleton2 提高了性能，但不保证执行顺序，可能，返回instance空内存
public class Singleton5 {

	//持有私有的静态实例，防止被引用，此处设值为null，目的 延迟加载
	private static Singleton5 instance = null;
	//构造方法私有，防止被创建
	private Singleton5 () {
		
	}
	private static synchronized Singleton5 synInit () {
		if (null == instance) {
			instance = new Singleton5();
		}
		return instance;
	}
	//获取实例方法,synchronized 和 static的位置顺序
	public  static Singleton5 getInstance () {
		if (null == instance) {
			synInit();
		}
		
		
		return instance;
	}
	
	public Object readResolve () {
		return instance;
	}
}
