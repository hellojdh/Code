package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2605 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new LinkedList<>();
        for(int i=1;i<=n;i++) {
            int t = Integer.parseInt(st.nextToken()); // 뽑은 번호
            if(t==0) list.add(i);
            else {
                list.add(list.size()-t, i);
            }
        }// end of for(n)

        int len = list.size();
        for(int i=0;i<len;i++) {
            sb.append(list.get(i)).append(' ');
        }
        System.out.println(sb);
    }// end of main
}// end of class
