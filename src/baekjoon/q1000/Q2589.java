package baekjoon.q1000;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2589 {
    static int n,m;
    static char[][] arr;
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new char[n][m];
        for(int i=0;i<n;i++){
            String t = sc.next();
            for(int j=0;j<m;j++)
                arr[i][j] = t.charAt(j);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='L') solve(i,j);
            }
        }
        System.out.println(result);
    }

    static int result;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static void solve(int x,int y){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x,y,0));
        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;
        while(!queue.isEmpty()){
            Pair t = queue.poll();
            result = max(result,t.cnt);
            for(int i=0;i<4;i++){
                int tx = t.x+dir[i][0];
                int ty = t.y+dir[i][1];
                if(tx<0 || ty<0 || tx>=n || ty>=m) continue;
                if(arr[tx][ty]=='W') continue;
                if(visited[tx][ty]) continue;
                visited[tx][ty]= true;
                queue.add(new Pair(tx,ty,t.cnt+1));
            }
        }
    }

    private static int max(int a,int b){return a>b?a:b;}
    static class Pair{
        int x,y,cnt;
        Pair(int x,int y,int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
