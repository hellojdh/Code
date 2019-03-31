package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13300 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 0;
        int[][] arr = new int[2][7];
        for(int z=0;z<n;z++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
        }

        for(int z=1;z<7;z++) {
            for(int i=0;i<2;i++) {
                result += arr[i][z]/k;
                result += arr[i][z]%k!=0?1:0;
            }
        }
        System.out.println(result);
    }// end of main
} // end of class