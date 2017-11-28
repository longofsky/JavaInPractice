package cd.litl.crazyJava.chapter12;

import java.util.Arrays;

//��������--ð������
public class BubbleSort {

	public static void bubbleSort (DataWrap[] data) {
		
		System.out.println("��ʼ����");
		int arrayLength = data.length;
		
		for (int i = 0; i < arrayLength; i ++) {
			
			//��¼ ��û�� �������� ���û�� ������  
			boolean flag = false;
			for (int j= 0; j < arrayLength - 1 - i; j++) {
				
				//��� j��������Ԫ�� ���� j+1����Ԫ��  ��������
				if (data[j].compareTo(data[j+1]) > 0) {
					
					swap(data,j,j+1);
					flag = true;
				}
			}
			//��� �ϴ� ���� δ�������������� ����
			if (!flag) {
				break;
			}
		}
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
