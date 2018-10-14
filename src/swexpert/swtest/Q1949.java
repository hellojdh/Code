package swexpert.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1949 {
	static int n,k;
    static int[][] arr;
    static List<Pair> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            list = new ArrayList<>();
            int max = 0;
            for(int j=0;j<n;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<n;k++) {
                    int temp = Integer.parseInt(st.nextToken());
                    arr[j][k] = temp;
                    // Max 값이 갱신될 경우 list를 초기화 하고 출발지를 넣어준다.
                    if(temp>max) {
                        list.clear();
                        list.add(new Pair(j,k,0,false,0));
                        max = temp;
                        // Max가 같을 경우 출발지에 넣어준다.
                    }else if(temp==max) list.add(new Pair(j,k,0,false,0));
                }
            }
            result = 0;
            visited = new boolean[n][n];
            for(int j=0;j<list.size();j++)
                solve(new Pair(list.get(j).x,list.get(j).y,1,false,0));
            System.out.println("#"+i+" "+result);
        }
    }
    
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visited;
    static int result;
    private static void solve(Pair t) {
        result = Math.max(result, t.cnt);
        visited[t.x][t.y] = true;
        for(int i=0;i<4;i++) {
            int tx = t.x+dir[i][0];
            int ty = t.y+dir[i][1];
            if(tx<0 || ty<0 || tx>=n || ty>=n) continue;
            if(visited[tx][ty]) continue;
            // tempK를 통해 이전에 파괴를 했다면 그 파괴된 값을 얻는다.
            if(arr[t.x][t.y]-t.tempK > arr[tx][ty]) {
                solve(new Pair(tx,ty,t.cnt+1,t.use,0));
            }else if(!t.use) {
                // 기회가 사용되지 않았다면
                // K 이하로 파괴가 가능 
                for(int j=1;j<=k;j++) {
                    if(arr[t.x][t.y] > arr[tx][ty] - j) {
                        solve(new Pair(tx,ty,t.cnt+1,true,j));
                        // 가장 작게 파괴해야 그 숫자가 큰 숫자가 된다.
                        break;
                    }
                }
            }
        }
        // 다음 탐색을 할 때 해당 index를 지나가야하므로 초기화
        visited[t.x][t.y] = false;
    }
    
    static class Pair{
        private int x;
        private int y;
        private int cnt,tempK;
        private boolean use;
        public Pair(int x,int y,int cnt,boolean use,int tempK) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.use = use;
            this.tempK = tempK;
        }
    }
}
