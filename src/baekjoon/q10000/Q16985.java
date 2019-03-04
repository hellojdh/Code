import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16985 {
    static int[][][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0은 참가자가 들어갈 수 없는칸, 1은 들어갈 수 있는 칸
        arr = new int[7][7][7];
        StringTokenizer st = null;

        for(int k=1;k<=5;k++) {
            for(int i=1;i<=5;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=1;j<=5;j++) {
                    arr[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // 돌리기 - 만들기 - 이동시켜보기
        // 1) 돌리기

        save = new int[5];
        save2 = new int[5];
        result = Integer.MAX_VALUE;
        solve(0);
        if(result==Integer.MAX_VALUE) result = -1;
        System.out.println(result);
    }// end of main

    static int sx,sy,ex,ey;
    static int result;
    static Pair[] q = new Pair[1000];
    static int tx1,tx2,ty1,ty2,th1,th2;
    public static void findShort() {
        int front = -1,rear = -1;
        q[++rear] = new Pair(sx, sy,1,0);
        copy[1][sx][sy] = 0;
        while(front<rear) {
            Pair t = q[++front];
            if(t.cnt>=result) break;
            if(t.h==5&&t.x==ex&&t.y==ey) {
                if(result>t.cnt) result = t.cnt;
                break;
            }
            // 상 하 좌 우 탐색
            tx1 = t.x-1; tx2 = t.x+1; ty1 = t.y-1; ty2 = t.y+1;
            if(copy[t.h][tx1][t.y]==1) {
                copy[t.h][tx1][t.y]=0;
                q[++rear] = new Pair(tx1, t.y, t.h, t.cnt+1);
            }

            if(copy[t.h][tx2][t.y]==1) {
                copy[t.h][tx2][t.y]=0;
                q[++rear] = new Pair(tx2, t.y, t.h, t.cnt+1);
            }

            if(copy[t.h][t.x][ty1]==1) {
                copy[t.h][t.x][ty1]=0;
                q[++rear] = new Pair(t.x, ty1, t.h, t.cnt+1);
            }

            if(copy[t.h][t.x][ty2]==1) {
                copy[t.h][t.x][ty2]=0;
                q[++rear] = new Pair(t.x, ty2, t.h, t.cnt+1);
            }

            // 위 아래 탐색
            th1 = t.h-1; th2 = t.h+1;
            if(copy[th1][t.x][t.y]==1) {
                copy[th1][t.x][t.y]=0;
                q[++rear] = new Pair(t.x, t.y, th1, t.cnt+1);
            }
            if(copy[th2][t.x][t.y]==1) {
                copy[th2][t.x][t.y]=0;
                q[++rear] = new Pair(t.x, t.y, th2, t.cnt+1);
            }
        }
    }

    static int[][][] copy = new int[7][7][7];
    public static void init() {
        // 판쌓는 순서는 자유롭게 정할수 있다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // 원배열 복사
        for(int k=1;k<=5;k++) {
            for(int i=1;i<=5;i++) {
                for(int j=1;j<=5;j++) {
                    copy[save2[k-1]][i][j] = arr[k][i][j];
                }
            }
        }

        // 돌리기로 한대로 돌리기
        for(int i=1;i<=5;i++) {
            int cnt = save[i-1];
            for(int j=0;j<cnt;j++) {
                // 판을 돌립시다.
                // 1. 3개짜리줄 돌리기
                int[] t = new int[7];
                for(int k=2;k<=4;k++)
                    t[k] = copy[i][2][k];
                // 왼 -> 윗줄
                for(int k=2;k<=4;k++)
                    copy[i][2][4-k+2] = copy[i][k][2];
                // 아래 -> 왼줄
                copy[i][3][2] = copy[i][4][3];
                copy[i][4][2] = copy[i][4][4];
                // 우 -> 아랫줄
                copy[i][4][3] = copy[i][3][4];
                copy[i][4][4] = t[4];
                // 위 -> 오른쪽
                copy[i][3][4] = t[3];
                copy[i][2][4] = t[2];


                // 2. 다섯개짜리 돌리기
                for(int k=1;k<=5;k++)
                    t[k] = copy[i][1][k];
                // 왼 -> 윗줄
                for(int k=1;k<=5;k++)
                    copy[i][1][6-k] = copy[i][k][1];
                // 아래 -> 왼
                copy[i][2][1] = copy[i][5][2];
                copy[i][3][1] = copy[i][5][3];
                copy[i][4][1] = copy[i][5][4];
                copy[i][5][1] = copy[i][5][5];
                // 우 -> 아랫
                copy[i][5][2] = copy[i][4][5];
                copy[i][5][3] = copy[i][3][5];
                copy[i][5][4] = copy[i][2][5];
                copy[i][5][5] = t[5];
                // 위 -> 우
                copy[i][4][5] = t[4];
                copy[i][3][5] = t[3];
                copy[i][2][5] = t[2];
            }
        }
        // 복사
        for(int k=1;k<=5;k++) {
            for(int i=1;i<=5;i++) {
                for(int j=1;j<=5;j++)
                    copy2[k][i][j] = copy[k][i][j];
            }
        }
        // 다 돌렸으니 출발 꼭지점 검사
        if(copy[1][1][1]==1&&copy[5][5][5]==1) {
            sx = 1;sy = 1;ex = 5; ey = 5;
            findShort();
            initcheck();
        }
    }

    static int[][][] copy2 = new int[7][7][7];
    public static void initcheck() {
        for(int k=1;k<=5;k++) {
            for(int i=1;i<=5;i++) {
                for(int j=1;j<=5;j++)
                    copy[k][i][j] = copy2[k][i][j];
            }
        }
    }

    // 판 위치 정하기
    static int[] save2;
    static boolean[] check = new boolean[6];
    public static void solve2(int cnt) {
        if(cnt==5) {
            // 미로 만들기
            init();
            return;
        }

        for(int i=1;i<=5;i++) {
            if(check[i]) continue;
            check[i] = true;
            save2[cnt] = i;
            solve2(cnt+1);
            check[i] = false;
        }
    }

    static int[] save;
    public static void solve(int cnt) {
        if(cnt==5) {
            solve2(0);
            return;
        }

        // 0, 1 한번 2 두번 3 세번
        for(int i=0;i<4;i++) {
            save[cnt] = i;
            solve(cnt+1);
        }
    }

    static class Pair{
        int h,x,y,cnt;
        public Pair(int x, int y, int h,int cnt) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.cnt = cnt;
        }
    }
}// end of class