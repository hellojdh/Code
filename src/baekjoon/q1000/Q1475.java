package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1475 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String num = br.readLine(); // 만들 숫자
        // 0~9까지 한 세트
        int[] arr = new int[10];

        int len = num.length();
        for(int i=0;i<len;i++) {
            int t = num.charAt(i)-'0';
            // 6과 9는 하나로 보기
            if(t==6||t==9) {
                arr[6]++;
            }else {
                arr[t]++;
            }
        }
        // 6은 /2한 세트 + %만큼 더해주기
        int mod = arr[6]%2;
        arr[6]/=2;
        arr[6]+=mod;

        // 가장 많은 개수 세기
        int result = 0;
        for(int i=0;i<10;i++) {
            result = result>arr[i]?result:arr[i];
        }
        System.out.println(result);
    }// end of main
}// end of class
