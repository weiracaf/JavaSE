package yuan.lanqiao;


import java.time.LocalDateTime;
import java.util.HashSet;

@SuppressWarnings("all")

public class Main {
			public static void main(String[] args) {
    			int i = 1, j = 2, k = 3, m = 4;
  				boolean b;
  				if(b = i < j && k++ >= m) {
  					System.out.println(1);
  				}
  				System.out.println(b);
  				System.out.println(b = i < j);
   				System.out.println(k);
			 }
	}

      

