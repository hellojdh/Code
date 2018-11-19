package baekjoon.q10000;

import java.util.Scanner;

public class Q10799 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String t = sc.next();
        int cnt = 0;
        int result = 0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='('){
                if(t.charAt(i+1)==')'){
                    i++;
                    result+=cnt;
                    continue;
                }
                // 막대기 개수 +1
                cnt++;
            }else{
                // 막대기 개수 -1
                cnt--;
                // 총 막대 개수 +1
                result++;
            }
        }
        System.out.println(result);
    }
}
