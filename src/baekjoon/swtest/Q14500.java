package baekjoon.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {
	static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[n][m];
        
        // 점을 기준으로 4개 충족 구하기(solve1)
        // 구하기 힘든 모양 직접 구하기(solve2)
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                solve(arr,i,j,1,arr[i][j]);
                solve2(arr,i,j);
            }
        }
        System.out.println(result);
    }
    static boolean[][] visited;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int result = 0;
    private static void solve(int[][] arr,int x,int y,int idx,int sum) {
        if(idx==4) {
            result = Math.max(result, sum);
            return;
        }
        if(idx>4) return;
        visited[x][y] = true;
        for(int i=0;i<4;i++) {
            int tx = x+dir[i][0];
            int ty = y+dir[i][1];
            if(tx<0 || ty<0 || tx>=n || ty>=m) continue;
            if(visited[tx][ty]) continue;
            solve(arr,tx,ty,idx+1,sum+arr[tx][ty]);
        }
        visited[x][y] = false;
    }
    // ㅜ ㅏ ㅗ ㅓ
    static int[][][] shape = {{{0,0},{0,1},{0,2},{1,1}}
                             ,{{0,0},{1,0},{2,0},{1,1}}
                             ,{{0,0},{0,1},{0,2},{-1,1}}
                             ,{{0,0},{2,0},{1,0},{1,-1}}};
    
    private static void solve2(int[][] arr,int x,int y) {
        for(int i=0;i<4;i++) {
            int sum = 0;
            for(int j=0;j<4;j++) {
                int tx = x + shape[i][j][0];
                int ty = y + shape[i][j][1];
                if(tx<0 || ty<0 || tx>=n || ty>=m) break;
                sum += arr[tx][ty];
            }
            result = Math.max(result, sum);
        }
    }
}
