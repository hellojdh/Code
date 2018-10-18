package baekjoon.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {
	static int[] arr,cul;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cul = new int[4];
        // 더하기 빼기 곱하기 나누기
        for(int i=0;i<4;i++)
            cul[i] = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        solve(cul[0],cul[1],cul[2],cul[3],arr[0],1);
        System.out.println(max);
        System.out.println(min);
    }
    
    static int max;
    static int min;
    private static void solve(int plus,int minus,int mul,int div,int result,int idx) {
        if(idx==n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        // 더하기
        if(plus>0) {
            solve(plus-1,minus,mul,div,result+arr[idx],idx+1);
        }
        // 빼기
        if(minus>0)
            solve(plus,minus-1,mul,div,result-arr[idx],idx+1);
        // 곱하기
        if(mul>0)
            solve(plus,minus,mul-1,div,result*arr[idx],idx+1);
        // 나누기
        if(div>0)
            solve(plus,minus,mul,div-1,result/arr[idx],idx+1);
    }
}
