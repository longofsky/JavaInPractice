package cd.litl.crazyJava.chapter7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

class Singleton implements Serializable {
	
	private static Singleton instance;
	private String name ;
	
	private Singleton (String name) {
		this.name = name;
	}
	
	public static Singleton getinstance (String name) {
		if (instance == null) {
			instance = new Singleton(name);
		}
		return instance;
	}
	
	//提供readResolve()方法  确保 返回的是同一个对象
	
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
}
public class SingletonTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Singleton w = Singleton.getinstance("灰太狼");
		System.out.println("Wolf 对象创建完毕");
		Singleton w2 = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try{
			oos = new ObjectOutputStream(new FileOutputStream("a.bin"));
			ois = new ObjectInputStream(new FileInputStream("a.bin"));
			
			oos.writeObject(w);
			oos.flush();
			w2 = (Singleton) ois.readObject();
			
			System.out.println(w.equals(w2));
			System.out.println(w == w2);
		}finally {
			if (oos != null) {
				oos.close();
			}
			if (ois != null) {
				ois.close();
			}
		}
	}

}
