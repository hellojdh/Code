package baekjoon.q1000;

import java.util.Scanner;

public class Q4796 {
	static int l,p,v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true) {
			l = sc.nextInt(); // L일 동안
			p = sc.nextInt(); // 연속 P일중
			v = sc.nextInt(); // 휴가 V일
			// 0이 들어오면 종료
			if(l==0) break;
			// 최대로 이용할 수 있는 날을 따져주어야하므로
			// 우선 연속 P가 최대 몇 번오나 따져준 후 (v/p)
			// 남은 날 수(v%p)가 이용 가능일 L 모다 작으면 전부 이용 아니라면 L 만큼만 이용한다.
			System.out.println("Case "+tc+": "+((v/p)*l+Math.min(l,v%p)));
			tc++;
		}
	}
}
