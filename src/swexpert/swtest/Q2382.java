package swexpert.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2382 {
	static int n,m,k;
    static int[][][] visited;
    static int[][] arrM,arrN,arrD;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        visited = new int[100][100][1001];
        arrN = new int[100][100];
        arrD = new int[100][100];
        arrM = new int[100][100];
        for(int i=1;i<=tc;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            // 미생물 받기
            Pair[] live = new Pair[k];
            for(int j=0;j<k;j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                live[j] = new Pair(x, y, n, d,0);
            }
            sb.append("#"+i+" "+solve(live)+"\n");
        }
        System.out.print(sb);
    }
    
    private static int solve(Pair[] live) {
        Queue<Pair> queue = new LinkedList<>();
        // queue 넣어주기 & 배열에 미생물 넣기
        for(int i=0;i<k;i++) {
            queue.add(live[i]);
            visited[live[i].x][live[i].y][0]++;
        }
        int result = 0;
        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            // 현 좌표가 1보다 크다면 부딪혀있는것. & 이동안한것 거르기.
            if(visited[t.x][t.y][t.time]>1) {
                if(t.n>arrM[t.x][t.y]) {
                    arrN[t.x][t.y] += t.n;
                    arrD[t.x][t.y] = t.d;
                    arrM[t.x][t.y] = t.n;
                }else arrN[t.x][t.y] += t.n;
                visited[t.x][t.y][t.time]--;
                continue;
            }else {
                if(t.n<arrM[t.x][t.y]) {
                    t.d = arrD[t.x][t.y];
                    t.n += arrN[t.x][t.y];
                }else {
                    t.n += arrN[t.x][t.y];
                }
                init(t.x,t.y,t.time);
            }
            if(t.time==m) {
                result += t.n;
                // 다음 예제 사용을 위한 초기화
                init(t.x, t.y, t.time);
                continue;
            }
            int tx = t.x, ty = t.y;
            switch(t.d) {
            case 1: tx-=1; break; // 상
            case 2: tx+=1; break; // 하
            case 3: ty-=1; break; // 좌
            case 4: ty+=1; break; // 우
            }
            // 경계 면이라면 방향을 바꿔준 후, 생물 수 /2
            if(tx==0 || ty==0 || tx==n-1 || ty==n-1) {
                // 방향 바꿔주기
                switch(t.d) {
                case 1: t.d=2; break;
                case 2: t.d=1; break;
                case 3: t.d=4; break;
                case 4: t.d=3; break;
                }
                // 생물 수 /2
                t.n /=2;
                if(t.n==0) {
                    visited[t.x][t.y][t.time]--;
                    continue;
                }
            }
            // 방향과 미생물 수를 바꿔주었으니 다음 칸으로 이동.
            init(t.x,t.y,t.time);
            visited[tx][ty][t.time+1]++;
            queue.add(new Pair(tx, ty, t.n, t.d, t.time+1));
        }
        return result;
    }
    
    private static void init(int x,int y,int time) {
        arrN[x][y] = 0;
        arrD[x][y] = 0;
        arrM[x][y] = 0;
        visited[x][y][time] = 0;
    }
    
    static class Pair{
        private int x,y,n,d,time;
        public Pair(int x,int y,int n,int d,int time) {
            this.x=x;
            this.y=y;
            this.n=n;
            this.d=d;
            this.time=time;
        }
    }
}
