package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q1389 {
    static HashSet<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new HashSet[n+1];
        for(int i=0;i<=n;i++)
            list[i] = new HashSet<>();
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        int[] result = new int[n];
        int idx = 0;
        int[] queue = new int[(n+1)*(n+1)];
        int[] queueCnt = new int[queue.length];
        for(int i=1;i<=n;i++) {
            int front=-1,rear=-1;
            int frontC = -1,rearC=-1;
            boolean[] visited = new boolean[n+1];
            int sum = 0;
            queue[++rear] = i;
            queueCnt[++rearC] = 0;
            visited[i] = true;
            while(front<rear) {
                int cur = queue[++front];
                int cnt = queueCnt[++frontC];
                sum+=cnt;
                for(int t:list[cur]) {
                    if(visited[t]) continue;
                    visited[t] = true;
                    queue[++rear] = t;
                    queueCnt[++rearC] = cnt+1;
                }
            }
            result[idx++] = sum;
        }
        int min=10000,t=0;
        for(int i=0;i<idx;i++) {
            if(min>result[i]) {
                min = result[i];
                t = i+1;
            }
        }
        System.out.println(t);
    }// end of main
}// end of class