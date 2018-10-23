package baekjoon.q1000;

import java.util.Scanner;

public class Q6064 {
	static int n,m,x,y;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=0;i<tc;i++) {
			m = sc.nextInt(); // <m:n>
			n = sc.nextInt();
			x = sc.nextInt(); // <x:y> 가 유효한지 판단.
			y = sc.nextInt();
			
			solve();
		}
	}
	
	private static void solve() {
		int result = y; // y값으로 고정
		// <m:n> <x:y>
		int tx = 0;
		// 첫 x값 적용
		if(m>=y) tx = y;
		else tx = y%m;

		// 딱 맞는 경우
		if(tx==0) tx=m;
		// 다시 tx로 돌아오면 안되는 경우.
		int start = tx;
		// y를 한 바퀴씩 돌리기
		for(int j=y;;j+=n) {
			if(tx==x) {
				System.out.println(j);
				break;
			}
			tx +=n;
			tx = tx%m;
			// 0 인경우는 똑같은 경우
			if(tx==0) tx=m;
			if(tx==start) {
				System.out.println(-1);
				break;
			}
		}
	}
}
