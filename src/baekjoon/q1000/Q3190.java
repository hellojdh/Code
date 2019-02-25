package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3190 {
    static int[] time;
    static int[][] arr;
    static int tailx,taily,d;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+2][n+2];
        time = new int[10001];
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i=0;i<k;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
        }
        // 꼬리칸
        tailx = 1; taily = 1;
        // 이동 경로 0 1 2 3 상 하 좌 우
        d = 3;
        int l = Integer.parseInt(br.readLine());
        for(int i=0;i<l;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            switch (st.nextToken()) {
                case "L": // 왼쪽으로 90도
                    time[t] = 1;
                    break;
                case "D": // 오른쪽으로 90도
                    time[t] = 2;
                    break;
            }
        }
        // 벽 또는 자기 자신과 부딪히면 끝.
        // 1,1 시작 뱀의 길이는 1
        // 처음에는 오른쪽 이동
        int[] qx = new int[10100];
        int[] qy = new int[10100];
        int fx = -1,fy = -1;
        int rx = -1,ry = -1;
        qx[++rx] = 1;
        qy[++ry] = 1;

        int result = 0;
        int len = 1; // 길이
        arr[1][1] = len;
        while(fx<rx) {
            result++;
            int x = qx[++fx];
            int y = qy[++fy];
            // 늘려보기
            int tx = x+dx[d];
            int ty = y+dy[d];
            if(tx<1 || ty<1 || tx>n || ty>n) break;

            if(time[result]==1) {
                switch (d) {
                    case 0:// 상->좌
                        d = 2;
                        break;
                    case 1:// 하->우
                        d = 3;
                        break;
                    case 2:// 좌->하
                        d = 1;
                        break;
                    case 3:// 우->상
                        d = 0;
                        break;
                }
            }else if(time[result]==2) {
                switch (d) {
                    case 0:// 상->우
                        d = 3;
                        break;
                    case 1:// 하->좌
                        d = 2;
                        break;
                    case 2:// 좌->상
                        d = 0;
                        break;
                    case 3:// 우->하
                        d = 1;
                        break;
                }
            }

            // 현 칸에서 한 칸 앞으로 일단 늘리기 이동
            // 이동한 칸에 사과가 있다면, 사과먹고 끝
            // 사관가 없다면 몸길이를 뒤에서 줄이기
            if(arr[tx][ty]==-1) {
                qx[++rx] = tx;
                qy[++ry] = ty;
                arr[tx][ty] = ++len;
                continue;
            }else if(arr[tx][ty]!=0){
                break;
            }else {
                arr[tx][ty] = ++len;
                for(int i=0;i<4;i++) {
                    int xx = tailx+dx[i];
                    int yy = taily+dy[i];
                    if(xx<1||yy<1||xx>n||yy>n) continue;
                    if(arr[xx][yy]-arr[tailx][taily]==1) {
                        arr[tailx][taily] = 0;
                        tailx = xx;
                        taily = yy;
                        break;
                    }
                }
            }

            qx[++rx] = tx;
            qy[++ry] = ty;

        }
        System.out.println(result);
    }// end of main

    static class Pair{
        int x,y,len;

        public Pair(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}// end of class