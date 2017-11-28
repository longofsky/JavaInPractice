package cd.litl.crazyJava.chapter11;

import java.util.ArrayList;
import java.util.List;

//父节点 表示法
public class TreeParent<E> {

	//提供一个内部类，内部类的实例作为树的节点
	public static class Node <T> {
		
		//数据
		T data;
		//记录父节点的位置
		int parent;
		
		public Node () {
			
		}
		public Node (T data) {
			this.data = data;
		}
		public Node (T data,int parent) {
			this.data = data;
			this.parent = parent;
		}
		
		public String toString () {
			
			return "TreeParent$Node[data="+data+",parent="+parent+"]";
		}
	}
	
	//初始化树的底层数组的大小
	private final int DEFAULT_TREE_SIZE = 100;
	
	//初始化树的大小
	private int treeSize;
	
	//使用一个Node[]数组 来记录树的所有节点
	private Node<E>[] nodes;
	
	//记录节点数
	private int nodeNums;
	
	//以指定根节点创建树
	public TreeParent(E data) {
		
		treeSize = DEFAULT_TREE_SIZE;
		nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data,-1);
		nodeNums ++;
	}
	
	//以指定根节点   指定 treeSize  创建 树
	public TreeParent(E data,int initTreeSize) {
		
		treeSize = initTreeSize;
		nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data,-1);
		nodeNums ++;
	}
	
	//为指定节点 添加 子节点
	public void addNode (E data,Node parent) {

		for (int i = 0; i < treeSize;i++) {
			//找到数组中 第一个为 null的元素，该元素保存 新节点
			if (nodes[i] == null) {
				//创建新节点 并用指定 的数组元素 保存
				nodes[i] = new Node<E>(data,pos(parent));
				nodeNums ++;
				return;
			}
		}
		
		throw new RuntimeException("该树已满，无法添加新节点");//疑问 ，，，扩充 该树的 底层数组？？？
	}
	
	//判断 树是否为空
	public boolean empty () {
		
		//根节点 是否为空
		return nodes[0] == null;
	}
	
	//返回根节点
	public Node<E> root () {
		return nodes[0];
	}
	
	//返回指定节点（非父节点） 的父节点
	public Node<E> parent (Node node) {
		
		//每一个节点的 parent 记录了 它父节点的位置
		return nodes[node.parent];
	}
	
	//返回指点节点（非 叶子结点） 的所有子节点
	public List<Node<E>> children (Node parent) {
		
		List<Node<E>> list = new ArrayList<Node<E>>();
		for (int i = 0; i < treeSize; i++) {
			if (nodes[i] != null && nodes[i].parent == pos(parent)) {
				
				list.add(nodes[i]);
			}
		}
		return list;
	}
	
	//返回 树的深度
	public int deep () {
		
		//用于记录节点的最大深度
		int max = 0;
		for (int i = 0; i< treeSize && nodes[i] != null;i++) {
			
			//初始化本节点的 深度
			int def = 1;
			
			int parent = nodes[i].parent;
			while (parent != -1 && nodes[parent] != null) {
				
				//向上继续搜索 父节点
				parent = nodes[parent].parent;
				def++;	
			}
			max = def > max ? def:max;
		} 
		
		return max;
	}
	
	//返回 包含 指定值得节点
	public int pos(Node node) {
		
		for (int i = 0; i < treeSize;i++) {
			
			if (nodes[i] == node) {
				return i;
			}
		}
		return -1;
	}
}
