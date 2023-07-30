package yuan.javaexper;

public class SelectSort_ {
	public static void main(String[] args) {
		int[] arr = {24,69,80,57,13};
		selectSort(arr);
		print(arr);
	}
	public static void selectSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {		//只需要比较arr.length-1次
			for(int j = i + 1;j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					/*int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;*/
					
					swap(arr,i,j);
				}
			}
		}
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
}
}
