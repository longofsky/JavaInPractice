package cd.litl.crazyJava.chapter11;

public class SortedBinTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SortedBinTree <Integer> sortedBinTree = new SortedBinTree<Integer>();
		
		sortedBinTree.add(5);
		sortedBinTree.add(20);
		sortedBinTree.add(10);
		sortedBinTree.add(3);
		sortedBinTree.add(8);
		sortedBinTree.add(15);
		sortedBinTree.add(30);
		
		System.out.println(sortedBinTree.breadthFirst());
		System.out.println(sortedBinTree.preIterator());
		System.out.println(sortedBinTree.inIterator());
		System.out.println(sortedBinTree.postIterator());
		
		
		sortedBinTree.remove(20);
//		System.out.println(sortedBinTree.breadthFirst());
		System.out.println(sortedBinTree.inIterator());
	}

}
