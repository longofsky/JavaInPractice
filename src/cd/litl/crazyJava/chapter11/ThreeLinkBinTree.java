package cd.litl.crazyJava.chapter11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ThreeLinkBinTree<E> {

	public static class TreeNode {
		
		Object data;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		
		public TreeNode () {
			
		}
		public TreeNode (Object data) {
			this.data = data;
		}
		
		public TreeNode (Object data,TreeNode left,TreeNode right,TreeNode parent) {
			
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}
	
	private TreeNode root;
	//已默认的构造器创建 二叉树
	public ThreeLinkBinTree() {
		
		root = new TreeNode();
	}
	//以指定 根元素创建二叉树
	public ThreeLinkBinTree(E data) {
		
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
		
		if (node == null) {
			
			throw new RuntimeException(node +"节点为空，无法添加父节点");
		}
		return node.parent;
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
	private int deep (TreeNode node) {
		
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
	
	
	//实现 先序遍历
	public List<TreeNode> preIterator () {
		
		return preIterator(root ());
	}
	private List<TreeNode> preIterator (TreeNode node) {
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		//处理根节点
		list.add(node);
		//递归处理左子树
		if (node.left != null) {
			list.addAll(preIterator(node.left));	
		}
		
		//递归 处理右子树
		if (node.right != null) {
			list.addAll(preIterator(node.right));
		}
		
		
		return list;
		
	}
	
	//实现 中序遍历
	public List<TreeNode> inIterator () {
			
		return inIterator(root ());
	}
	private List<TreeNode> inIterator (TreeNode node) {
			
		List<TreeNode> list = new ArrayList<TreeNode>();
			
		
		//递归处理左子树
		if (node.left != null) {
			list.addAll(inIterator(node.left));	
		}
		//处理根节点
		list.add(node);	
		//递归 处理右子树
		if (node.right != null) {
			list.addAll(inIterator(node.right));
		}
			
			
		return list;
			
	}
	
	
	//实现 后序遍历
	public List<TreeNode> postIterator () {
				
		return postIterator(root ());
	}
	private List<TreeNode> postIterator (TreeNode node) {
				
		List<TreeNode> list = new ArrayList<TreeNode>();
				
			
		//递归处理左子树
		if (node.left != null) {
			list.addAll(postIterator(node.left));	
		}
		
		//递归 处理右子树
		if (node.right != null) {
			list.addAll(postIterator(node.right));
		}
		//处理根节点
		list.add(node);	
				
		return list;
				
	}
	
	//广度优先 遍历  借助 队列
	public List<TreeNode> breadthFirst () {
		
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		if (root != null) {
			//将根元素 加入队列
			queue.offer(root);
		}
		
		while (!queue.isEmpty()) {
			
			//将队列的队尾元素 添加到 list中
			list.add(queue.peek());
			//取出队尾元素
			TreeNode p = queue.poll();
			//如果 左子节点 不为空 加入队列
			if(p.left != null) {
				queue.offer(p.left);
			}
			//如果 右子节点 不为空 加入队列
			if(p.right != null) {
				queue.offer(p.right);
			}
		}
		
		return list;
	}
}
