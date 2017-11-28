package cd.litl.crazyJava.chapter12;

import java.util.Arrays;

//直接插入排序--代码 正确
public class InsertSort {

	public static void insertSort (DataWrap [] data) {
		
		int length = data.length;
		for (int i = 1; i < length;i++) {//从 第二个数  开始向前查
			
			DataWrap tmp = data[i];//整体后移时 保证 data[i] 不会消失
			
			//如果 data[i] 处的值 比他前面的值 都大  说明 有序 不用插入
			if (data[i].compareTo(data[i - 1]) < 0 ) {
				
				int j = i-1;
				for (;j>=0 && data[j].compareTo(tmp) > 0;j--) {
					data[j+1] = data[j];
				}
				data[j+1] = tmp;
			}
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
		insertSort(data);
		System.out.println(Arrays.toString(data));
		System.out.println("+++++++++++++"+System.currentTimeMillis()+"++++++++++++++");
		System.out.println("+++++++++++++"+(System.currentTimeMillis() - startTime)+"++++++++++++++");
	}

}
