package swexpert.d4;

import java.io.IOException;
import java.util.Scanner;

public class Q5213 {
	 public static void main(String[] args) throws IOException {
		   Scanner sc = new Scanner(System.in);
		   StringBuilder sb = new StringBuilder();
		   int tc = sc.nextInt();
		   solve();
		   for(int i=1;i<=tc;i++) {
			   int L = sc.nextInt();
			   int R = sc.nextInt();
			   long sum = 0;
			   // R~L까지 수들의 합
			   // arr[R]에는 1~R 까지의 모든 합이 들어있다.
			   sum = arr[R]-arr[L-1];
			   sb.append("#"+i+" "+sum+"\n");
		   }
		   System.out.print(sb);
	   }
	   
	   static long[] arr = new long[1000001];
	   private static void solve() {
		   // 약수 미리 더하기
		   for(int i=1;i<=1000000;i+=2) {
			   for(int j=1;(i*j)<=1000000;j++) {
				   arr[(i*j)] += i;
			   }
		   }
		   // 더한 값의 이전값 미리 더하기
		   for(int i=1;i<=1000000;i++) {
			   arr[i] += arr[i-1];
		   }
	   }
}
