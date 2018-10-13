package swexpert.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2383 {
	static int n;
    static Door[] door;
    static int[][] arr;
    static List<Pair> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=tc;i++) {
            n = Integer.parseInt(br.readLine());
            list.clear();
            door = new Door[2];
            arr = new int[n][n];
            for(int j=0;j<n;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0;k<n;k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken()); 
                    if(arr[j][k]==1) list.add(new Pair(j, k, 0, 0, 0,0,0));
                    else if(arr[j][k]>=2) {
                        if(door[0]==null) door[0] = new Door(j, k, arr[j][k]);
                        else door[1] = new Door(j, k, arr[j][k]);
                    }
                }
            }
            // 계단이 2개 뿐이니 완전탐색을 하자.
            visited = new boolean[list.size()];
            // 부분 집합 만들어 주기
            min = Integer.MAX_VALUE;
            dfs(0);
            solve();
            sb.append("#"+i+" "+min+"\n");
        }
        System.out.print(sb);
    }
 
    static boolean[] visited;
    private static void dfs(int idx) {
        if(idx==list.size()) {
            solve();
            return;
        }
        // 1번 타겟
        visited[idx] = true;
        dfs(idx+1);
        visited[idx] = false;
        // 2번 타겟
        dfs(idx+1);
    }
    
    static int min;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static void solve() {
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.time>o2.time) return 1;
                else if(o1.time==o2.time) {
                    if(o1.dist>o2.dist) return 1;
                    else if(o1.dist==o2.dist) return 0;
                    else return -1;
                }else return -1;
            }
        });
        // 계단 번호 2~10 계단은 반드시 2개, 사람은 1~최대 10명
        for(int i=0;i<list.size();i++) {
            Pair t = list.get(i);
            // 해당 출구와 거리계산
            int dist = 0;
            // true면 1번 출구, 2번 출구 나누기
            if(visited[i]) {
                dist = Math.abs(t.x-door[0].x)+Math.abs(t.y-door[0].y);
                queue.add(new Pair(t.x, t.y, 0, 0, dist,0,0));
            }else {
                dist = Math.abs(t.x-door[1].x)+Math.abs(t.y-door[1].y);
                queue.add(new Pair(t.x, t.y, 1, 0, dist,0,0));
            }
        }
        int time = 0;
        int[] dCnt = new int[2];
        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            time = t.time;
            // 해당 계단에 아직 도달 안했다면 다시 넣어주고 다음꺼.(계단에 도달후 한 번 대기까지)
            if(t.dist>=time) {
                queue.add(new Pair(t.x, t.y, t.gate,t.wait,t.dist,t.time+1,t.c));
                continue;
            }
            // 계단 내려가는 중
            if(t.wait!=0) {
                if(t.wait==door[t.gate].n) {
                    dCnt[t.gate]--;
                    continue;
                }
                queue.add(new Pair(t.x, t.y, t.gate,t.wait+1,t.dist,t.time+1,t.c));
                continue;
            }
            // 해당 계단이 꽉차있다면 대기
            if(dCnt[t.gate]==3) {
                queue.add(new Pair(t.x, t.y, t.gate,t.wait,t.dist,t.time+1,t.c));
            }else {
                // 아니라면 들어가서 wait 해당 n 만큼 wait 늘리기
                dCnt[t.gate]++;
                queue.add(new Pair(t.x, t.y, t.gate,t.wait+1,t.dist,t.time+1,t.c));
            }
        }
        min = Math.min(min, time);
    }
    
    static class Door{
        private int x,y,n;
        public Door(int x,int y,int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }
    
    static class Pair{
        private int x,y,gate,wait,dist,time,c;
        public Pair(int x,int y,int gate,int wait,int dist,int time,int c) {
            this.x = x;
            this.y = y;
            this.gate = gate;
            this.wait = wait;
            this.dist = dist;
            this.time = time;
            this.c = c;
        }
    }
}
