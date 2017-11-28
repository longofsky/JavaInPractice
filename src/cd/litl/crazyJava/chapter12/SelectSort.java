package cd.litl.crazyJava.chapter12;

import java.util.Arrays;
import java.util.Date;

//定义一个数据包装类
class DataWrap implements Comparable<DataWrap> {

	int data;
	String flag;
	
	public DataWrap (int data,String flag) {
		
		this.data = data;
		this.flag = flag;
	}
	public String toString () {
		
		return data + flag;
	}
	
	@Override
	public int compareTo(DataWrap o) {
		// TODO Auto-generated method stub
		int i = 0;
		if (this.data > o.data) {
			
			i = 1;
		} else if (this.data == o.data) {
			i = 0;
		} else {
			i = -1;
		}
		return i;
	}
	
}
public class SelectSort {

	public static void selectSort (DataWrap [] data) {
		
		System.out.println("开始排序");
		for(int i = 0;i < data.length; i++) {
			for (int j = i+1; j < data.length; j++) {
				if ( data[i].compareTo(data[j]) > 0) {
					DataWrap tmp = data[j];
					data[j] = data[i];
					data[i] = tmp;
				}
			}
		}
		
		System.out.println(Arrays.toString(data));
	}
	//改进-- 增加 位置记录变量 减少 交换次数
	public static void selectSort2 (DataWrap [] data) {
		
		System.out.println("开始排序");
		for(int i = 0;i < data.length; i++) {
			int k = i;
			for (int j = i+1; j < data.length; j++) {
				
				if ( data[k].compareTo(data[j]) > 0) {
					k = j;
				}
				
			}
			DataWrap tmp = data[k];
			data[k] = data[i];
			data[i] = tmp;
		}
		
		System.out.println(Arrays.toString(data));
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
		selectSort2(data);
		System.out.println("+++++++++++++"+System.currentTimeMillis()+"++++++++++++++");
		System.out.println("+++++++++++++"+(System.currentTimeMillis() - startTime)+"++++++++++++++");

	}

}
