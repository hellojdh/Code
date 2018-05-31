package baekjoon.q1000;

import java.util.Scanner;

// 피보나치 다이나믹
public class S1003 {
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();

		int num = 0;
		for(int i=0; i<n; i++) {
			num = sc.nextInt();
			dp = new int[num+1][2];
			fibonacci(num);
			System.out.println(dp[num][0]+" "+dp[num][1]);
		}
		sc.close();
	}
	public static int[] fibonacci(int n) {
		if(dp[n][0] != 0 || dp[n][1] != 0)
			return dp[n];
		if(n == 0) {
			dp[n][0] += 1;
			return dp[n];
		}
		if(n == 1) {
			dp[n][1] += 1;
			return dp[n];
		}
		int[] temp = fibonacci(n-1);
		dp[n][0] += temp[0];
		dp[n][1] += temp[1];
		temp = fibonacci(n-2);
		dp[n][0] += temp[0];
		dp[n][1] += temp[1];		
		return dp[n];
	}
}