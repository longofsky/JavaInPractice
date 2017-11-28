package cd.litl.designmode.Flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {

	private Vector<Connection> pool;
	
	//��������
	private String url = "jdbc:mysql://localhost:3306/ltlssm1";
	private String userName = "root";
	private String passWord = "root123456";
	private String driverClassName = "com.mysql.jdbc.Driver";
	
	
	private int poolSize = 100;
	private static ConnectionPool instance = null;
	Connection conn = null;
	
	//���췽����һЩ��ʼ������
	
	public ConnectionPool () throws ClassNotFoundException, SQLException {
		pool = new Vector<Connection>(poolSize);
		
		for (int i = 0;i < poolSize; i++) {
			
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, userName, passWord);
		}
		
	}
	//�������ӵ����ӳ�
	public synchronized void release () {
		pool.add(conn);
	}
	
	//
	public synchronized Connection getConnection () {
		if (pool.size() > 0) {
			Connection coon = pool.get(0);
			pool.remove(conn);
			
			return conn;
		} else {
			return null;
		}
	}
}
