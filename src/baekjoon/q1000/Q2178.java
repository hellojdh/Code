package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2178 {
    static int n,m;
    static char[][] arr;
    static int[][] q;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        q = new int[n*m+1][2];
        for(int i = 0; i < n; i++){
            arr[i] = br.readLine().toCharArray();
        }

        int front = 0, rear = 0;
        q[++rear][0] = 0;
        q[rear][1] = 0;
        arr[0][0] = 0;

        int result = 0;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        n--;
        m--;
xx:     while(front<rear){
            int size = rear-front;
            result++;
            for(int j = 0; j < size; j++) {
                int x = q[++front][0];
                int y = q[front][1];
                for (int i = 0; i < 4; i++) {
                    int tx = x + dx[i];
                    int ty = y + dy[i];
                    if(tx<0 || ty<0 || tx>n || ty>m) continue;
                    if (arr[tx][ty] == '1') {
                        arr[tx][ty] = 0;
                        q[++rear][0] = tx;
                        q[rear][1] = ty;
                        if(tx==n&&ty==m){
                            break xx;
                        }
                    }
                }
            }
        }
        System.out.println(++result);
    }// end of main
}// end of class