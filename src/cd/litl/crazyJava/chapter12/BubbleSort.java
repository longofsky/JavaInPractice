package cd.litl.crazyJava.chapter12;

import java.util.Arrays;

//交换排序--冒泡排序
public class BubbleSort {

	public static void bubbleSort (DataWrap[] data) {
		
		System.out.println("开始排序");
		int arrayLength = data.length;
		
		for (int i = 0; i < arrayLength; i ++) {
			
			//记录 有没有 发生交换 如果没有 季结束  
			boolean flag = false;
			for (int j= 0; j < arrayLength - 1 - i; j++) {
				
				//如果 j索引处的元素 大于 j+1处的元素  发生交换
				if (data[j].compareTo(data[j+1]) > 0) {
					
					swap(data,j,j+1);
					flag = true;
				}
			}
			//如果 上次 排序 未发生交换，排序 结束
			if (!flag) {
				break;
			}
		}
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

		DataWrap [] data = new DataWrap [10000];
		
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
		bubbleSort(data);
		System.out.println(Arrays.toString(data));
		System.out.println("+++++++++++++"+System.currentTimeMillis()+"++++++++++++++");
		System.out.println("+++++++++++++"+(System.currentTimeMillis() - startTime)+"++++++++++++++");
	}

}
