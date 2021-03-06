package baekjoon.q10000;

import java.util.Scanner;

public class Q15658 {
	static int n;
	static int[] arr,giho;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		giho = new int[4];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		for(int i=0;i<4;i++)
			giho[i] = sc.nextInt();
		
		// 최대 최소 값 초기화
		resultMax = Integer.MIN_VALUE;
		resultMin = Integer.MAX_VALUE;
		solve(1,arr[0]);
		System.out.println(resultMax);
		System.out.println(resultMin);
	}
	
	static int resultMax,resultMin;
	private static void solve(int idx,int sum) {
		// 모든 숫자 계산 완료
		if(idx>=n) {
			resultMax = Math.max(resultMax, sum);
			resultMin = Math.min(resultMin, sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(giho[i]==0) continue;
			giho[i]--;
			switch (i) {
			case 0: // +
				solve(idx+1,sum+arr[idx]);
				break; 
			case 1: // -
				solve(idx+1,sum-arr[idx]);
				break;
			case 2: // x
				solve(idx+1,sum*arr[idx]);
				break;
			case 3: // /
				solve(idx+1,sum/arr[idx]);
				break;
			}
			giho[i]++;
		}
	}
}
