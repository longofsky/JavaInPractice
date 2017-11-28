package cd.litl.crazyJava.chapter4;

class Node {
	Node next;
	String name;
	public Node (String name) {
		this.name = name;
	}
}
public class NodeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1 = new Node("node1");
		Node node2 = new Node("node2");
		Node node3 = new Node("node3");
		
		node1.next = node2;
		node2 = null;
		node3 = node2;
	}

}
