package yuan.javaexper;

import java.util.Scanner;

public class two_research {
	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55,66,77};
		Scanner scanner = new Scanner(System.in);
		System.out.println("���������ѯ��ֵ");
		int nextInt = scanner.nextInt();
		System.out.println("��Ӧ�����������Ϊ,û�еĻ����-1\r\n"+getIndex(arr, nextInt));
		scanner.close();
	}
	public static int getIndex(int[] arr, int value) {
		int min = 0;
		int max = arr.length - 1;
		int mid = (min + max) / 2;

		while(arr[mid] != value) {		//���м�ֵ������Ҫ�ҵ�ֵ���Ϳ�ʼѭ������
			if(arr[mid] < value) {		//���м�ֵС����Ҫ�ҵ�ֵ
				min = mid + 1;		//��С�������ı�
			}else if(arr[mid] > value) {	//���м�ֵ������Ҫ�ҵ�ֵ
				max = mid - 1;		//���������ı�
			}

			mid = (min + max) / 2;		//�����������С�ı䣬�м�����������֮�ı�

			if(min > max) {			//�����С���������������������û�в��ҵĿ�������
				return -1;		//����-1
			}
		}

		return mid;
	}
}
