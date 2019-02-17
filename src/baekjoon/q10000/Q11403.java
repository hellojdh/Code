package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1 && !visited[i][j]) {
                    dfs(arr, i, j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                sb.append(arr[i][j]+" ");
            sb.append('\n');
        }
        System.out.println(sb);
    }// end of main

    static boolean[][] visited;
    public static void dfs(int[][] arr,int s,int e){
        arr[s][e] = 1;
        visited[s][e] = true;
        for(int i=0;i<arr.length;i++){
            if(arr[e][i]==1 && !visited[s][i])
                dfs(arr,s,i);
        }
    }
}// end of class