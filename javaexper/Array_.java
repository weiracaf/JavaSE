package yuan.javaexper;

import java.util.Arrays;

public class Array_ {
	public static void main(String[] args) {
		int[] arr = {33,22,11,44,66,55};
		System.out.println(Arrays.toString(arr));	//[33,22,11,44,66,55]

		Arrays.sort(arr);	//����
		System.out.println(Arrays.toString(arr));	//[11,22,33,44,55,66]

		int[] arr2 = {11,22,33,44,55,66};
		System.out.println(Arrays.binarySearch(arr2,22));	//1
		System.out.println(Arrays.binarySearch(arr2,66));	//5
		System.out.println(Arrays.binarySearch(arr2,88));	//-7
		/* Ϊʲô�������-7��
			����������������У��򷵻������������������򷵻� (-(�����) - 1)��
			����� ������Ϊ���������������һ�㣺����һ�����ڴ˼���Ԫ��������
				��������е�����Ԫ�ض�С��ָ���ļ�����Ϊ a.length��
			ע�⣺�Ᵽ֤�˵��ҽ����˼����ҵ�ʱ�����ص�ֵ�� >= 0��
		����Ԫ��88��
			���88Ҫ���������У�Ӧ�÷�������Ϊ6��λ�ã�-6-1=-7.��(-(�����) - 1)��
		*/
		
		System.out.println(Arrays.binarySearch(arr2,11));	
		System.out.println(Arrays.binarySearch(arr2,33));	
		System.out.println(Arrays.binarySearch(arr2,12));	//-2

		/*Ϊʲô��(-(�����) - 1)��
		1.(-(�����) - 1)��Ҫ���ߣ������Ԫ��Ҫ���������У�Ӧ�÷��ڵ�λ�ã�+1ȡ�������ǲ����
		2.ΪʲôҪ-1��
			System.out.println(Arrays.binarySearch(arr2,9));	//-1
			�����-1�����ҵ���-0�����ҵ���9�������е�λ����0����ô
		*/
	}
}
