package swexpert.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3289 {
    static int n,m;
    static int[] p = new int[1000003];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int z=1; z<=tc; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            for(int i=1; i<=n; i++)
                p[i] = i;
            sb.append('#').append(z).append(' ');
            for(int i=0;i<m;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int order = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(order==0) {
                    union(a, b);
                }else {
                    int ta = findSet(a);
                    int tb = findSet(b);
                    if(ta==tb) {
                        sb.append(1);
                    }else {
                        sb.append(0);
                    }
                }
            }// end of for(m)
            sb.append('\n');
        }
        System.out.println(sb);
    }// end of main

    public static void union(int a,int b) {
        int pa = findSet(a);
        int pb = findSet(b);
        if(pa>pb) {
            p[pb] = pa;
        }else {
            p[pa] = pb;
        }
    }

    public static int findSet(int x) {
        if(p[x] == x) return x;
        return p[x] = findSet(p[x]);
    }
}// end of class