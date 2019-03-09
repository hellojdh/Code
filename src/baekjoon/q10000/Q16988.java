package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q16988 {
    static int n,m;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());//행
        m = Integer.parseInt(st.nextToken());//열
        arr = new int[n][m];
        visited = new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        // 1은 나의돌 , 2는 상대돌
        result = 0;
        solve(0,0,0);
        System.out.println(result);
    }// end of main


    static int result = 0;
    static int front = -1,rear = -1;
    static Pair[] q = new Pair[500];
    static int[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] save = new int[2][2];
    public static void solve(int cnt,int x,int y) {

        // 2개를 골랐다면
        if(cnt==2) {
            // 방문배열 초기화
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    visited[i][j] = 0;
                }
            }
            int dollCnt = 0, tmpDoll = 0;
            for(int z=0;z<2;z++) {
                // 검사하기
                int tx = save[z][0];
                int ty = save[z][1];
                // 놓은곳을 기준으로 4방향 탐색해서 2이면서 갈 수 이쓰면 가기
                for(int i=0;i<4;i++) {
                    int ttx = tx+dx[i];
                    int tty = ty+dy[i];
                    if(ttx<0 || tty<0 || ttx>=n || tty>=m) continue;
                    // 2 && 방문 안한 곳이라면 탐색 시작!!
                    if(arr[ttx][tty]==2&&visited[ttx][tty]==0) {
                        tmpDoll = 0;
                        front = -1; rear = -1;
                        q[++rear] = new Pair(ttx, tty);
                        visited[ttx][tty] = 1;
                        tmpDoll++;
                        while(front<rear) {
                            Pair t = q[++front];
                            for(int k=0;k<4;k++) {
                                int tttx = t.x+dx[k];
                                int ttty = t.y+dy[k];
                                if(tttx<0||ttty<0||tttx>=n||ttty>=m) continue;
                                if(visited[tttx][ttty]==1) continue;
                                // 0을 만나면 안되는 케이스
                                if(arr[tttx][ttty]==0) {
                                    tmpDoll = -500;
                                }
                                // 2를 만나면 진행해 준다.
                                if(arr[tttx][ttty]==2) {
                                    visited[tttx][ttty] = 1;
                                    tmpDoll++;
                                    q[++rear] = new Pair(tttx, ttty);
                                }
                            }
                        }// end of bfs
                        if(tmpDoll>0) dollCnt+=tmpDoll;
                        result = result<dollCnt?dollCnt:result;
                    }
                }// end of find 2
            }// end of two
            return;
        }
        if(x==n) {
            return;
        }

        // 열이 끝에 도달하면
        if(y==m) {
            // 다음 줄로 보내기
            solve(cnt, x+1, 0);
            return;
        }

        // 놓을 수 있는 곳이면 이번 좌표 선택
        if(arr[x][y]==0) {
            arr[x][y] = 1;
            save[cnt][0] = x;
            save[cnt][1] = y;
            solve(cnt+1, x, y+1);
            arr[x][y] = 0;
        }
        // 이번 좌표 미선택
        solve(cnt, x, y+1);
    }

    static class Pair{
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}// end of class