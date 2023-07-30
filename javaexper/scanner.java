package yuan.javaexper;

import java.util.Scanner;

public class scanner {
 public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String nextLine = scanner.nextLine();
	String[] split = nextLine.split(" ");
	for (int i = 0; i < split.length; i++) {
		if(isNum(split[i])) {
			System.out.println(Integer.parseInt(split[i]));
		}
		else {
			System.out.println(split[i]);
		}
	}
	scanner.close();
	
}
 public static boolean isNum(String a) {
		for (int j = 0; j < a.length(); j++) {
			if(!Character.isDigit(a.charAt(j))) 
				return false;
		}
		return true;
	}
}
