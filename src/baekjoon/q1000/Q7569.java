package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q7569 {
    static int m,n,h;
    static int[][][] arr;
    static Queue<Pair> queue = new LinkedList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 상자 가로칸
        n = Integer.parseInt(st.nextToken()); // 세로
        h = Integer.parseInt(st.nextToken()); // height
        arr = new int[h][n][m];

        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k]==1) queue.add(new Pair(i,j,k));
                }
            }
        }

        solve();
    }

    static int[] dirH = {1,-1};
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static void solve(){
        int result = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            result++;
            for(int i=0;i<size;i++){
                Pair t = queue.poll();
                // 주변 토마토
                for(int j=0;j<4;j++){
                    int tx = t.n + dir[j][0];
                    int ty = t.m + dir[j][1];
                    if(tx<0 || ty<0 || tx>=n || ty>=m) continue;
                    if(arr[t.h][tx][ty]!=0) continue;
                    arr[t.h][tx][ty] = 1;
                    queue.add(new Pair(t.h,tx,ty));
                }
                // 위 아래 토마토
                for(int j=0;j<2;j++){
                    int th = t.h+dirH[j];
                    if(th<0 || th>=h) continue;
                    if(arr[th][t.n][t.m]!=0) continue;
                    arr[th][t.n][t.m] = 1;
                    queue.add(new Pair(th,t.n,t.m));
                }
            }
        }
        // 토마토가 남아있는지 탐색
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++) {
                    // 안 익은 토마토가 있다면 -1 출력
                    if(arr[i][j][k]==0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(result);
    }

    static class Pair{
        int h,n,m;
        Pair(int h,int n,int m){
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }
}