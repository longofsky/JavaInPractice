package cd.litl.crazyJava.chapter7;

public class InstanceTest {

	private String name;
	private InstanceTest instanceTest;
	
	public InstanceTest () {
		
	}
	public InstanceTest (String name) {
		instanceTest  = new InstanceTest();
		instanceTest.name = name;
	}
	
	//��дtoString����
	public String toString () {
		return "InstanceTest[instanceTest="+instanceTest+"]";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InstanceTest in = new InstanceTest();
		InstanceTest in2 = new InstanceTest("test");
		
		//�����������໥����
//		in.instanceTest = in2;
//		in2.instanceTest = in;
		
		System.out.println(in);
		System.out.println(in2); 
		
	}

}
