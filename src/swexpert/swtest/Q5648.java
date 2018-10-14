package swexpert.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5648 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++) {
            int n = Integer.parseInt(br.readLine());
            Pair[] arr = new Pair[n];
            for(int j=0;j<n;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j] = new Pair(Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()));
            }
            sb.append("#"+i+" "+solve(arr)+"\n");
        }        
        System.out.print(sb);
    }
    
    static int[][] map = new int[4001][4001];; 
    private static int solve(Pair[] arr) {
        Queue<Pair> queue = new LinkedList<>();
        // 0~4000 까지 사용하기 위해서 4001로
        for(int i=0;i<arr.length;i++) {
            // 주어진 좌표랑 배열상 x y기준이 다르기 때문에 교환
            // -를 없애기 위해 +1000
            int x = arr[i].y+1000;
            int y = arr[i].x+1000;
            int d = arr[i].d;
            int k = arr[i].k;
            if(k==0) k=101;
            // 0.5칸에서 만나는 것을 방지하기 위해서 *2 (0~4000)
            // 배열 상 x는 0 부터 시작하니 뒤집기
            queue.add(new Pair(4000-x*2, y*2, d, k));
            map[4000-x*2][y*2] = k;
        }
        int cntZero = 0;
        int result = 0;
        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            // 이동하려고 하는데 자신의 K 보다 크면 충돌이 일어난 것.
            if(map[t.x][t.y]>t.k) {
                if(t.k==101) result-=101;
                result+=map[t.x][t.y];
                map[t.x][t.y] = 0;
                continue;
            }
            int tx = t.x;
            int ty = t.y;
            switch(t.d) {
            case 0: tx-=1; break;
            case 1:    tx+=1; break;
            case 2:    ty-=1; break;
            case 3:    ty+=1; break;
            }
            if(tx<0 || ty<0 || tx>4000 || ty>4000) {
                map[t.x][t.y] = 0;
                continue;
            }
            // 해당 좌표에 값이 있다면
            if(map[tx][ty]!=0) {
                if(t.k==101) cntZero++;
                map[tx][ty] += t.k;
                map[t.x][t.y] = 0;
            }else {
            // 값이 없다면
                map[tx][ty] = t.k;
                map[t.x][t.y] = 0;
                queue.add(new Pair(tx, ty, t.d, t.k));
            }
        }
        // zero 잘라주기
        result -= cntZero*101;
        return result;
    }
    
    static class Pair{
        private int x,y,k,d;
        public Pair(int x,int y,int d,int k) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.k = k;
        }
    }
}
