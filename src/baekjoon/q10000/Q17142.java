package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17142 {
    static int n,m,front,rear,idx,total;
    static int[] save;
    static int[][] arr,copy,virus;
    static int[][] q = new int[2500][2];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        copy = new int[n][n];

        virus = new int[2500][2];
        save = new int[m];

        for(int i = 0; i < n; i++) {
            String t = br.readLine();
            for(int j = 0, k = 0; j < n; j++, k+=2) {
                arr[i][j] = t.charAt(k);
                // 2는 바이러스를 놓을 수 있는 위치
                if(arr[i][j]=='2') {
                    virus[idx][0] = i;
                    virus[idx++][1] = j;
                }
                if(arr[i][j]=='0') total++;
            }
        }
        comb(0,0);
        if(result == Integer.MAX_VALUE)
            result = -1;
        System.out.println(result);
    }// end of main

    public static void comb(int start,int cnt) {
        if(cnt==m) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    copy[i][j] = arr[i][j];
                }
            }
            bfs();
            return;
        }


        for(int i = start; i < idx; i++) {
            save[cnt] = i;
            comb(i+1,cnt+1);
        }
    }

    static int result = Integer.MAX_VALUE;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void bfs() {
        // copy에 있는 바이러스 퍼트리기
        front = 0;
        rear = 0;

        int time = 0;
        int tTotal = 0;
        for(int i = 0; i < m; i++) {
            q[++rear][0] = virus[save[i]][0];
            q[rear][1] = virus[save[i]][1];
            copy[q[rear][0]][q[rear][1]] = -1;
        }
        xx:		while(front<rear) {
            int size = rear-front;
            if(time>=result) return;
            if(tTotal==total) break;
            time++;
            for(int i = 0; i < size; i++) {
                int x = q[++front][0];
                int y = q[front][1];
                for(int j = 0; j < 4; j++) {
                    int tx = x+dx[j];
                    int ty = y+dy[j];
                    if(tx>=0 && ty>=0 && tx<n && ty<n&&(copy[tx][ty]=='0'||copy[tx][ty]=='2')) {
                        if(copy[tx][ty] == '0') {
                            tTotal++;
                            if(tTotal==total) break xx;
                        }
                        copy[tx][ty] = 0;
                        q[++rear][0] = tx;
                        q[rear][1] = ty;
                    }
                }
            }
        }
        if(tTotal==total)
            result = time;
    }
}// end of class