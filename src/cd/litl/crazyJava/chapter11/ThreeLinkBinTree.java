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
	//��Ĭ�ϵĹ��������� ������
	public ThreeLinkBinTree() {
		
		root = new TreeNode();
	}
	//��ָ�� ��Ԫ�ش���������
	public ThreeLinkBinTree(E data) {
		
		root = new TreeNode(data);
	}
	//Ϊָ���ڵ� ����ӽڵ�-��Ҫ����ӽڵ�ĸ��ڵ� ����--���ӽڵ������--�Ƿ�Ϊ��ڵ�--�����ڵ�
	public TreeNode addNode (TreeNode parent,E data,boolean isleft) {
		
		if (parent == null) {
			
			throw new RuntimeException(parent +"�ڵ�Ϊ�գ��޷�����ӽڵ�");
		}
		if(isleft && parent.left != null) {
			
			throw new RuntimeException(parent +"�ڵ�������ڵ㣬�޷�����ӽڵ�");
		}
		if(!isleft && parent.right != null) {
			
			throw new RuntimeException(parent +"�ڵ������ҽڵ㣬�޷�����ӽڵ�");
		}
		
		TreeNode node = new TreeNode(data);
		if (isleft) {
			
			parent.left = node;
		} else {
			
			parent.right = node;
		}
		return node;
	}
	//�ж϶����� �Ƿ�Ϊ��
	public boolean empty () {
		
		return root.data == null;
	}
	//���ظ��ڵ�
	public TreeNode root () {
		
		if(empty()) {
			throw new RuntimeException("���� �޷����� ���ڵ�");
		}
		return root;
	}
	//����ָ���ڵ㣨�Ǹ��ڵ㣩�ĸ��ڵ�
	public TreeNode parent (TreeNode node) {
		
		if (node == null) {
			
			throw new RuntimeException(node +"�ڵ�Ϊ�գ��޷���Ӹ��ڵ�");
		}
		return node.parent;
	}
	//����ָ���ڵ㣨��Ҷ�ӣ������ӽڵ㣬�����ӽڵ㲻������ ����null
	public TreeNode left (TreeNode parent) {
		
		if (parent == null) {
			
			throw new RuntimeException(parent +"�ڵ�Ϊ�գ��޷�����ӽڵ�");
		}
		return parent.left == null ? null : parent.left;
	}
	//����ָ���ڵ㣨��Ҷ�ӣ������ӽڵ㣬�����ӽڵ㲻������ ����null
	public TreeNode right (TreeNode parent) {
		
		if (parent == null) {
			
			throw new RuntimeException(parent +"�ڵ�Ϊ�գ��޷�����ӽڵ�");
		}
		return parent.right == null ? null : parent.right;
	}
	//���� �ö����������
	public int deep () {
		
		return deep(root());
	}
	//���Ǹ��ݹ鷽���� ÿ����������� Ϊ��������������� +1
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
			
			//������ ���� �������+1
			return max+1;
		}
	}
	
	
	//ʵ�� �������
	public List<TreeNode> preIterator () {
		
		return preIterator(root ());
	}
	private List<TreeNode> preIterator (TreeNode node) {
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		//������ڵ�
		list.add(node);
		//�ݹ鴦��������
		if (node.left != null) {
			list.addAll(preIterator(node.left));	
		}
		
		//�ݹ� ����������
		if (node.right != null) {
			list.addAll(preIterator(node.right));
		}
		
		
		return list;
		
	}
	
	//ʵ�� �������
	public List<TreeNode> inIterator () {
			
		return inIterator(root ());
	}
	private List<TreeNode> inIterator (TreeNode node) {
			
		List<TreeNode> list = new ArrayList<TreeNode>();
			
		
		//�ݹ鴦��������
		if (node.left != null) {
			list.addAll(inIterator(node.left));	
		}
		//������ڵ�
		list.add(node);	
		//�ݹ� ����������
		if (node.right != null) {
			list.addAll(inIterator(node.right));
		}
			
			
		return list;
			
	}
	
	
	//ʵ�� �������
	public List<TreeNode> postIterator () {
				
		return postIterator(root ());
	}
	private List<TreeNode> postIterator (TreeNode node) {
				
		List<TreeNode> list = new ArrayList<TreeNode>();
				
			
		//�ݹ鴦��������
		if (node.left != null) {
			list.addAll(postIterator(node.left));	
		}
		
		//�ݹ� ����������
		if (node.right != null) {
			list.addAll(postIterator(node.right));
		}
		//������ڵ�
		list.add(node);	
				
		return list;
				
	}
	
	//������� ����  ���� ����
	public List<TreeNode> breadthFirst () {
		
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		if (root != null) {
			//����Ԫ�� �������
			queue.offer(root);
		}
		
		while (!queue.isEmpty()) {
			
			//�����еĶ�βԪ�� ��ӵ� list��
			list.add(queue.peek());
			//ȡ����βԪ��
			TreeNode p = queue.poll();
			//��� ���ӽڵ� ��Ϊ�� �������
			if(p.left != null) {
				queue.offer(p.left);
			}
			//��� ���ӽڵ� ��Ϊ�� �������
			if(p.right != null) {
				queue.offer(p.right);
			}
		}
		
		return list;
	}
}
