package yuan.javaexper;

import java.util.Arrays;

public class Array_ {
	public static void main(String[] args) {
		int[] arr = {33,22,11,44,66,55};
		System.out.println(Arrays.toString(arr));	//[33,22,11,44,66,55]

		Arrays.sort(arr);	//排序
		System.out.println(Arrays.toString(arr));	//[11,22,33,44,55,66]

		int[] arr2 = {11,22,33,44,55,66};
		System.out.println(Arrays.binarySearch(arr2,22));	//1
		System.out.println(Arrays.binarySearch(arr2,66));	//5
		System.out.println(Arrays.binarySearch(arr2,88));	//-7
		/* 为什么输出的是-7？
			如果它包含在数组中，则返回搜索键的索引；否则返回 (-(插入点) - 1)。
			插入点 被定义为将键插入数组的那一点：即第一个大于此键的元素索引，
				如果数组中的所有元素都小于指定的键，则为 a.length。
			注意：这保证了当且仅当此键被找到时，返回的值将 >= 0。
		分析元素88：
			如果88要放在数组中，应该放在索引为6的位置，-6-1=-7.即(-(插入点) - 1)。
		*/
		
		System.out.println(Arrays.binarySearch(arr2,11));	
		System.out.println(Arrays.binarySearch(arr2,33));	
		System.out.println(Arrays.binarySearch(arr2,12));	//-2

		/*为什么是(-(插入点) - 1)？
		1.(-(插入点) - 1)是要告诉，如果该元素要放在数组中，应该放在的位置：+1取正，就是插入点
		2.为什么要-1？
			System.out.println(Arrays.binarySearch(arr2,9));	//-1
			如果不-1，查找到是-0，查找的是9在数组中的位置是0合适么
		*/
	}
}
