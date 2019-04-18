package baekjoon.q10000;

import java.util.Scanner;

public class Q11726 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+5];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        for(int i = 5; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i]%=10007;
        }
        System.out.println(dp[n]);
    }// end of main
}// end of class
