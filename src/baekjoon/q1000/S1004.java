package baekjoon.q1000;

import java.util.Scanner;

// 원 바깥 이냐 안쪽 이냐 판단( 반지름 > 두점 거리)
public class S1004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int cnt = 0;
		for(int i=0; i<n; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int iNum = sc.nextInt();
			cnt = 0;
			for(int j=0; j<iNum; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int r = sc.nextInt();
				
				int d1 = pow(x1-x)+pow(y1-y);
				int d2 = pow(x2-x)+pow(y2-y);
				
				if(d1 < pow(r)) {
					if(d2 > pow(r)) {
						cnt++;
					}
				}else {
					if(d2 < pow(r)) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
	
	public static int pow(int a) { return a*a;}
}