package baekjoon.q10000;

import java.util.Scanner;
import java.util.Stack;

public class Q10799 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        String t = sc.next();
        int result = 0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='('){
                if(t.charAt(i+1)==')'){
                    i++;
                    result += stack.size();
                    continue;
                }
                // 막대기 개수 +1
                stack.push(1);
            }else{
                // 막대기 개수 -1
                stack.pop();
                // 총 막대 개수 +1
                result++;
            }
        }
        System.out.println(result);
    }
}
