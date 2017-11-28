package cd.litl.crazyJava.chapter11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import cd.litl.crazyJava.chapter11.ThreeLinkBinTree.TreeNode;

//排序 二叉树
public class SortedBinTree<T extends Comparable> {

	//创建 三叉 节点
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
	
	//两个构造器 用于创建排序 二叉树
	public SortedBinTree () {
		
		root = null;
	}
	public SortedBinTree (T o) {
		
		root = new TreeNode(o,null,null,null);
	}
	
	//添加节点
	public void add(T ele) {
		
		//如果 根节点为 null
		if (root == null) {
			
			root = new TreeNode(ele,null,null,null);
		} else {
			
			//当前节点
			TreeNode current = root;
			TreeNode parent = null;
			
			//目标节点 和当前节点 比较
			int cmp = 0;
			//当 当前节点 不为空的时候 继续向下 迭代  ，如果当前节点为空 ，把 目标节点 赋值给 当前节点
			//搜索 合适的叶子节点，以该叶子节点 为父节点 添加 新节点
			do {
				//目标节点添加到 当前节点下  name 当前节点 为 父节点
				parent = current;
				
				cmp = ele.compareTo(current.data);
				//如果新节点的值 大于 当前节点
				if (cmp > 0) {
					//以右子节点 作为当前节点
					current = current.right;
				} else {
					//以左子节点 作为当前节点
					current = current.left;
				}
				
			} while (current != null);
			
			//此时  当前节点current 为空 parent 节点 是current 的父节点   cmp 代表 ele 和parent.data 的比较 结果
			TreeNode newNode = new TreeNode(ele,null,null,parent);
			if (cmp > 0) {
				
				parent.right = newNode;
			} else {
				parent.left = newNode;
			}
		}
	}
	
	//删除节点
	public void remove (T ele) {
		
		//获取 要删除的节点
		TreeNode target = getNode(ele);
		if (target == null) {
			return;
		}
		//需要删除的节点 无子节点
		if (target.left == null && target.right == null) {
			
			//如果 被删除的根节点
			if (target == root) {
				root = null;
			} else {
				//被删除 节点是父节点的 左子节点
				if (target.parent.left == target) {
					//将target 父节点的left 设为空
					target.parent.left = null;
				}
				//被删除 节点是父节点的 右子节点
				else {
					target.parent.right = null;
				}
				//删除 target 中 父节点的句柄
				target.parent = null;
			}
		}
		//需要删除的节点 只有 左子节点
		else if (target.left != null && target.right == null) {
			
			//如果 被删除的根节点
			if (target == root) {
				//将 根节点的 左子节点 设为根节点
				root = root.left;
				//切断 target 到root的联系
				root.parent.left = null;
				//切断 root 到target的联系
				root.parent = null;
			} else {
				//判断 target 本身 是子节点 还是 右节点
				//如果 target 是 左子节点
				if(target == target.parent.left) {
					
					target.parent.left = target.left;
				}else {
					target.parent.right = target.left;
				}
				
				target.left.parent = target.parent;
				//切断 target 与上线节点的联系
				target.left = null;
				target.parent = null;
			}
			
		}
		//需要删除的节点 只有 右子节点
		else if (target.left == null && target.right != null) {
			//如果 被删除的根节点
			if (target == root) {
				//将 根节点的 左子节点 设为根节点
				root = root.right;
				//切断 target 到root的联系
				root.parent.right = null;
				//切断 root 到target的联系
				root.parent = null;
			} else {
				//判断 target 本身 是子节点 还是 右节点
				//如果 target 是 左子节点
				if(target == target.parent.left) {
					
					target.parent.left = target.right;
				}else {
					target.parent.right = target.right;
				}
				
				target.right.parent = target.parent;
				//切断 target 与上线节点的联系
				target.right = null;
				target.parent = null;
			}
		}
		//有左右节点（有两种 实现方法）
		else {
			//leftMaxNode 用于 保存 target的节点中 左子树 中最大的节点
			TreeNode leftMaxNode = target.left;
			//搜索 target的节点中 左子树 中最大的节点
			while (leftMaxNode.right != null) {
				leftMaxNode = leftMaxNode.right;
			}
			//切断 leftMaxNode 和当前树的联系
			leftMaxNode.parent.right = null;
			leftMaxNode.parent = null;
				//向下的处理
				target.left.parent = leftMaxNode;
				target.right.parent = leftMaxNode;
				leftMaxNode.left = target.left;
				leftMaxNode.right = target.right;
				
				if (target != root) {
					leftMaxNode.parent = target.parent;
					//target 本身 是左节点 还是 右节点
					if(target == target.parent.left) {
						//向 上的处理
						target.parent.left = leftMaxNode;
						
					} else {
						target.parent.right = leftMaxNode;	
					}
					
					//切断 target 和 上层节点的联系
					target.parent = null;
				}		
			//切断 target 和 左右节点的联系
			target.left = null;
			target.right = null;	
		}
	}
	
	//根据指定 值 搜索节点
	public TreeNode getNode (T ele) {
		
		//从根节点 开始搜索
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
	
	//实现 先序遍历
		public List<TreeNode> preIterator () {
			
			return preIterator(root);
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
				
			return inIterator(root);
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
					
			return postIterator(root);
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
