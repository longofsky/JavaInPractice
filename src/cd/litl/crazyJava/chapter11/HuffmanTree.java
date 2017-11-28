package cd.litl.crazyJava.chapter11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import cd.litl.crazyJava.chapter11.ThreeLinkBinTree.TreeNode;

//��������
public class HuffmanTree {

	//�ڲ��� �ڵ�
	public static class Node<E> {
		
		E data;
		double weight;//Ȩ��
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
	 * �����������
	 * nodes�ڵ㼯��
	 * return  ��������� �������� ���ڵ�
	 */
	
	private static Node createTree(List <Node> nodes) {
		
		while(nodes.size() > 1) {
			
			//nodes ���п�������
			quickSort(nodes);
			//��ȡȨֵ��С�� �ڵ�
			Node left = nodes.get(nodes.size() - 1);
			Node right = nodes.get(nodes.size() - 2);
			//�����½ڵ㣬�½ڵ��Ȩֵ �������ӽڵ��Ȩֵ ֮��
			Node parent = new Node(null,left.weight + right.weight);
			//�� �½ڵ� ��Ϊ Ȩֵ��С�� �����ڵ�� ���ڵ�
			parent.leftChild = left;
			parent.rightChild = right;
			//ɾ�� Ȩֵ ��С�� ���� �ڵ�
			nodes.remove(nodes.size() - 1);
			nodes.remove(nodes.size() - 1);
			//�� �����ɵĸ��ڵ� ��ӵ� ������
			
			nodes.add(parent);
		}
		//���� nodes ������Ψһ�Ľڵ�  Ҳ���Ǹ��ڵ�
		return nodes.get(0);
	}
	
	//��ָ������� i j ��������Ԫ�ؽ���
	private static void swap (List<Node> nodes,int i,int j) {
		
		Node tmp;
		tmp = nodes.get(i);
		nodes.set(i, nodes.get(j));
		nodes.set(j, tmp);
	}
	
	//ʵ�� ���������㷨 �����ڽڵ� ��������---����
	private static void subSort (List<Node> nodes,int start,int end) {
		
		//��Ҫ����
		if (start < end) {
			
			//�Ե�һ��Ԫ��Ϊ�ֽ�ֵ
			Node base = nodes.get(start);
			//i �� ������� �������ڷֽ�ֵ������
			int i = start;
			//j �� �ұ����� ����С�ڷֽ�ֵ������
			int j = end + 1;
			
			while (true) {
				
				//�ҵ����ڷֽ�ֵԪ�ص����� ���� i �ѵ���end  ��
				while ( i < end && nodes.get(++ i).weight >= base.weight);
				//�ҵ�С�ڷֽ�ֵԪ�ص����� ����j �ѵ���start  ��
				while ( j > start && nodes.get(--j).weight <= base.weight);
				
				if (i < j) {
					
					swap(nodes,i,j);
				} else {
					
					break;
				}
				swap(nodes,start,j);
				//�ݹ����������
				subSort(nodes,start,i-1);
				//�ݹ� �ұ�������
				subSort(nodes,j+1,end);
			}
		}
		System.out.println(nodes.toString());
	}
	
	// ʵ�� ���������㷨 �����ڽڵ� ��������    ���� haffman���ص�  ����ǰ С�ں�
	private static void sort(List<Node> nodes,int low,int high){
        int start = low;
        int end = high;
        Node base = nodes.get(low);
        
        
        while(end>start){
            //�Ӻ���ǰ�Ƚ�
            while(end>start&&nodes.get(end).weight<=base.weight)  //���û�бȹؼ�ֵС�ģ��Ƚ���һ����ֱ���бȹؼ�ֵС�Ľ���λ�ã�Ȼ���ִ�ǰ����Ƚ�
                end--;
            if(nodes.get(end).weight>=base.weight){
            	swap(nodes,start,end);
            }
            //��ǰ����Ƚ�
            while(end>start&&nodes.get(start).weight>=base.weight)//���û�бȹؼ�ֵ��ģ��Ƚ���һ����ֱ���бȹؼ�ֵ��Ľ���λ��
               start++;
            if(nodes.get(start).weight<=base.weight){
            	swap(nodes,start,end);
            }
        //��ʱ��һ��ѭ���ȽϽ������ؼ�ֵ��λ���Ѿ�ȷ���ˡ���ߵ�ֵ���ȹؼ�ֵС���ұߵ�ֵ���ȹؼ�ֵ�󣬵������ߵ�˳���п����ǲ�һ���ģ���������ĵݹ����
        }
        //�ݹ�
        if(start>low) sort(nodes,low,start-1);//������С���һ������λ�õ��ؼ�ֵ����-1
        if(end<high) sort(nodes,start+1,high);//�ұ����С��ӹؼ�ֵ����+1�����һ��
    }
	
	//���� ����
	public static void quickSort (List<Node> nodes) {
		
//		subSort(nodes,0,nodes.size() - 1);
		sort(nodes,0,nodes.size() - 1);
		System.out.println(nodes.toString());
	}
	
	//������� ����  ���� ����
	public static List<Node> breadthFirst (Node root) {
			
		Queue<Node> queue = new ArrayDeque<Node>();
		List<Node> list = new ArrayList<Node>();
			
		if (root != null) {
			//����Ԫ�� �������
			queue.offer(root);
		}
			
		while (!queue.isEmpty()) {
				
			//�����еĶ�βԪ�� ��ӵ� list��
			list.add(queue.peek());
			//ȡ����βԪ��
			Node p = queue.poll();
			//��� ���ӽڵ� ��Ϊ�� �������
			if(p.leftChild != null) {
				queue.offer(p.leftChild);
			}
			//��� ���ӽڵ� ��Ϊ�� �������
			if(p.rightChild != null) {
				queue.offer(p.rightChild);
			}
		}
			
		return list;
	}
}
