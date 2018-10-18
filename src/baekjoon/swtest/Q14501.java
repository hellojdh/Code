package baekjoon.swtest;

import java.io.IOException;
import java.util.Scanner;

public class Q14501 {
	static int n;
    static int[] time,value;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        time = new int[n];
        value = new int[n];
        for(int i=0;i<n;i++) {
            time[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        max = Integer.MIN_VALUE;
        solve(0,0);
        System.out.println(max);
    }
    
    static int max;
    private static void solve(int idx,int v) {
        if(idx>n) return;
        if(idx==n) {
            max = Math.max(max, v);
            return;
        }        
        // 현재 idx를 포함 => 상담 못하는 시간만큼 idx를 올려줌
        solve(idx+time[idx],v+value[idx]);
        // 현재 idx를 미포함
        solve(idx+1,v);
    }
}
