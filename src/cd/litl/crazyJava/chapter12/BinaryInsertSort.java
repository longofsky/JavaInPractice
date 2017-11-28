package cd.litl.crazyJava.chapter12;

import java.util.Arrays;

//�۰����  ���� ��ȷ
public class BinaryInsertSort {

	public static void binaryInsertSort (DataWrap [] data) {
		
		int length = data.length;
		for (int i = 1; i < length;i++) {//�� �ڶ�����  ��ʼ��ǰ��
			
			DataWrap tmp = data[i];//�������ʱ ��֤ data[i] ������ʧ
			
			int low = 0;
			int high = i-1;
			
			while (low <= high) {
				
				//�ҳ� low �� high �м�
				int mid = (low + high) /2;
				//tmpֵ���� low high ���м�ֵ
				if (tmp.compareTo(data[mid]) > 0) {
					low = mid + 1;
				} else {
					high = mid-1;
				}
			}
			
			//�� low ��i   ��ʱ low > high
			for (int j =i;j>low;j--) {
				data[j] = data[j-1];
			}
			//���tmp��ֵ������ʵ�λ��
			data[low] = tmp;
//			System.out.println(Arrays.toString(data));
			
			//��� data[i] ����ֵ ����ǰ���ֵ ����  ˵�� ���� ���ò���
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
		binaryInsertSort(data);
		System.out.println(Arrays.toString(data));
		System.out.println("+++++++++++++"+System.currentTimeMillis()+"++++++++++++++");
		System.out.println("+++++++++++++"+(System.currentTimeMillis() - startTime)+"++++++++++++++");
	}

}
