package swexpert.d4;

import java.io.*;
import java.util.StringTokenizer;

public class Q3752 {
    static int n;
    static int[] arr;
    static int sum,result;
    static boolean[] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for(int z=1;z<=tc;z++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            sum = 0;
            for(int i=0;i<n;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            dp = new boolean[sum+10];
            dp[0] = true;
            for(int i=0;i<n;i++){
                for(int j=sum;j>=0;j--){
                    if(dp[j]){
                        dp[j] = true;
                        dp[arr[i]+j] = true;
                    }
                }
            }
            result = 0;
            for(int i=0;i<=sum;i++)
                if(dp[i]) result++;
            System.out.println("#"+z+" "+result);
        }
    }
}
