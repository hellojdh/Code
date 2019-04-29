package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        n+=3;
        int[] dp = new int[n];
        int[] arr = new int[n];
        int result = 0;
        for(int i = 3; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            dp[i] = Math.max(dp[i-2]+arr[i],Math.max(dp[i-3]+arr[i-1]+arr[i],dp[i-1]));
            if(dp[i]>result){
                result = dp[i];
            }
        }
        System.out.println(result);
    }// end of main
}// end of class