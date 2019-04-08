package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17086 {
    static int n,m;
    static int[][] arr,q;
    static int[] dx = {1,0,-1,0,1,-1,1,-1};
    static int[] dy = {0,1,0,-1,1,-1,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = new int[n*m+n+m][3];
        arr = new int[n+2][m+2];
        int front = 0,rear = 0;
        for(int i=1;i<=n;i++){
            String t = br.readLine();
            for(int j=1,k=0;j<=m;j++,k+=2){
                arr[i][j] = t.charAt(k);
                if(arr[i][j]=='1'){
                    q[++rear][0] = i;
                    q[rear][1] = j;
                    q[rear][2] = 0;
                }
            }
        }

        int max = 0;
        while(front<rear){
            int size = rear-front;
            for(int i=0;i<size;i++){
                int x = q[++front][0];
                int y = q[front][1];
                int cnt = q[front][2];
                max = max<cnt?cnt:max;
                ++cnt;

                for(int j=0;j<8;j++){
                    int tx = x+dx[j];
                    int ty = y+dy[j];
                    if(arr[tx][ty]=='0'){
                        arr[tx][ty] = cnt;
                        q[++rear][0] = tx;
                        q[rear][1] = ty;
                        q[rear][2] = cnt;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
