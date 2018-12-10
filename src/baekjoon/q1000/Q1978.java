package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1978 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        // 1은 소수가 아니다
        arr[1] = 1;
        // 에라토스테네스 체(미리 구해놓기)
        for(int i=2;i<=1000;i++){
            for(int j=2;i*j<=1000;j++)
                arr[i*j]=1;
        }

        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int t = Integer.parseInt(st.nextToken());
            if(arr[t]==0) result++;
        }
        System.out.println(result);
    }
}
