package swexpert.swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1952_DP {
    static int n;
    static int[] arr = new int[4];
    static int[] arr2 = new int[13];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine().trim());
        for(int z=1;z<=tc;z++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            // 1일, 1달, 3달, 1년
            for(int i=0;i<4;i++)
                arr[i] = Integer.parseInt(st.nextToken());

            // 1월 ~ 12월
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<13;i++)
                arr2[i] = Integer.parseInt(st.nextToken());

            int[] dp = new int[13];
            dp[0] =0;
            for(int i=1;i<=12;i++) {
                dp[i] = min(arr[0]*arr2[i],arr[1])+dp[i-1];
                if(i-3>=0) {
                    dp[i] = min(dp[i],dp[i-3]+arr[2]);
                }
            }
            if(dp[12]>arr[3]) dp[12] = arr[3];
            sb.append('#').append(z).append(' ').append(dp[12]).append('\n');
        }// end of tc
        System.out.println(sb);
    }// end of main

    public static int min(int a,int b) {return a>b?b:a;}
} // end of class