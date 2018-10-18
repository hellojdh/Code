package baekjoon.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14503 {
	static int[][] arr;
    static int n,m,r,c,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = 0;
        solve();
        System.out.println(result);
    }
    
    // d -> 0은 위, 1 오른쪽, 2 아래, 3 왼쪽
    static int result;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static void solve() {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r,c,d));
        boolean flag = false;
        int check = 0;
        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            // 청소 구역인지 확인 -> 청소후 체크표시
            if(arr[t.x][t.y]==0) {
                result++;
                arr[t.x][t.y] = 3;
            }
            if(flag) break;
 
            // 해당 방향 기준 왼쪽 방향 체크
            if(checkLeft(t.x,t.y,t.dir)) {
                check = 0;
                // d -> 0은 위, 1 오른쪽, 2 아래, 3 왼쪽
                switch(d) {
                case 0:
                    queue.add(new Pair(t.x-1,t.y,d));
                    break;
                case 1:
                    queue.add(new Pair(t.x,t.y+1,d));
                    break;
                case 2:
                    queue.add(new Pair(t.x+1,t.y,d));
                    break;
                case 3:
                    queue.add(new Pair(t.x,t.y-1,d));
                    break;
                }
                // 회전 만 진행
            }else {
                // 4방향 다 안되는 경우
                if(check==3) {
                    check = 0;
                    // d -> 0은 위, 1 오른쪽, 2 아래, 3 왼쪽
                    switch(d) {
                    case 0:
                        if(arr[t.x+1][t.y]==1) flag = true;
                        queue.add(new Pair(t.x+1,t.y,d));
                        continue;
                    case 1:
                        if(arr[t.x][t.y-1]==1) flag = true;
                        queue.add(new Pair(t.x,t.y-1,d));
                        continue;
                    case 2:
                        if(arr[t.x-1][t.y]==1) flag = true;
                        queue.add(new Pair(t.x-1,t.y,d));
                        continue;
                    case 3:
                        if(arr[t.x][t.y+1]==1) flag = true;
                        queue.add(new Pair(t.x,t.y+1,d));
                        continue;
                    }
                }
                if(flag) break;
                check++;
                queue.add(new Pair(t.x,t.y,d));
 
            }
        }
        
    }
    
    private static boolean checkLeft(int x,int y,int dd) {
        switch(dd-1) {
        case 0: // 오른쪽을 보고있을 때
            d = 0;
            if(arr[x-1][y]!=0) return false;
            break;
        case 1: // 아래 보고있을 때
            d = 1;
            if(arr[x][y+1]!=0) return false;
            break;
        case 2: // 왼쪽 보고있을 때
            d = 2;
            if(arr[x+1][y]!=0) return false;
            break;
        case -1: // 위를 보고있을 때
            d = 3;
            if(arr[x][y-1]!=0) return false;
            break;
        }
        return true;
    }
    
    static class Pair{
        private int x,y,dir;
        
        public Pair(int x,int y,int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
