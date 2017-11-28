package cd.litl.designmode.Composite;

public class Tree {
	
	private TreeNode root = null;
	
	public Tree (String name) {
		root = new TreeNode(name);
	}
	
	public static void main (String [] args) {
		Tree tree = new Tree("A");
		
		TreeNode treeNodeb = new TreeNode("B");
		TreeNode treeNodec = new TreeNode("C");
		
		treeNodeb.add(treeNodec);
		
		tree.root.add(treeNodeb);
		
		System.out.println("build the tree finished");
	}

}
