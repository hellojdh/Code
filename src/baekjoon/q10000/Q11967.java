package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q11967 {
    static int n,m;
    static int[][] arr;
    static int[][] q = new int[10500][2];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+2][n+2];
        int[][] visited = new int[n+2][n+2];
        List<Integer>[][] save = new ArrayList[n+2][n+2];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                save[i][j] = new ArrayList<>();
            }
        }
        int result = 1;
        arr[1][1] = 1;
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            save[x][y].add(a);
            save[x][y].add(b);
        }

        int curX = 1;
        int curY = 1;
        int front = -1,rear = -1;
        q[++rear][0] = curX;
        q[rear][1] = curY;
        arr[curX][curY] = 1;
        int size = save[1][1].size();
        for(int i=0;i<size;i+=2) {
            int x = save[1][1].get(i);
            int y = save[1][1].get(i+1);
            if(arr[x][y]==0) {
                result++;
                arr[x][y]=1;
            }
        }
        int check = 0;
        boolean flag = true;
        xx:		while(true) {
            front = -1;
            rear = -1;
            q[++rear][0] = 1;
            q[rear][1] = 1;
            check++;
            visited[1][1] = check;
            flag = true;
            while(front<rear) {
                int xx = q[++front][0];
                int yy = q[front][1];
                for(int k=0;k<4;k++) {
                    int tx = xx+dx[k];
                    int ty = yy+dy[k];
                    if(arr[tx][ty]!=0&&visited[tx][ty]!=check) {
                        visited[tx][ty] = check;
                        size = save[tx][ty].size();
                        for(int i=0;i<size;i+=2) {
                            int x = save[tx][ty].get(i);
                            int y = save[tx][ty].get(i+1);
                            if(arr[x][y]==0) {
                                result++;
                                arr[x][y]=1;
                                flag = false;
                            }
                        }
                        if(!flag) continue xx;
                        q[++rear][0] = tx;
                        q[rear][1] = ty;
                    }
                }
            }
            if(flag) break;
        }// end of while(front<rear)
        System.out.println(result);
    }// end of main
}// end of class