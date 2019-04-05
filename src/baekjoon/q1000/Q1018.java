package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            String t = br.readLine();
            for(int j=0;j<m;j++)
                arr[i][j] = t.charAt(j);
        }

        for(int i=0;i<=n-8;i++){
            for(int j=0;j<=m-8;j++){
                solve(i,j,arr);
            }
        }
        System.out.println(result);
    }// end of main

    static int result = Integer.MAX_VALUE;
    private static void solve(int x,int y,int[][] arr){
        // W로 칠해볼 때
        int t = 'W';
        int tt = 'B';
        int cnt = 0;
        int cnt2 = 0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(t!=arr[i+x][j+y]) cnt++;
                if(tt!=arr[i+x][j+y]) cnt2++;
                if(j==7) break;

                if(t=='W') t='B';
                else t='W';

                if(tt=='W') tt='B';
                else tt='W';
            }
        }
        result = min(result,cnt);
        result = min(result,cnt2);
    }
    private static int min(int x,int y){return x>y?y:x;}
}// end of class