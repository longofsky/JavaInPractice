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
	//��Ĭ�ϵĹ��������� ������
	public TwoLinkBinTree() {
		
		root = new TreeNode();
	}
	//��ָ�� ��Ԫ�ش���������
	public TwoLinkBinTree(E data) {
		
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
		
		//���� ���������淨 ���Ҫ����ָ���ڵ�ĸ��ڵ� ����� ������
//		if(empty()) {
//			
//			throw new RuntimeException("����");
//		} else {
//			
//			TreeNode left = root.left;
//			TreeNode right = root.right;
//			
//		}
		return null;
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
			
			//������ ���� �������+1
			return max+1;
		}
	}
}
