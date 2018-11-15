package baekjoon.q1000;

import java.util.Arrays;
import java.util.Scanner;

public class Q2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+10];
        Arrays.fill(dp,9999);
        dp[3] = 1;
        dp[5] = 1;
        // 3 짜리를 더해서 만들 수 있는 경우와
        // 5 짜리를 더해서 만들 수 있는 경우 중 작은 경우 선택
        for(int i=6;i<=n;i++)
            dp[i] = min(dp[i-3]+1,dp[i-5]+1);
        if(dp[n]==10000 || dp[n]==9999) System.out.println(-1);
        else System.out.println(dp[n]);
    }
    private static int min(int x,int y){return x>y?y:x;}
}
