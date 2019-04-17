package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10822 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");
        int size = st.countTokens();
        int result = 0;
        for(int i = 0; i < size; i++){
            result += Integer.parseInt(st.nextToken());
        }
        System.out.println(result);
    }// end of main
}// end of class