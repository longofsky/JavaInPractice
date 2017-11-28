package cd.litl.crazyJava.chapter7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Wolf implements Serializable {
	private String name;
	public Wolf (String name) {
		System.out.println("调用带参构造器");
		this.name = name;
	}
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.getClass() == obj.getClass()) {
			Wolf target = (Wolf) obj;
			return this.name.equals(target.name);
		}
		return false;
	}
	
	public int hashCode () {
		return name.hashCode();
	}
}
public class SerializableTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Wolf w = new Wolf("灰太狼");
		System.out.println("Wolf 对象创建完毕");
		Wolf w2 = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try{
			oos = new ObjectOutputStream(new FileOutputStream("a.bin"));
			ois = new ObjectInputStream(new FileInputStream("a.bin"));
			
			oos.writeObject(w);
			oos.flush();
			w2 = (Wolf) ois.readObject();
			
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
