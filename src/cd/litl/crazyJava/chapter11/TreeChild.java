package cd.litl.crazyJava.chapter11;

import java.util.ArrayList;
import java.util.List;

//子节点连 表示法
public class TreeChild<E> {

	//子节点连的节点
	private static class SonNode {
		
		//当前节点的位置
		private int pos;
		
		//记录下一个节点
		private SonNode next;
		public SonNode (int pos,SonNode next) {
			
			this.pos = pos;
			this.next = next;
		}
		
	}
	
	//树的节点
	public static class Node<T> {
		
		T data;
		//记录 第一个 子节点
		SonNode first;
		public Node (T data) {
			this.data = data;
			this.first = null;
		}
		
		public String toString () {
			
			if (first != null) {
				
				return "TreeChild$Node[data="+data+",first ="+first.pos+"]";
			} else {
				
				return "TreeChild$Node[data="+data+",first ="+-1+"]";
			}
		}
		
	}
	
	//默认 初始化 树的大小
	private final int DEFAULT_TREE_SIZE= 100;
	
	//树的大小
	private int treeSize = 0;
	
	//Node 数组
	private Node<E>[] nodes;
	
	//记录节点数
	private int nodeNums;
	//以指定根节点 创建树
	public TreeChild (E data) {
		
		this.treeSize = DEFAULT_TREE_SIZE;
		nodes = new Node[treeSize];
		
		nodes[0] = new Node<E>(data);
		nodeNums ++;
	}
	//以指定 根节点  treeSie 创建 树
	public TreeChild (E data,int treeSize) {
		
		this.treeSize = treeSize;
		nodes = new Node[treeSize];
		
		nodes[0] = new Node<E>(data);
		nodeNums ++;
	}
	
	//以指定节点  添加 子节点
	public void addNode(E data,Node parent) {
		
		//遍历 节点 数组 找到数组中第一个为null的元素 保存 新节点
		for(int i = 0; i< treeSize; i++) {
			
			if (nodes[i] == null) {
				
				nodes[i] = new Node<E>(data);
				
				if (parent.first == null) {
					
					parent.first = new SonNode(i, null);
				} else {
					
					SonNode next = parent.first.next;
					
					while (next != null) {
						
						next = next.next;
					}
					next = new SonNode(i, null);
				}
				
				nodeNums ++;
				return;
			}
		}
		
		throw new RuntimeException("该树已满 无法添加 子节点");
	}
	
	//判断树是否为空
	public boolean empty() {
		
		//根节点 是否为空
		return nodes[0] == null;
	}
	
	//返回 根节点
	public Node<E> root() {
		
		return nodes[0];
	}
	
	//返回指定 节点 （非叶子节点）的所有 子节点
	public List<Node<E>> children (Node parent) {
		
		List<Node<E>> list = new ArrayList<Node<E>>();
		
		SonNode next = parent.first;
		
		while (next != null) {
			list.add(nodes[next.pos]);
			
			next = next.next;
		}
		
		return list;
	}
	
	//返回 指定节点（非叶子节点） 第index处的子节点
	public Node<E> child (Node parent,int index) {
		
		List<Node<E>> list = new ArrayList<Node<E>>();
		
		SonNode next = parent.first;
		
		for (int i = 0; next != null;i++) {
			
			if (index == i) {
				
				return nodes[next.pos];
			}
			next = next.next;
		}
		
		return null;
	}
	
	//返回该树的深度
	public int deep () {
		
		return deep(root());
	}
	//这是个递归方法： 每棵子树的深度 为其所有子树的深度 +1
	private int deep (Node node) {
		
		if (node.first == null) {
			return 1;
		} else {
			
			//记录其所有子树的最大深度
			int max = 0;
			SonNode next = node.first;
			//沿着 孩子链 不断搜索 下一个孩子节点
			while (next != null) {
				
				//获取 以其子节点 为根 的子树的深度
				int tmp = deep(nodes[next.pos]);
				
				if (max < tmp) {
					max = tmp;
				}
				
				next = next.next;
			}
			
			//最后，返回 其所有子树的最大深度 +1
			return max +1;
		}
	}
	
	//返回 包含 指定值得节点
	public int pos(Node node) {
		
		for (int i = 0; i < treeSize; i++) {
			
			if (nodes[i] == node) {
				return i;
			}
		}
		return -1;
	}
	
}
