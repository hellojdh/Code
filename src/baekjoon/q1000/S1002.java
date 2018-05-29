package baekjoon.q1000;

import java.util.Scanner;

public class S1002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		for(int i=0; i<n; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			double dist = Math.sqrt(pow(x2-x1)+pow(y2-y1));
			int max = Math.max(r1, r2);
			int min = Math.min(r1, r2);

			// 똑같을 경우
			if(x1 == x2 && y1 == y2 && r1 == r2) System.out.println(-1);
			// 똑같은데 반지름이 다를경우
			else if(x1 == x2 && y1 == y2 && r1 != r2) System.out.println(0);
			// 내부
			else if(dist < max) {
				// 내접				
				if(dist +min > max) System.out.println(2);
				else if(dist+min == max) System.out.println(1);
				else System.out.println(0);
			}
			// 외부
			else {
				if(dist == r1+r2) System.out.println(1);
				else if(dist > r1+r2) System.out.println(0);
				else System.out.println(2);
			}
		}
		sc.close();
	}	
	public static int pow(int a) { return a*a;}
}