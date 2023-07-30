package yuan.lanqiao;

import java.util.Scanner;
@SuppressWarnings({"all"})
public class ≈≈¡––Œ√∂æŸ {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int num=0;
		switch (k) {
		case 2:
			for (int i = 1; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					if(i+j==n) {
						num++;
						break;
					}
					if (i+j>n) {
						break;
					}
				}
			}
			break;
		case 3:
			for (int i = 1; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					for (int j2 = j+1; j2 < n; j2++) {
						if(i+j+j2==n) {
							num++;
							break;
						}
						if (i+j+j2>n) {
							break;
						}
					}
				}
			}
			break;
		case 4:
			for (int i = 1; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					for (int j2 = j+1; j2 < n; j2++) {
						for (int l = j2+1; l < n; l++) {
							if(i+j+j2+l==n) {
								num++;
								break;
							}
							if(i+j+j2+l>n)
								break;
						}
					}
				}
			}
			break;
			
		case 5:
			for (int i = 1; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					for (int j2 = j+1; j2 < n; j2++) {
						for (int l = j2+1; l < n; l++) {
							for (int l2 = l+1; l2 < args.length; l2++) {
								
								if(i+j+j2+l+l2==n) {
									num++;
									break;
								}
								if(i+j+j2+l+l2>n)
									break;
							}
						}
					}
				}
			}
			break;
		case 6:
			for (int i = 1; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					for (int j2 = j+1; j2 < n; j2++) {
						for (int l = j2+1; l < n; l++) {
							for (int l2 = l+1; l2 < args.length; l2++) {
								for (int m = l2+1; m < args.length; m++) {
									if(i+j+j2+l+l2+m==n) {
										num++;
										break;
									}
									if(i+j+j2+l+l2+m>n) {
										break;
									}
								}
							}
						}
					}
				}
			}
			break;
		}
		System.out.println(num);
	}
	

}
