package cd.litl.designmode.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Prototype implements Cloneable,Serializable {

	private static final long serialVersionUID  = 1L;
	private String string;
	private SerializableObject obj;
	
	
	
	//Ǳ����
	
	public Object clone() throws CloneNotSupportedException{
		
		Prototype proto = (Prototype)super.clone();
		return proto;
	}
	
	//���
	public Object deepClone () throws IOException,ClassNotFoundException{
		
		//д�뵱ǰ����Ķ�������
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(this);
		//�������������������¶���
		
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		return objectInputStream.readObject();
	}
	
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public SerializableObject getObj() {
		return obj;
	}
	public void setObj(SerializableObject obj) {
		this.obj = obj;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
