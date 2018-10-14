package swexpert.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q5653 {
	static int n,m,k;
    static int[][] arr;
    static List<Pair> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=1;i<=tc;i++) {
            list.clear();
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n+k][m+k];
            for(int j=(k/2);j<(k/2)+n;j++) {
                st = new StringTokenizer(br.readLine());
                for(int z=(k/2);z<(k/2)+m;z++) {
                    arr[j][z] = Integer.parseInt(st.nextToken());
                    if(arr[j][z]!=0)
                        list.add(new Pair(j, z, arr[j][z], arr[j][z],k,0));
                }
            }
            solve();
            int result = 0;
            for(int j=0;j<arr.length;j++) {
                for(int z=0;z<arr[0].length;z++) {
                    if(arr[j][z]!=0&&arr[j][z]!=-1)
                        result++;
                }
            }
            sb.append("#"+i+" "+result+"\n");
        }
        System.out.print(sb);
    }
     
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static void solve() {
        PriorityQueue<Pair> queue = new PriorityQueue(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.time>o2.time?-1:o1.time==o2.time?o1.k>o2.k?-1:1:1;
            }
        });
        for(int i=0;i<list.size();i++)
            queue.add(list.get(i));
        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            if(t.state==0&&t.flag==1) {
                arr[t.x][t.y] = -1;
                continue;
            }
            if(t.time==0) continue;
            if(t.state==0) {
                queue.add(new Pair(t.x,t.y,t.k,t.k,t.time,1));
            } else {
                queue.add(new Pair(t.x, t.y, t.k,t.state-1,t.time-1,t.flag));
                continue;
            }
            for(int i=0;i<4;i++) {
                int tx = t.x+dir[i][0];
                int ty = t.y+dir[i][1];
                if(tx<0 || ty<0 || tx>=n+k || ty>=m+k) continue;
                if(arr[tx][ty]!=0) continue;
                arr[tx][ty] = t.k;
                queue.add(new Pair(tx, ty, t.k, t.k,t.time-1,0));
            }
        }
    }
     
    static class Pair{
        private int x,y,k,state,time,flag;
        public Pair(int x,int y,int k,int state,int time,int flag) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.state = state; // 변하는 생명력
            this.time = time;
            this.flag = flag; // 0이 되었을 때, 번식 했나 유무
        }
    }
}
