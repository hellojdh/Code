package swexpert.swtest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q5650 {
	static int n;
    static int[][] arr;
    static List<Holl> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=tc;i++) {
            n = sc.nextInt();
            arr = new int[n][n];
            // 웜홀 초기화 6~10
            list.clear();
            for(int j=0;j<5;j++)
                list.add(new Holl(-1, -1, -1, -1));
            
            // 입력 받기
            for(int j=0;j<n;j++) {
                for(int k=0;k<n;k++) {
                    arr[j][k] = sc.nextInt();
                    if(arr[j][k]>=6) {
                        if(list.get(arr[j][k]-6).x==-1) {
                            list.get(arr[j][k]-6).x = j;
                            list.get(arr[j][k]-6).y = k;
                        }else {
                            list.get(arr[j][k]-6).x2 = j;
                            list.get(arr[j][k]-6).y2 = k;
                        }
                    }
                }
            }
            
            result = 0;
            for(int j=0;j<n;j++) {
                for(int k=0;k<n;k++) {
                    if(arr[j][k]==0)
                        solve(j,k);
                }
            }
            sb.append("#"+i+" "+result+"\n");
        }
        System.out.print(sb);
    }
    
    static int result;
    private static void solve(int x,int y) {
        Queue<Pair> queue = new LinkedList<>();
        // 네 방향 넣어주기,
        for(int i=1;i<=4;i++)
            queue.add(new Pair(x,y,i,0));
        // 맨 처음 공 출발지점 도착아니기 위해서.
        int cnt=0;
        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            // 출발 위치로 돌아온 경우 끝
            cnt++;
            int tx=t.x, ty=t.y;
            if(tx==x && ty==y && cnt>4) {
                result = Math.max(result, t.score);
                continue;
            }
            switch (t.d) {
            case 1: tx-=1; break; // 상
            case 2:    tx+=1; break; // 하
            case 3:    ty-=1; break; // 좌
            case 4:    ty+=1; break; // 우
            }
            // 맵 밖으로 나감 -> 벽에서 나간 것.(부딪히게 하자)
            if(tx<0 || ty<0 || tx>=n || ty>=n) {
                // 방향 반대로 바꿔주기
                switch (t.d) {
                case 1: t.d=2; break;
                case 2:    t.d=1; break;
                case 3:    t.d=4; break;
                case 4:    t.d=3; break;
                }
                // 부딪힌 거니 점수 & 벗어나긴 전 위치 값으로 방향,점수만 변경
                t.score++;
                if(arr[t.x][t.y]!=0) {
                    if(arr[t.x][t.y]>=6) {
                        // 웜홀
                        int wx = list.get(arr[t.x][t.y]-6).x;
                        int wy = list.get(arr[t.x][t.y]-6).y;
                        int wx2 = list.get(arr[t.x][t.y]-6).x2;
                        int wy2 = list.get(arr[t.x][t.y]-6).y2;
                        if(t.x==wx&&t.y==wy) {
                            queue.add(new Pair(wx2, wy2, t.d, t.score));
                        }else {
                            queue.add(new Pair(wx, wy, t.d, t.score));
                        }
                    }else {
                        // 벽돌 -> 방향 이동해주기
                        t.d = wall(t.x, t.y, t.d);
                        queue.add(new Pair(t.x, t.y, t.d, t.score+1));
                    }
                }else {
                    queue.add(new Pair(t.x, t.y, t.d, t.score));
                }
                continue;
            }
            
            // 벽돌, 블랙홀, 웜홀 확인
            if(arr[tx][ty]==0) {
                // 1) 일반길 -> 갈 수 있는곳 까지 보내주자.
                queue.add(new Pair(tx, ty, t.d, t.score));
            }else if(arr[tx][ty]==-1) {
                // 2) 블랙홀 -> 점수계산
                result = Math.max(result, t.score);
            }else if(arr[tx][ty]<6) {
                // 3) 벽돌 -> 방향 이동해주기
                t.d = wall(tx, ty, t.d);
                queue.add(new Pair(tx, ty, t.d, t.score+1));
            }else {
                // 4) 웜홀 이동(2개 쌍) -> 방향 그대로 점수 X
                int wx = list.get(arr[tx][ty]-6).x;
                int wy = list.get(arr[tx][ty]-6).y;
                int wx2 = list.get(arr[tx][ty]-6).x2;
                int wy2 = list.get(arr[tx][ty]-6).y2;
                if(tx==wx&&ty==wy) {
                    queue.add(new Pair(wx2, wy2, t.d, t.score));
                }else {
                    queue.add(new Pair(wx, wy, t.d, t.score));
                }
            }
        }
    }
    
    private static int wall(int x,int y,int d) {
        switch (arr[x][y]) {
        case 1:
            if(d==1)       return 2; // 상->하
            else if(d==2) return 4; // 하->우
            else if(d==3) return 1; // 좌->상
            else if(d==4) return 3; // 우->좌
            break;
        case 2:
            if(d==1)       return 4; // 상->우
            else if(d==2) return 1; // 하->상
            else if(d==3) return 2; // 좌->하
            else if(d==4) return 3; // 우->좌
            break;
        case 3:
            if(d==1)       return 3; // 상->좌
            else if(d==2) return 1; // 하->상
            else if(d==3) return 4; // 좌->우
            else if(d==4) return 2; // 우->하
            break;
        case 4:
            if(d==1)       return 2; // 상->하
            else if(d==2) return 3; // 하->좌
            else if(d==3) return 4; // 좌->우
            else if(d==4) return 1; // 우->상
            break;
        case 5:
            if(d==1)       return 2; // 상->하
            else if(d==2) return 1; // 하->상
            else if(d==3) return 4; // 좌->우
            else if(d==4) return 3; // 우->좌
            break;
        }
        return 0;
    }
    
    static class Pair{
        private int x,y,d,score;
        public Pair(int x,int y,int d,int score) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.score = score;
        }
    }
    
    static class Holl{
        private int x,y,x2,y2;
        public Holl(int x,int y,int x2,int y2) {
            this.x = x;
            this.y = y;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}
