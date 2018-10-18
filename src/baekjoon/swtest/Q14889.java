package baekjoon.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889 {
	static int[][] arr;
    static int n,sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n];
        min = Integer.MAX_VALUE;
        solve("",0,0);
        System.out.println(min);
    }
    
    static boolean[] visited;
    static int min;
    private static void solve(String left,int lCnt,int idx) {
        if(lCnt==n/2) {
            int leftSum = 0;
            int rightSum = 0;
            
            int[] arr2 = new int[n/2];
            int[] arr3 = new int[n/2];
            int idxL = 0;
            int idxR = 0;
            for(int i=0;i<n;i++) {
                if(visited[i])
                    arr2[idxL++] = i;
                else
                    arr3[idxR++] = i;
            }
            for(int i=0;i<n/2;i++) {
                for(int j=i+1;j<n/2;j++) {
                    leftSum += arr[arr2[i]][arr2[j]];
                    leftSum += arr[arr2[j]][arr2[i]];
                    rightSum += arr[arr3[i]][arr3[j]];
                    rightSum += arr[arr3[j]][arr3[i]];
                }
            }
            min = Math.min(min, Math.abs(rightSum-leftSum));
            return;
        }
        if(lCnt>n/2) return;
        for(int i=idx;i<n;i++) {
            if(visited[i]) continue;
            visited[i] = true;
            solve(left+" "+i,lCnt+1,i);
            visited[i] = false;
        }
    }
}
