package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {
    static int n,m;
    static int[][] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) queue.add(new Pair(i,j));
            }
        }
        System.out.println(solve());
    }

    static Queue<Pair> queue = new LinkedList<>();
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static int solve(){
        int result = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            result++;
            for(int i=0;i<size;i++){
                Pair t = queue.poll();
                for(int j=0;j<4;j++){
                    int tx = t.x+dir[j][0];
                    int ty = t.y+dir[j][1];
                    if(tx<0 || ty<0 || tx>=n || ty>=m) continue;
                    if(arr[tx][ty]!=0) continue;
                    // 익은 토마토로 만들어주기(방문 표시)
                    arr[tx][ty] = 1;
                    queue.add(new Pair(tx,ty));
                }
            }
        }
        // 익지 않은 토마토가 있나 찾기
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                if(arr[i][j]==0) return -1;
        }
        return result;
    }

    static class Pair{
        int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
