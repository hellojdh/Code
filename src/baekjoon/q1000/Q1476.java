package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1476 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken()); // 1~15
        int s = Integer.parseInt(st.nextToken()); // 1~28
        int m = Integer.parseInt(st.nextToken()); // 1~19

        // 변하는 각 변수 초기화
        int te = 1;
        int ts = 1;
        int tm = 1;
        int result = 0;
        while(true){
            result++; // 년도 증가
            // 입력값과 같아진 다면 년도 출력 후 종료
            if(e==te&&s==ts&&m==tm){
                System.out.println(result);
                break;
            }
            te++; ts++; tm++;
            // 각 범위를 넘어서면 1로 초기화
            if(te>15) te=1;
            if(ts>28) ts=1;
            if(tm>19) tm=1;
        }
    }
}
