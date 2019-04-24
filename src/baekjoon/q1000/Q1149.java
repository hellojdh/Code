package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr[0][0] = a;
        arr[0][1] = b;
        arr[0][2] = c;

        // 최솟값을 찾는것
        for(int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr[i][0] = min(arr[i-1][1],arr[i-1][2])+a;
            arr[i][1] = min(arr[i-1][0],arr[i-1][2])+b;
            arr[i][2] = min(arr[i-1][0],arr[i-1][1])+c;
        }
        n--;
        System.out.println(min(arr[n][0],min(arr[n][1],arr[n][2])));
    }// end of main

    public static int min(int a,int b){return a<b?a:b;}
}// end of class