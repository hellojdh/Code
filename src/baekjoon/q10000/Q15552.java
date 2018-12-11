package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15552 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())+"\n");
        }
        System.out.println(sb);
    }
}
