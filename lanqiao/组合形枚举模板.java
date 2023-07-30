package yuan.lanqiao;

import java.util.ArrayList;
import java.util.Scanner;

public class 组合形枚举模板 {
	static int n;
	static int m;//选m个数
	static ArrayList<Integer> chosen = new ArrayList();
	static void calc(int x) {
		if(chosen.size()>m||chosen.size()+(n-x+1)<m)
			return;
		if(x==n+1) {
		for (int i = 0; i < chosen.size(); i++) {
		System.out.print(chosen.get(i)+" ");	
		}
		System.out.print(" ");
		return;
		}
		calc(x+1);
		chosen.add(x);
		calc(x+1);
		chosen.remove((Object)x);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		 n = scanner.nextInt();
		 m = scanner.nextInt();
		 calc(1);
	}

}
