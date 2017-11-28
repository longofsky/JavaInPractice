package cd.litl.crazyJava.chapter12;

import java.util.Arrays;
//归并 排序  代码正确
public class MergeSort {

	public static void mergeSort (DataWrap [] data) {
		
		sort(data,0,data.length-1);
		
	}
	public static void sort (DataWrap [] data,int left,int right) {
		
		if(left < right) {
			//找出中间索引
			int center= (left+right)/2;
			//对左边的数组进行递归
			sort(data,left,center);
			//对右边的数组进行递归
			sort(data,center+1,right);
			
			//合并
			merge(data,left,center,right);
		}
		
	}
	public static void merge (DataWrap [] data,int left,int center,int right) {
		
		DataWrap [] tmpData = new DataWrap [data.length];
		
		int mid = center +1;
		
		int third = left;
		
		int tmp = left;
		while (left <= center && mid <= right) {
			
			//从两个数组中 取出 小的放入中间数组
			if (data[left].compareTo(data[mid]) <= 0) {
				
				tmpData[third ++] = data[left ++];
			} else {
				tmpData[third ++] = data[mid ++];
			}
		}
		
		//将剩余 部分放入数组
		while (mid <= right) {
			tmpData[third ++] = data[mid ++];
		}
		
		while (left <= center) {
			tmpData[third ++] = data[left ++];
		}
		
		//将中间数组的内容 复制考回 原数组    （原 数组 left - right 范围内的内容被复制回 原数组）
		while (tmp <= right) {
			data[tmp] = tmpData[tmp ++];
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataWrap [] data = new DataWrap [10000];
		
		for (int i = 0; i < data.length;i++) {
			
			data[i] = new DataWrap(data.length-1-i,""+i+"");
		}
		
		System.out.println(data.toString());
		long startTime = System.currentTimeMillis();
		System.out.println("+++++++++++++"+System.currentTimeMillis()+"++++++++++++++");

		mergeSort(data);
		System.out.println(Arrays.toString(data));
		System.out.println("+++++++++++++"+System.currentTimeMillis()+"++++++++++++++");
		System.out.println("+++++++++++++"+(System.currentTimeMillis() - startTime)+"++++++++++++++");
	}

}
