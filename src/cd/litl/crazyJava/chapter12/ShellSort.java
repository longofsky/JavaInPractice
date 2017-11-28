package cd.litl.crazyJava.chapter12;

import java.util.Arrays;
//shell 排序 正确
public class ShellSort {

	public static void shellSort (DataWrap [] data) {

		int length = data.length;
		//h 保存 可变增量
		int h = 1;
		while (h <= length/3) {
			h = h*3 +1;
		}
		
		while (h > 0) {
			for (int i = h; i < length;i++) {//从 第二个数  开始向前查
				
				DataWrap tmp = data[i];//整体后移时 保证 data[i] 不会消失
				
				//如果 data[i] 处的值 比他前面的值 都大  说明 有序 不用插入
				if (data[i].compareTo(data[i - h]) < 0 ) {
					
					int j = i-h;
					for (;j>=0 && data[j].compareTo(tmp) > 0;j-=h) {
						data[j+h] = data[j];
					}
					data[j+h] = tmp;
				}
			}
			h = (h-1)/3;
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

		shellSort(data);
		System.out.println(Arrays.toString(data));
		System.out.println("+++++++++++++"+System.currentTimeMillis()+"++++++++++++++");
		System.out.println("+++++++++++++"+(System.currentTimeMillis() - startTime)+"++++++++++++++");
	}

}
