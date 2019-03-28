package swexpert.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7258 {
    static int n,m;
    static int[][] arr = new int[20][20];
    static boolean[][][][] visited = new boolean[20][20][4][16];
    static int[][] q = new int[30000][4];
    // 상 하 좌 우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int z=1;z<=tc;z++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            // 방문배열 초기화
            init();
            // 방향에 따라 방문체크를 해주자.
            for(int i=0;i<n;i++) {
                String t = br.readLine();
                for(int j=0;j<m;j++) {
                    arr[i][j] = t.charAt(j);
                }
            }

            // 처음 시작은 좌 상단, 이동 방향은 오른쪽
            int front = -1,rear = -1;
            q[++rear][0] = 0;
            q[rear][1] = 0;
            // 상 하 좌 우(3)
            q[rear][2] = 3;
            q[rear][3] = 0;
            visited[0][0][3][0] = true;
            boolean exit = false;
xx:			while(front<rear) {
                int x = q[++front][0];
                int y = q[front][1];
                int tdir = q[front][2];
                int tMemory = q[front][3];
                switch (arr[x][y]) {
                    case '<':
                        tdir = 2;
                        break;
                    case '>':
                        tdir = 3;
                        break;
                    case '^':
                        tdir = 0;
                        break;
                    case 'v':
                        tdir = 1;
                        break;
                    case '_':
                        if(tMemory==0) tdir = 3;
                        else tdir = 2;
                        break;
                    case '|':
                        if(tMemory==0) tdir = 1;
                        else tdir = 0;
                        break;
                    case '?': // 이동 방향을 상 하 좌 우 무작위로 바꾼다.
                        for(int i=0;i<4;i++) {
                            if(visited[x][y][i][tMemory]) continue;
                            q[++rear][0] = x;
                            q[rear][1] = y;
                            q[rear][2] = i;
                            visited[x][y][i][tMemory] = true;
                        }
                        break;
                    case '.':
                        break;
                    case '@':
                        exit = true;
                        break xx;
                    case '+':
                        tMemory = tMemory==15?0:tMemory+1;
                        break;
                    case '-':
                        tMemory = tMemory==0?15:tMemory-1;
                        break;
                    default:
                        tMemory = arr[x][y]-'0';
                        break;
                }
                // 이동 시키기
                int tx = x+dx[tdir];
                int ty = y+dy[tdir];
                // 범위를 벗어나면 반대편으로!
                if(tx<0) tx = n-1;
                else if(tx>=n) tx = 0;
                else if(ty<0) ty = m-1;
                else if(ty>=m) ty = 0;
                // 가능한 이동이라면 q에 넣어주기
                if(!visited[tx][ty][tdir][tMemory]) {
                    visited[tx][ty][tdir][tMemory] = true;
                    q[++rear][0] = tx;
                    q[rear][1] = ty;
                    q[rear][2] = tdir;
                    q[rear][3] = tMemory;
                }
            }// end of while:xx
            sb.append('#').append(z).append(' ');
            if(exit) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }// end of main

    public static void init() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                for(int k=0;k<4;k++) {
                    for(int z=0;z<16;z++) {
                        visited[i][j][k][z] = false;
                    }
                }
            }
        }
    }
}// end of class