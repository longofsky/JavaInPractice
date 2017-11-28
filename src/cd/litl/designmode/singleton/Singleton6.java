package cd.litl.designmode.singleton;

import java.util.Vector;


//第一次创建对象时 线程同步  相比Singleton2 提高了性能，但不保证执行顺序，可能，返回instance空内存
public class Singleton6 {

	//持有私有的静态实例，防止被引用，此处设值为null，目的 延迟加载
	private static Singleton6 instance = null;
	
	private Vector properties =null;
	
	public Vector getProperties() {
		return properties;
	}
	public void setProperties(Vector properties) {
		this.properties = properties;
	}
	//构造方法私有，防止被创建
	private Singleton6 () {
		
	}
	private static synchronized Singleton6 synInit () {
		if (null == instance) {
			instance = new Singleton6();
		}
		return instance;
	}
	//获取实例方法,synchronized 和 static的位置顺序
	public  static Singleton6 getInstance () {
		if (null == instance) {
			synInit();
		}
		
		
		return instance;
	}
	
	//采用"影子实例"的办法为单例对象的属性同步更新
	public void updateProperties() {
		Singleton6 shadow = new Singleton6();
		properties = shadow.getProperties();
	}
	
	public Object readResolve () {
		return instance;
	}
}
