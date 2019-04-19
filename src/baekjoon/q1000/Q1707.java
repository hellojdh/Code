package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1707 {
    static int n,z,target;
    static List<Integer>[] list = new ArrayList[20002];
    static int[] visited = new int[20001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
xx:		for(z=1; z<=tc; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for(int i=1;i<=v;i++) {
                list[i] = new ArrayList<>();
                visited[i] = 0;
            }

            int a = 0;
            int b = 0;
            for(int i=0;i<e;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            exit = false;
            for(int i=1;i<=v;i++) {
                if(visited[i]!=0) continue;
                solve(i,1);
                if(exit) {
                    sb.append("NO").append('\n');
                    continue xx;
                }
            }
            sb.append("YES").append('\n');
        }// end of tc
        System.out.println(sb);
    }// end of main

    static boolean exit;
    public static void solve(int idx,int flag) {
        if(exit) return;
        int len = list[idx].size();
        for(int i=0;i<len;i++) {
            int t = list[idx].get(i);
            if(visited[t] != 0 && flag==visited[t]) {
                exit = true;
                return;
            }
            if(visited[t]==0) {
                visited[t] = -flag;
                solve(t,-flag);
                if(exit) return;
            }
        }
    }
} // end of class