package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11727 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+5];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        n++;
        int t1 = 3;
        int t2 = 2;
        for(int i = 4; i < n; i++){
            dp[i] = (dp[t1++]+dp[t2++]*2)%10007;
        }
        System.out.println(dp[n-1]);
    }// end of main
}// end of class