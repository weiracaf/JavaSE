package yuan.javaexper;

import java.util.Scanner;

public class two_research {
	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55,66,77};
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入你想查询的值");
		int nextInt = scanner.nextInt();
		System.out.println("对应在数组的索引为,没有的话输出-1\r\n"+getIndex(arr, nextInt));
		scanner.close();
	}
	public static int getIndex(int[] arr, int value) {
		int min = 0;
		int max = arr.length - 1;
		int mid = (min + max) / 2;

		while(arr[mid] != value) {		//当中间值不等于要找的值，就开始循环查找
			if(arr[mid] < value) {		//当中间值小于了要找的值
				min = mid + 1;		//最小的索引改变
			}else if(arr[mid] > value) {	//当中间值大于了要找的值
				max = mid - 1;		//最大的索引改变
			}

			mid = (min + max) / 2;		//无论最大还是最小改变，中间索引都会随之改变

			if(min > max) {			//如果最小索引大于了最大索引，就没有查找的可能性了
				return -1;		//返回-1
			}
		}

		return mid;
	}
}
