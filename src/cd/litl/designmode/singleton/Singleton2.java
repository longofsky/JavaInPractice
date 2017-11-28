package cd.litl.designmode.singleton;


//线程安全，性能低
public class Singleton2 {

	//持有私有的静态实例，防止被引用，此处设值为null，目的 延迟加载
	private static Singleton2 instance = null;
	//构造方法私有，防止被创建
	private Singleton2 () {
		
	}
	//获取实例方法,synchronized 和 static的位置顺序
	public  static synchronized Singleton2 getInstance () {
		if (null == instance) {
			instance = new Singleton2();
		}
		
		return instance;
	}
	
	public Object readResolve () {
		return instance;
	}
}
