package baekjoon.q1000;

import java.io.IOException;
import java.util.Scanner;

public class Q1152 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        // 단어를 읽어들일게 없을 때까지 반복
        while(sc.hasNext()){
            sc.next();
            result++;
        }
        System.out.println(result);
    }
}
