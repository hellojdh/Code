package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1717 {
    static int[] p;
    static int order,a,b;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken())+1;
        int m = Integer.parseInt(st.nextToken());
        p = new int[n];
        /* p 초기화 */
        for(int i = 1; i < n; i++)
            p[i] = i;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            order = st.nextToken().charAt(0);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            switch (order) {
                case '0':
                    union(a, b);
                    break;
                case '1':
                    if(find(a)==find(b)) {
                        sb.append("YES\n");
                    }else {
                        sb.append("NO\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }// end of main


    public static void union(int a,int b) {
        p[find(b)] = find(a);
    }

    public static int find(int x) {
        if(p[x]==x) return x;
        return p[x] = find(p[x]);
    }
}// end of class