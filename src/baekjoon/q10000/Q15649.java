package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649 {
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[m];
        visited = new boolean[n+1];
        solve(0);
        System.out.println(sb);
    }// end of main

    static int[] result;
    static boolean[] visited;
    public static void solve(int cnt) {
        if(cnt==m) {
            for(int i=0;i<m;i++)
                sb.append(result[i]).append(' ');
            sb.append('\n');
            return;
        }
        for(int i=1;i<=n;i++) {
            if(visited[i]) continue;
            visited[i] = true;
            result[cnt] = i;
            solve(cnt+1);
            visited[i] = false;
        }
    }
} // end of class