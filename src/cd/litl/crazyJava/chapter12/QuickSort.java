package cd.litl.crazyJava.chapter12;

import java.util.Arrays;
import java.util.List;

//���� ��ȷ
public class QuickSort {

	// ʵ�� ���������㷨 �����ڽڵ� ��������    ���� haffman���ص�  ����ǰ С�ں�
		private static void sort(DataWrap [] data,int low,int high){
	        int start = low;
	        int end = high;
	        DataWrap base = data[low];
	        
	        
	        while(end>start){
	            //�Ӻ���ǰ�Ƚ�
	            while(end>start&&data[end].compareTo(base) >= 0)  //���û�бȹؼ�ֵС�ģ��Ƚ���һ����ֱ���бȹؼ�ֵС�Ľ���λ�ã�Ȼ���ִ�ǰ����Ƚ�
	                end--;
	            if(data[end].compareTo(base) <= 0){//��ʱ data[start] == base
	            	
	            	swap(data,start,end);
	            	//��ʱ data[end] == base
	            	
	            }
	            //��ǰ����Ƚ�
	            while(end>start&&data[start].compareTo(base) <=0)//���û�бȹؼ�ֵ��ģ��Ƚ���һ����ֱ���бȹؼ�ֵ��Ľ���λ��
	               start++;
	            if(data[start].compareTo(base) >=0){//��ʱ data[end] == base
	            	
	            	swap(data,start,end);
	            	//��ʱ data[start] == base
	            	
	            }
	        //��ʱ��һ��ѭ���ȽϽ������ؼ�ֵ��λ���Ѿ�ȷ���ˡ���ߵ�ֵ���ȹؼ�ֵС���ұߵ�ֵ���ȹؼ�ֵ�󣬵������ߵ�˳���п����ǲ�һ���ģ���������ĵݹ����
	        }
	        //�ݹ�    ��ʱ start �� and ָ��ͬһ��
//	        System.out.println(data[end] == data[start]);
	        if(start>low) sort(data,low,start-1);//������С���һ������λ�õ��ؼ�ֵ����-1
	       
	        if(end<high) sort(data,start+1,high);//�ұ����С��ӹؼ�ֵ����+1�����һ��
	    }
		
		//���� ����
		public static void quickSort (DataWrap [] data) {
			
//			subSort(nodes,0,nodes.size() - 1);
			sort(data,0,data.length - 1);
//			
		}
	
		//���� data������ i j ������Ԫ��
		private static void swap (DataWrap[] data,int i,int j) {
				
			DataWrap tmp = data[i];
			data[i] = data[j];
			data[j] = tmp;
				
		}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataWrap [] data = new DataWrap [10];
		
		for (int i = 0; i < data.length;i++) {
			
			data[i] = new DataWrap(data.length-1-i,""+i+"");
		}
		
//		data[0] = new DataWrap(21,"1");
//		data[1] = new DataWrap(30,"2");
//		data[2] = new DataWrap(49,"3");
//		data[3] = new DataWrap(30,"4");
//		data[4] = new DataWrap(16,"5");
//		data[5] = new DataWrap(9,"6");
		System.out.println(data.toString());
		long startTime = System.currentTimeMillis();
		System.out.println("+++++++++++++"+System.currentTimeMillis()+"++++++++++++++");
//		selectSort(data);
		quickSort(data);
		System.out.println(Arrays.toString(data));
		System.out.println("+++++++++++++"+System.currentTimeMillis()+"++++++++++++++");
		System.out.println("+++++++++++++"+(System.currentTimeMillis() - startTime)+"++++++++++++++");
	}

}
