package cd.litl.crazyJava.chapter11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import cd.litl.crazyJava.chapter11.ThreeLinkBinTree.TreeNode;

//���� ������
public class SortedBinTree<T extends Comparable> {

	//���� ���� �ڵ�
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
		
		public String toString () {
			
			return "[data="+data+"]";
		}
		
		public boolean equals(Object obj) {
			
			if (this == obj) {
				
				return true;
			}
			if (obj.getClass() == TreeNode.class) {
				
				TreeNode target = (TreeNode)obj;
				return this.data.equals(target.data) 
						&& this.left == target.left 
						&& this.right == target.right
						&& this.parent == target.parent;
			}
			return false;
		}
	}
	
	private TreeNode root;
	
	//���������� ���ڴ������� ������
	public SortedBinTree () {
		
		root = null;
	}
	public SortedBinTree (T o) {
		
		root = new TreeNode(o,null,null,null);
	}
	
	//��ӽڵ�
	public void add(T ele) {
		
		//��� ���ڵ�Ϊ null
		if (root == null) {
			
			root = new TreeNode(ele,null,null,null);
		} else {
			
			//��ǰ�ڵ�
			TreeNode current = root;
			TreeNode parent = null;
			
			//Ŀ��ڵ� �͵�ǰ�ڵ� �Ƚ�
			int cmp = 0;
			//�� ��ǰ�ڵ� ��Ϊ�յ�ʱ�� �������� ����  �������ǰ�ڵ�Ϊ�� ���� Ŀ��ڵ� ��ֵ�� ��ǰ�ڵ�
			//���� ���ʵ�Ҷ�ӽڵ㣬�Ը�Ҷ�ӽڵ� Ϊ���ڵ� ��� �½ڵ�
			do {
				//Ŀ��ڵ���ӵ� ��ǰ�ڵ���  name ��ǰ�ڵ� Ϊ ���ڵ�
				parent = current;
				
				cmp = ele.compareTo(current.data);
				//����½ڵ��ֵ ���� ��ǰ�ڵ�
				if (cmp > 0) {
					//�����ӽڵ� ��Ϊ��ǰ�ڵ�
					current = current.right;
				} else {
					//�����ӽڵ� ��Ϊ��ǰ�ڵ�
					current = current.left;
				}
				
			} while (current != null);
			
			//��ʱ  ��ǰ�ڵ�current Ϊ�� parent �ڵ� ��current �ĸ��ڵ�   cmp ���� ele ��parent.data �ıȽ� ���
			TreeNode newNode = new TreeNode(ele,null,null,parent);
			if (cmp > 0) {
				
				parent.right = newNode;
			} else {
				parent.left = newNode;
			}
		}
	}
	
	//ɾ���ڵ�
	public void remove (T ele) {
		
		//��ȡ Ҫɾ���Ľڵ�
		TreeNode target = getNode(ele);
		if (target == null) {
			return;
		}
		//��Ҫɾ���Ľڵ� ���ӽڵ�
		if (target.left == null && target.right == null) {
			
			//��� ��ɾ���ĸ��ڵ�
			if (target == root) {
				root = null;
			} else {
				//��ɾ�� �ڵ��Ǹ��ڵ�� ���ӽڵ�
				if (target.parent.left == target) {
					//��target ���ڵ��left ��Ϊ��
					target.parent.left = null;
				}
				//��ɾ�� �ڵ��Ǹ��ڵ�� ���ӽڵ�
				else {
					target.parent.right = null;
				}
				//ɾ�� target �� ���ڵ�ľ��
				target.parent = null;
			}
		}
		//��Ҫɾ���Ľڵ� ֻ�� ���ӽڵ�
		else if (target.left != null && target.right == null) {
			
			//��� ��ɾ���ĸ��ڵ�
			if (target == root) {
				//�� ���ڵ�� ���ӽڵ� ��Ϊ���ڵ�
				root = root.left;
				//�ж� target ��root����ϵ
				root.parent.left = null;
				//�ж� root ��target����ϵ
				root.parent = null;
			} else {
				//�ж� target ���� ���ӽڵ� ���� �ҽڵ�
				//��� target �� ���ӽڵ�
				if(target == target.parent.left) {
					
					target.parent.left = target.left;
				}else {
					target.parent.right = target.left;
				}
				
				target.left.parent = target.parent;
				//�ж� target �����߽ڵ����ϵ
				target.left = null;
				target.parent = null;
			}
			
		}
		//��Ҫɾ���Ľڵ� ֻ�� ���ӽڵ�
		else if (target.left == null && target.right != null) {
			//��� ��ɾ���ĸ��ڵ�
			if (target == root) {
				//�� ���ڵ�� ���ӽڵ� ��Ϊ���ڵ�
				root = root.right;
				//�ж� target ��root����ϵ
				root.parent.right = null;
				//�ж� root ��target����ϵ
				root.parent = null;
			} else {
				//�ж� target ���� ���ӽڵ� ���� �ҽڵ�
				//��� target �� ���ӽڵ�
				if(target == target.parent.left) {
					
					target.parent.left = target.right;
				}else {
					target.parent.right = target.right;
				}
				
				target.right.parent = target.parent;
				//�ж� target �����߽ڵ����ϵ
				target.right = null;
				target.parent = null;
			}
		}
		//�����ҽڵ㣨������ ʵ�ַ�����
		else {
			//leftMaxNode ���� ���� target�Ľڵ��� ������ �����Ľڵ�
			TreeNode leftMaxNode = target.left;
			//���� target�Ľڵ��� ������ �����Ľڵ�
			while (leftMaxNode.right != null) {
				leftMaxNode = leftMaxNode.right;
			}
			//�ж� leftMaxNode �͵�ǰ������ϵ
			leftMaxNode.parent.right = null;
			leftMaxNode.parent = null;
				//���µĴ���
				target.left.parent = leftMaxNode;
				target.right.parent = leftMaxNode;
				leftMaxNode.left = target.left;
				leftMaxNode.right = target.right;
				
				if (target != root) {
					leftMaxNode.parent = target.parent;
					//target ���� ����ڵ� ���� �ҽڵ�
					if(target == target.parent.left) {
						//�� �ϵĴ���
						target.parent.left = leftMaxNode;
						
					} else {
						target.parent.right = leftMaxNode;	
					}
					
					//�ж� target �� �ϲ�ڵ����ϵ
					target.parent = null;
				}		
			//�ж� target �� ���ҽڵ����ϵ
			target.left = null;
			target.right = null;	
		}
	}
	
	//����ָ�� ֵ �����ڵ�
	public TreeNode getNode (T ele) {
		
		//�Ӹ��ڵ� ��ʼ����
		TreeNode p = root;
		
		while (p != null) {
			
			int cmp = ele.compareTo(p.data);
			
			if (cmp > 0) {
				p = p.right;
			} else if(cmp<0) {
				p = p.left;
			} else {
				return p;
			}
		}
		
		return null;
	}
	
	//ʵ�� �������
		public List<TreeNode> preIterator () {
			
			return preIterator(root);
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
				
			return inIterator(root);
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
					
			return postIterator(root);
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
