package baekjoon.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14891 {
	static int[][] arr = new int[4][8];
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 톱니 입력 받기
        for(int i=0;i<4;i++) {
            String t = br.readLine();
            for(int j=0;j<8;j++)
                arr[i][j] = t.charAt(j)-'0';
        }
        // 회전 수
        k = Integer.parseInt(br.readLine());
        // 복합 적으로 도는것이 아니라 한 회전씩 도는 것이므로
        // 한 케이스씩 처리하였다.
        for(int i=0;i<k;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            solve(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
        }
        int result = 0;
        int[] mul = {1,2,4,8};
        for(int i=0;i<4;i++) 
            result += arr[i][0]*mul[i];
        
        System.out.println(result);
    }
    
    // 톱니의 왼쪽은        6 번 인덱스
    // 톱니의 오른쪽은    2 번 인덱스
    // 12시 방향은 0 번 인덱스
    // r = 1 시계 , -1 반시계
    private static void solve(int n,int r) {
        boolean[] visited = new boolean[4];
        // BFS가 한 칸씩 전진하므로 BFS로 옆 톱니들을 보자
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(n, r));
        visited[n] = true;
        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            int tt = t.n;
            // 현 기준에서 오른쪽 값 value로
            if(tt+1<4 && !visited[tt+1]) {
                // 다음 꺼랑 톱니가 같지 않다면 돌려야하니 넣어준다.
                if(arr[tt][2]!=arr[tt+1][6])
                    queue.add(new Pair(tt+1,-t.r));
                visited[tt+1] = true;
            }
            // 현 기준에서 왼쪽 값을 value로
            if(tt-1>=0 && !visited[tt-1]) {
                if(arr[tt][6]!=arr[tt-1][2])
                    queue.add(new Pair(tt-1,-t.r));
                visited[tt-1] = true;
            }
            swap(tt,t.r);
        }
    }
    
    private static void swap(int n,int r) {
        if(r==1) {
            // 시계 방향이니 맨 뒤에껄 저장하고
            int t = arr[n][7];
            for(int i=6;i>=0;i--)
                arr[n][i+1] = arr[n][i];
            arr[n][0] = t;
        }else {
            // 반 시계 방향이니 맨 앞에껄 저장하고
            int t = arr[n][0];
            for(int i=1;i<=7;i++)
                arr[n][i-1] = arr[n][i];
            arr[n][7] = t;
        }
    }
    
    static class Pair{
        private int n,r;    
        public Pair(int n,int r) {
            this.n = n;
            this.r = r;
        }
    }
}
