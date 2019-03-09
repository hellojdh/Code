package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16920 {
    static int n,m,p;
    static int[] s;
    static int[] result;
    static int[] front = new int[10];
    static int[] rear = new int[10];
    static Pair[][] q = new Pair[10][1000001];
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        s = new int[p+1];
        result = new int[p+1];

        for(int i=1;i<=p;i++)
            s[i] = Integer.parseInt(st.nextToken());

        arr = new int[n+2][m+2];
        int total = n*m; // 가능한 부지 개수
        for(int i=1;i<=n;i++) {
            String t = br.readLine();
            for(int j=1;j<=m;j++) {
                arr[i][j] = t.charAt(j-1);
                // 성 개수 올리기
                if(arr[i][j]!='.'&&arr[i][j]!='#') {
                    total--;
                    int tt = arr[i][j]-'0';
                    result[tt]++;
                    // 해당 큐에 넣어주기
                    q[tt][++rear[tt]] = new Pair(i, j, 0);
                }
                if(arr[i][j]=='#') total--;
            }
        }

        int tmp = 0;
        while(total>0) {
            if(tmp==total) break;
            tmp = total;
            // 순차적으로 돈다.
            for(int i=1;i<=p;i++) {
                // 해당 큐(끄트머리가 들어있다)에 들어있는걸 빼서 본 큐에 넣어주기
                int r = -1; // 본 큐 초기화
                // 본 큐 탐색
                while(front[i]<rear[i]){
                    Pair t = q[i][++front[i]];
                    // s만큼 펼쳤다면 끄트머리니깐 다시 본큐에 넣주기
                    if(t.cnt==s[i]) {
                        // 끄트머리에서 나아갈 수 있는 칸이면 넣어주기
                        t.cnt = 0;
                        q[i][++r] = t;
                        continue;
                    }

                    // 갈 수 있다면 4방향 탐색
                    for(int k=0;k<4;k++) {
                        int tx = t.x+dx[k];
                        int ty = t.y+dy[k];
                        if(arr[tx][ty]=='.') {
                            arr[tx][ty] = i;
                            result[i]++;
                            total--;
                            q[i][++rear[i]] = new Pair(tx, ty, t.cnt+1);
                        }
                    }
                }
                // 끝나면 front rear 초기화
                rear[i] = r;
                front[i] = -1;
                if(total==0) break;
            }// end of for(p)
        }// end of while(total)
        for(int i=1;i<=p;i++)
            sb.append(result[i]).append(' ');
        System.out.println(sb);
    }// end of main

    static class Pair{
        int x,y,cnt;
        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}// end of class