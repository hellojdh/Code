package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+2][n+2];
        for(int i=1;i<=n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=n;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int result = 1;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int[] queueX = new int[10010];
        int[] queueY = new int[10010];
        for(int z=0;;z++) {
            int frontX = -1,rearX = -1;
            int frontY = -1,rearY = -1;
            int cnt = 0;
            boolean[][] visited = new boolean[n+2][n+2];
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    if(arr[i][j]>z&&!visited[i][j]) {
                        cnt++; // 안전 영역 증가
                        queueX[++rearX] = i;
                        queueY[++rearY] = j;
                        visited[i][j] = true;
                        while(frontX<rearX) {
                            int x = queueX[++frontX];
                            int y = queueY[++frontY];

                            for(int k=0;k<4;k++) {
                                int tx = x+dir[k][0];
                                int ty = y+dir[k][1];
                                if(arr[tx][ty]>z&&!visited[tx][ty]) {
                                    visited[tx][ty] = true;
                                    queueX[++rearX] = tx;
                                    queueY[++rearY] = ty;
                                }
                            }
                        }
                    }
                }
            }// end of search
            if(cnt==0) break;
            if(result<cnt) result = cnt;
        }
        System.out.println(result);
    }// end of main
}// end of class