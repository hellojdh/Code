package programmers.level2;

public class 멀리뛰기 {
	public static void main(String[] args) {
		System.out.println(solution(3));
	}
	static int[] dp;
	public static long solution(int n) {
		dp = new int[n*2];
		return jump(n);
	}
	
	public static int jump(int n) {
		if(n < 0) return 0;
		if(dp[n] != 0) return dp[n];
		if(n == 0) return ++dp[n];
		return dp[n] = jump(n-1)+jump(n-2);
	}
}
