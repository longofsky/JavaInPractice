package cd.litl.crazyJava.chapter12;

import java.util.Arrays;
import java.util.List;

//代码 正确
public class QuickSort {

	// 实现 快速排序算法 ，对于节点 进行排序    根据 haffman树特点  大在前 小在后
		private static void sort(DataWrap [] data,int low,int high){
	        int start = low;
	        int end = high;
	        DataWrap base = data[low];
	        
	        
	        while(end>start){
	            //从后往前比较
	            while(end>start&&data[end].compareTo(base) >= 0)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
	                end--;
	            if(data[end].compareTo(base) <= 0){//此时 data[start] == base
	            	
	            	swap(data,start,end);
	            	//此时 data[end] == base
	            	
	            }
	            //从前往后比较
	            while(end>start&&data[start].compareTo(base) <=0)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
	               start++;
	            if(data[start].compareTo(base) >=0){//此时 data[end] == base
	            	
	            	swap(data,start,end);
	            	//此时 data[start] == base
	            	
	            }
	        //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
	        }
	        //递归    此时 start 和 and 指向同一点
//	        System.out.println(data[end] == data[start]);
	        if(start>low) sort(data,low,start-1);//左边序列。第一个索引位置到关键值索引-1
	       
	        if(end<high) sort(data,start+1,high);//右边序列。从关键值索引+1到最后一个
	    }
		
		//快速 排序
		public static void quickSort (DataWrap [] data) {
			
//			subSort(nodes,0,nodes.size() - 1);
			sort(data,0,data.length - 1);
//			
		}
	
		//交换 data数组中 i j 两处的元素
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
