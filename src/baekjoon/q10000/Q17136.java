package baekjoon.q10000;

import java.io.*;
import java.util.*;
public class Q17136 {
    static final int N = 10;
    static int map[][];
    static final int INF = Integer.MAX_VALUE;
    static int res = INF;
    static int check[] = new int[6];
    static int count;
    static int[] arr = {0,1,4,9,16,25};

    static void delete(int r,int c,int size) {
        for(int i = r ; i < r+size ; i++) {
            for(int j = c ; j < c+size ; j++) {
                map[i][j] = 0;
            }
        }
        count -= arr[size];
    }

    static void add(int r,int c,int size) {
        for(int i = r ; i < r+size ; i++) {
            for(int j = c ; j < c+size ; j++) {
                map[i][j] = 1;
            }
        }
        count += arr[size];
    }

    static boolean isOk(int r,int c,int size) {
        for(int i = r ; i < r+size ; i++) {
            for(int j = c ; j < c+size ; j++) {
                if(i >= N || j >= N || map[i][j] == 0) return false;
            }
        }
        return true;
    }

    static void dfs(int cnt,int x,int y) {
        if(cnt > res) return;
        if(count==0) {
            res = res > cnt? cnt:res;
            return;
        }
        if(y>=10){
            dfs(cnt,x+1,0);
            return;
        }
        if(map[x][y]==0){
            dfs(cnt,x,y+1);
            return;
        }

        for(int i = 5 ; i >= 1 ; i--) {
            if(check[i] == 5) continue;
            if(isOk(x,y,i)) {
                check[i]++;
                delete(x,y,i);
                dfs(cnt+1,x,y+i);
                add(x,y,i);
                check[i]--;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) count++;
            }
        }
        dfs(0,0,0);
        if(res == INF) System.out.println(-1);
        else System.out.println(res);
    }// end of main
}// end of class