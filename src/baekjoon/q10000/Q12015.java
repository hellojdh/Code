package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] dp = new int[n+1];

        dp[0] = Integer.MIN_VALUE;
        int idx = 0;
        xx:        for(int i = 0; i < n; i++){
            int t = Integer.parseInt(st.nextToken());
            if(dp[idx]>=t){
                // 위치를 찾아주자.
                int left = 0, right = idx;
                int mid = 0;
                while(left<=right){
                    mid = (left+right)/2;

                    if(dp[mid] < t){
                        left = mid+1;
                    }else if(dp[mid]==t){
                        continue xx;
                    }else{
                        right = mid-1;
                    }
                }
                if(dp[mid]<t)
                    dp[mid+1] = t;
                else
                    dp[mid] = t;
            }else{
                dp[++idx] = t;
            }
//            System.out.println(Arrays.toString(dp)+"    ");
        }
        System.out.println(idx);
    }// end of main
}// end of class