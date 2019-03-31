package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q17103 {
    static int n,tc,idx;
    static boolean[] arr;
    static int[] arr2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        tc = Integer.parseInt(br.readLine());
        arr =new boolean[1000001];
        arr2 = new int[500001];

        for(int i=2;i*i<1000001;i++){
            if(arr[i]) continue;
            for(int j=i*i;j<1000001;j+=i){
                arr[j] = true;
            }
        }

        for(int i=2; i<=500000; i++){
            if(!arr[i]) arr2[idx++] = i;
        }

        for(int i=0;i<tc;i++){
            n = Integer.parseInt(br.readLine());
            int end = n/2;
            int cnt = 0;
            for(int j=0;j<idx&&arr2[j]<=end;j++){
                if(!arr[n-arr2[j]]){
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }// end of tc
        System.out.println(sb);
    }// end of main
}// end of class