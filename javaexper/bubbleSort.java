package yuan.javaexper;

public class bubbleSort {
	public static void main(String[] args) {
		int[] arr = {5,69,80,7,13};
		bubbleSort_(arr);
		print(arr);
	}
	public static void bubbleSort_(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {		//���ѭ�������Ƚϴ�����ֻ��Ҫ�Ƚ�arr.length-1�ξͿ�����
			for(int j = 0; j < arr.length - 1 - i; j++) {	//��ѭ������һ���ڱȽϵĴ�����-1��Ϊ�˷�ֹ����Խ��,-iΪ�����Ч��
				if(arr[j] > arr[j+1]) {
					/*int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j+1] = temp;*/

					swap(arr,j,j+1);
				}
			}
		}
	}
	public static void swap(int []a,int b,int c) {
		int temp=a[b];
		a[b]=a[c];
		a[c]=temp;
	}
	public static void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
