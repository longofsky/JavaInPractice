package cd.litl.crazyJava.chapter12;

import java.util.Arrays;
//�鲢 ����  ������ȷ
public class MergeSort {

	public static void mergeSort (DataWrap [] data) {
		
		sort(data,0,data.length-1);
		
	}
	public static void sort (DataWrap [] data,int left,int right) {
		
		if(left < right) {
			//�ҳ��м�����
			int center= (left+right)/2;
			//����ߵ�������еݹ�
			sort(data,left,center);
			//���ұߵ�������еݹ�
			sort(data,center+1,right);
			
			//�ϲ�
			merge(data,left,center,right);
		}
		
	}
	public static void merge (DataWrap [] data,int left,int center,int right) {
		
		DataWrap [] tmpData = new DataWrap [data.length];
		
		int mid = center +1;
		
		int third = left;
		
		int tmp = left;
		while (left <= center && mid <= right) {
			
			//������������ ȡ�� С�ķ����м�����
			if (data[left].compareTo(data[mid]) <= 0) {
				
				tmpData[third ++] = data[left ++];
			} else {
				tmpData[third ++] = data[mid ++];
			}
		}
		
		//��ʣ�� ���ַ�������
		while (mid <= right) {
			tmpData[third ++] = data[mid ++];
		}
		
		while (left <= center) {
			tmpData[third ++] = data[left ++];
		}
		
		//���м���������� ���ƿ��� ԭ����    ��ԭ ���� left - right ��Χ�ڵ����ݱ����ƻ� ԭ���飩
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
