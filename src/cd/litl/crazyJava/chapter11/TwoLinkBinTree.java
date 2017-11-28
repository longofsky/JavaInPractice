package cd.litl.crazyJava.chapter11;

public class TwoLinkBinTree<E> {

	public static class TreeNode {
		
		Object data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode () {
			
		}
		public TreeNode (Object data) {
			this.data = data;
		}
		
		public TreeNode (Object data,TreeNode left,TreeNode right) {
			
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	private TreeNode root;
	//已默认的构造器创建 二叉树
	public TwoLinkBinTree() {
		
		root = new TreeNode();
	}
	//以指定 根元素创建二叉树
	public TwoLinkBinTree(E data) {
		
		root = new TreeNode(data);
	}
	//为指定节点 添加子节点-需要添加子节点的父节点 数据--信子节点的数据--是否为左节点--新增节点
	public TreeNode addNode (TreeNode parent,E data,boolean isleft) {
		
		if (parent == null) {
			
			throw new RuntimeException(parent +"节点为空，无法添加子节点");
		}
		if(isleft && parent.left != null) {
			
			throw new RuntimeException(parent +"节点已有左节点，无法添加子节点");
		}
		if(!isleft && parent.right != null) {
			
			throw new RuntimeException(parent +"节点已有右节点，无法添加子节点");
		}
		
		TreeNode node = new TreeNode(data);
		if (isleft) {
			
			parent.left = node;
		} else {
			
			parent.right = node;
		}
		return node;
	}
	//判断二叉树 是否为空
	public boolean empty () {
		
		return root.data == null;
	}
	//返回根节点
	public TreeNode root () {
		
		if(empty()) {
			throw new RuntimeException("空树 无法返回 根节点");
		}
		return root;
	}
	//返回指定节点（非根节点）的父节点
	public TreeNode parent (TreeNode node) {
		
		//对于 二叉链表储存法 如果要访问指定节点的父节点 需遍历 二叉树
//		if(empty()) {
//			
//			throw new RuntimeException("空树");
//		} else {
//			
//			TreeNode left = root.left;
//			TreeNode right = root.right;
//			
//		}
		return null;
	}
	//返回指定节点（非叶子）的左子节点，当左子节点不存在是 返回null
	public TreeNode left (TreeNode parent) {
		
		if (parent == null) {
			
			throw new RuntimeException(parent +"节点为空，无法添加子节点");
		}
		return parent.left == null ? null : parent.left;
	}
	//返回指定节点（非叶子）的右子节点，当右子节点不存在是 返回null
	public TreeNode right (TreeNode parent) {
		
		if (parent == null) {
			
			throw new RuntimeException(parent +"节点为空，无法添加子节点");
		}
		return parent.right == null ? null : parent.right;
	}
	//返回 该二叉树的深度
	public int deep () {
		
		return deep(root());
	}
	//这是个递归方法： 每棵子树的深度 为其所有子树的深度 +1
	public int deep (TreeNode node) {
		
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		else {
			int leftDeep = deep(node.left);
			int rightDeep = deep(node.right);
			
			int max = leftDeep > rightDeep ? leftDeep:rightDeep;
			
			//返回其 左右 深度最大的+1
			return max+1;
		}
	}
}
