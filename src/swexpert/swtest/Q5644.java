package swexpert.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5644 {
	static int m,a;
    static int[][] p;
    static String[][] arr;
    static List<Pair> list = new ArrayList<>();
    static int[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=tc;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.clear();
            arr = new String[10][10];
            for(int j=0;j<10;j++)
                Arrays.fill(arr[j], "0");
            m = Integer.parseInt(st.nextToken()); // 이동수
            a = Integer.parseInt(st.nextToken()); // bc의 개수
            // 충전기 방문 체크
            check = new int[a+1];
            p = new int[2][m];
            // 사람 입력 받기
            for(int j=0;j<2;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++)
                    p[j][k] = Integer.parseInt(st.nextToken());
            }
            
            // idx를 1부터 사용하기 위해서
            list.add(new Pair(0, 0, 0, 0));
            // ap 정보 받기 & 맵에 미리 펼치기
            for(int j=0;j<a;j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                list.add(new Pair(y-1,x-1,c,p));
                charge(y-1,x-1,c,p,j+1);
            }
            sb.append("#"+i+" "+solve()+"\n");
        }
        System.out.print(sb);
    }
    
    // 맵에 미리 범위 미리 넣어놓기.
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static void charge(int x,int y,int c,int p,int idx) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y, 0, idx));
        boolean[][] visited = new boolean[10][10];
        if(arr[x][y]!="0")
            arr[x][y] = arr[x][y]+"0"+idx;
        else arr[x][y] = idx+"";
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            if(t.c==c) continue;
            for(int i=0;i<4;i++) {
                int tx = t.x+dir[i][0];
                int ty = t.y+dir[i][1];
                if(tx<0 || ty<0 || tx==10 || ty==10) continue;
                if(visited[tx][ty]) continue;
                visited[tx][ty] = true;
                if(arr[tx][ty]!="0") {
                    arr[tx][ty] = arr[tx][ty]+"0"+idx;
                }else arr[tx][ty] = idx+"";
                queue.add(new Pair(tx, ty, t.c+1, t.p));
            }
        }
    }
    
    private static int solve() {
        Queue<Person> queue = new LinkedList<>();
        queue.add(new Person(0, 0, 0, 0));
        queue.add(new Person(9, 9, 1, 0));
        int result = 0;
        while(!queue.isEmpty()) {
            Person t = queue.poll();
            Person t2 = queue.poll();
            int tx = t.x,ty = t.y;
            int tx2 = t2.x, ty2 = t2.y;
            // 모든 경우수를 따져서 파워구하기
            result += power(tx,ty,tx2,ty2);
            
            // 시간이 끝나면 다 더해주기
            if(t.time==m) break;
            
            // 다음 칸으로 가기
            switch (p[t.n][t.time]) {
            case 1: tx-=1;break;
            case 2: ty+=1;break;
            case 3: tx+=1;break;
            case 4: ty-=1;break;
            }
            switch (p[t2.n][t2.time]) {
            case 1: tx2-=1;break;
            case 2: ty2+=1;break;
            case 3: tx2+=1;break;
            case 4: ty2-=1;break;
            }
            queue.add(new Person(tx, ty, t.n, t.time+1));
            queue.add(new Person(tx2, ty2, t2.n, t2.time+1));
        }
        return result;
    }
    
    // 가장 큰 파워 찾기
    private static int power(int x,int y,int x2,int y2) {
        // 0으로 초기화
        int[] tArr = {0},tArr2 = {0};
        // 1의 경우의 수 가져오기
        if(arr[x][y].length()>=3) {
            StringTokenizer st = new StringTokenizer(arr[x][y],"0");
            int cnt = st.countTokens();
            tArr = new int[cnt];
            for(int i=0;i<cnt;i++)
                tArr[i] = Integer.parseInt(st.nextToken());
        }else if(!arr[x][y].equals("0")) {
            // 전기를 1개만 공급 받을 수 있다면
            tArr[0] = Integer.parseInt(arr[x][y]);
        }
        // 2의 경우의 수 가져오기
        if(arr[x2][y2].length()>=3) {
            StringTokenizer st = new StringTokenizer(arr[x2][y2],"0");
            int cnt = st.countTokens();
            tArr2 = new int[cnt];
            for(int i=0;i<cnt;i++)
                tArr2[i] = Integer.parseInt(st.nextToken());
        }else if(!arr[x2][y2].equals("0")) {
            tArr2[0] = Integer.parseInt(arr[x2][y2]);
        }
        int max = 0;
        for(int i=0;i<tArr.length;i++) {
            for(int j=0;j<tArr2.length;j++) {
                max = Math.max(max, getMax(tArr[i],tArr2[j]));
            }
        }
        return max;
    }
    
    private static int getMax(int idx1,int idx2) {
        // index가 같다면 같은 충전기에 있는 것이므로 *2 니깐 그대로
        if(idx1==idx2) return list.get(idx1).p;
        else return list.get(idx1).p+list.get(idx2).p;
    }
    
    static class Person{
        private int x,y,n,time;
        public Person(int x,int y,int n,int time) {
            this.x = x;
            this.y = y;
            this.n = n;
            this.time = time;
        }
    }
    static class Pair{
        private int x,y,c,p;
        public Pair(int x,int y,int c,int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }
}
