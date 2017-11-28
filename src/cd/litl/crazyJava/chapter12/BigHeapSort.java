package cd.litl.crazyJava.chapter12;

import java.util.Arrays;

public class BigHeapSort {

	//堆排序
	public static void heapSort(DataWrap[] data) {
		
		System.out.println("开始排序");
		int arrayLength = data.length;
		
		//循环建堆
		for (int i = 0;i < arrayLength - 1;i++) {
			
			
			//建堆
			buildMaxheap(data,arrayLength-1-i);
			//交换堆顶 和最后一个元素
			swap(data,0,arrayLength-1-i);
		}
		System.out.println(Arrays.toString(data));
	}
	//堆 data 数组从0到lastindex 建大顶堆
	private static void buildMaxheap (DataWrap[] data,int lastIndex) {
		
		//从lastIndex 处（最后一个节点） 的父节点开始
		for(int i = (lastIndex -1)/2; i >= 0; i--) {
			
			//k 保存 当前正在 判断的节点
			int k = i;
			//如果 当前k节点的子节点存在
			while (k*2 + 1<= lastIndex) {
				//k 的 左子节点的索引
				int biggerIndex = k*2 + 1;
				//如果 biggerIndex <lastIndex  即 存在biggerIndex+1说明 右子节点 存在
				if (biggerIndex <lastIndex) {
					//判断 左子节点 和 右子节点 的大小，并 保存 节点 大的 索引
					if(data[biggerIndex].compareTo(data[biggerIndex + 1]) < 0) {
						biggerIndex++;
					}
				}
				
				//判断当前节点和子节点的大小
				if (data[k].compareTo(data[biggerIndex]) < 0) {
					//交换当前节点 和 较大的子节点的值
					swap(data,k,biggerIndex);
					//将biggerIndex 赋值给 k 开始 while 的下一次循环
					//重新保证k节点的值 大于 左右子节点
					k = biggerIndex;
				} else {
					break;
				}
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
		heapSort(data);
		System.out.println("+++++++++++++"+System.currentTimeMillis()+"++++++++++++++");
		System.out.println("+++++++++++++"+(System.currentTimeMillis() - startTime)+"++++++++++++++");
	}

}
