package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6603 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n==0) break;
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = Integer.parseInt(st.nextToken());

            visited = new int[6];
            solve(arr,0,0);
            sb.append('\n');
        }
        System.out.println(sb);
    }// end of main

    static int[] visited;
    public static void solve(int[] arr,int cnt,int start) {
        if(cnt>=6) {
            for(int i=0;i<6;i++)
                sb.append(visited[i]).append(' ');
            sb.append('\n');
            return;
        }

        for(int i=start;i<arr.length;i++) {
            visited[cnt] = arr[i];
            solve(arr, cnt+1, i+1);
        }
    }

}// end of class