package baekjoon.q1000;

import java.util.Scanner;

public class Q2231 {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		// 최소를 출력해야 하므로 모든 1부터 모든 경우수를 봐보자
		for(int i=1;i<n;i++) {
			if(n==solve(String.valueOf(i))) {
				// 있다면 해당 수 출력 후 종료
				System.out.println(i);
				return;
			}
		}
		// 없다면 0 출력
		System.out.println(0);
	}
	
	private static int solve(String num) {
		int len = num.length();
		// 원래수 더하기
		int sum = Integer.parseInt(num);
		// 각 자리수 숫자 더하기
		for(int i=0;i<len;i++)
			sum += num.charAt(i)-'0';
		return sum;
	}
}
