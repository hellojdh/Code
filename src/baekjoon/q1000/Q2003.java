package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2003 {
    static int n,m;
    static int[] arr;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];

        int s = 0, e = 0;
        int sum = 0;
        int result = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(sum >= m) {
                sum -= arr[s++];
            }else if(e == n) break;
            else sum += arr[e++];

            if(sum == m) {
                result++;
            }
        }
        while(true) {
            if(sum >= m) {
                sum -= arr[s++];
            }else if(e == n) break;
            else sum += arr[e++];

            if(sum == m) {
                result++;
            }
        }
        System.out.println(result);
    }// end of main
}// end of class