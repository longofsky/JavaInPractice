package cd.litl.crazyJava.chapter12;

import java.util.Arrays;

public class BigHeapSort {

	//������
	public static void heapSort(DataWrap[] data) {
		
		System.out.println("��ʼ����");
		int arrayLength = data.length;
		
		//ѭ������
		for (int i = 0;i < arrayLength - 1;i++) {
			
			
			//����
			buildMaxheap(data,arrayLength-1-i);
			//�����Ѷ� �����һ��Ԫ��
			swap(data,0,arrayLength-1-i);
		}
		System.out.println(Arrays.toString(data));
	}
	//�� data �����0��lastindex ���󶥶�
	private static void buildMaxheap (DataWrap[] data,int lastIndex) {
		
		//��lastIndex �������һ���ڵ㣩 �ĸ��ڵ㿪ʼ
		for(int i = (lastIndex -1)/2; i >= 0; i--) {
			
			//k ���� ��ǰ���� �жϵĽڵ�
			int k = i;
			//��� ��ǰk�ڵ���ӽڵ����
			while (k*2 + 1<= lastIndex) {
				//k �� ���ӽڵ������
				int biggerIndex = k*2 + 1;
				//��� biggerIndex <lastIndex  �� ����biggerIndex+1˵�� ���ӽڵ� ����
				if (biggerIndex <lastIndex) {
					//�ж� ���ӽڵ� �� ���ӽڵ� �Ĵ�С���� ���� �ڵ� ��� ����
					if(data[biggerIndex].compareTo(data[biggerIndex + 1]) < 0) {
						biggerIndex++;
					}
				}
				
				//�жϵ�ǰ�ڵ���ӽڵ�Ĵ�С
				if (data[k].compareTo(data[biggerIndex]) < 0) {
					//������ǰ�ڵ� �� �ϴ���ӽڵ��ֵ
					swap(data,k,biggerIndex);
					//��biggerIndex ��ֵ�� k ��ʼ while ����һ��ѭ��
					//���±�֤k�ڵ��ֵ ���� �����ӽڵ�
					k = biggerIndex;
				} else {
					break;
				}
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
		heapSort(data);
		System.out.println("+++++++++++++"+System.currentTimeMillis()+"++++++++++++++");
		System.out.println("+++++++++++++"+(System.currentTimeMillis() - startTime)+"++++++++++++++");
	}

}
