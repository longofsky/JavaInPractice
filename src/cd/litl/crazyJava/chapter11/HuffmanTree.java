package cd.litl.crazyJava.chapter11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import cd.litl.crazyJava.chapter11.ThreeLinkBinTree.TreeNode;

//哈夫曼树
public class HuffmanTree {

	//内部类 节点
	public static class Node<E> {
		
		E data;
		double weight;//权重
		Node leftChild;
		Node rightChild;
		
		public Node (E data,double weight) {
			
			this.data = data;
			this.weight = weight;
		}
		
		public String toString () {
			return "Node[data=" +data +",weight = "+weight+"]";
		}
	}
	
	public static void main (String [] args) {
		
		List<Node> nodes = new ArrayList<Node>();

		nodes.add(new Node("A",40.0));
		nodes.add(new Node("B",8.0));
		nodes.add(new Node("C",10.0));
		nodes.add(new Node("D",30.0));
		nodes.add(new Node("E",10.0));
		nodes.add(new Node("F",2.0));
		
		Node root = HuffmanTree.createTree(nodes);
		System.out.println(breadthFirst(root));
	}
	
	/**
	 * 构造哈夫曼树
	 * nodes节点集合
	 * return  构造出来的 哈夫曼树 根节点
	 */
	
	private static Node createTree(List <Node> nodes) {
		
		while(nodes.size() > 1) {
			
			//nodes 进行快速排序
			quickSort(nodes);
			//获取权值最小的 节点
			Node left = nodes.get(nodes.size() - 1);
			Node right = nodes.get(nodes.size() - 2);
			//生成新节点，新节点的权值 是两个子节点的权值 之和
			Node parent = new Node(null,left.weight + right.weight);
			//让 新节点 作为 权值最小的 两个节点的 父节点
			parent.leftChild = left;
			parent.rightChild = right;
			//删除 权值 最小的 两个 节点
			nodes.remove(nodes.size() - 1);
			nodes.remove(nodes.size() - 1);
			//将 新生成的父节点 添加到 集合中
			
			nodes.add(parent);
		}
		//返回 nodes 集合中唯一的节点  也就是根节点
		return nodes.get(0);
	}
	
	//将指定数组的 i j 索引处的元素交换
	private static void swap (List<Node> nodes,int i,int j) {
		
		Node tmp;
		tmp = nodes.get(i);
		nodes.set(i, nodes.get(j));
		nodes.set(j, tmp);
	}
	
	//实现 快速排序算法 ，对于节点 进行排序---错误
	private static void subSort (List<Node> nodes,int start,int end) {
		
		//需要排序
		if (start < end) {
			
			//以第一个元素为分界值
			Node base = nodes.get(start);
			//i 从 左边搜索 搜索大于分界值得索引
			int i = start;
			//j 从 右边搜索 搜索小于分界值得索引
			int j = end + 1;
			
			while (true) {
				
				//找到大于分界值元素的索引 或者 i 已到了end  处
				while ( i < end && nodes.get(++ i).weight >= base.weight);
				//找到小于分界值元素的索引 或者j 已到了start  处
				while ( j > start && nodes.get(--j).weight <= base.weight);
				
				if (i < j) {
					
					swap(nodes,i,j);
				} else {
					
					break;
				}
				swap(nodes,start,j);
				//递归左边子序列
				subSort(nodes,start,i-1);
				//递归 右边子序列
				subSort(nodes,j+1,end);
			}
		}
		System.out.println(nodes.toString());
	}
	
	// 实现 快速排序算法 ，对于节点 进行排序    根据 haffman树特点  大在前 小在后
	private static void sort(List<Node> nodes,int low,int high){
        int start = low;
        int end = high;
        Node base = nodes.get(low);
        
        
        while(end>start){
            //从后往前比较
            while(end>start&&nodes.get(end).weight<=base.weight)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(nodes.get(end).weight>=base.weight){
            	swap(nodes,start,end);
            }
            //从前往后比较
            while(end>start&&nodes.get(start).weight>=base.weight)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
               start++;
            if(nodes.get(start).weight<=base.weight){
            	swap(nodes,start,end);
            }
        //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start>low) sort(nodes,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) sort(nodes,start+1,high);//右边序列。从关键值索引+1到最后一个
    }
	
	//快速 排序
	public static void quickSort (List<Node> nodes) {
		
//		subSort(nodes,0,nodes.size() - 1);
		sort(nodes,0,nodes.size() - 1);
		System.out.println(nodes.toString());
	}
	
	//广度优先 遍历  借助 队列
	public static List<Node> breadthFirst (Node root) {
			
		Queue<Node> queue = new ArrayDeque<Node>();
		List<Node> list = new ArrayList<Node>();
			
		if (root != null) {
			//将根元素 加入队列
			queue.offer(root);
		}
			
		while (!queue.isEmpty()) {
				
			//将队列的队尾元素 添加到 list中
			list.add(queue.peek());
			//取出队尾元素
			Node p = queue.poll();
			//如果 左子节点 不为空 加入队列
			if(p.leftChild != null) {
				queue.offer(p.leftChild);
			}
			//如果 右子节点 不为空 加入队列
			if(p.rightChild != null) {
				queue.offer(p.rightChild);
			}
		}
			
		return list;
	}
}
