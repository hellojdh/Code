package baekjoon.q1000;

import java.util.Scanner;

public class Q1182 {
	static int n,s;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		
		arr = new int[n];
		visited = new int[n];
		// 입력 받기
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		// 결과값 초기화
		result = 0;
		solve(0);
		// 0일 경우 공집합도 들어가므로 빼주기
		if(s==0) result--;
		System.out.println(result);
	}
	
	static int result;
	static int[] visited;
	private static void solve(int idx) {
		if(idx>=n) {
			int tSum=0;
			// 선택된 idx들 더해주기
			for(int i=0;i<n;i++)
				if(visited[i]==1) tSum+=arr[i];
			// 주어진 값과 같다면 +1
			if(tSum==s) result++;
			return;
		}
		// 자신 미포함
		solve(idx+1);
		visited[idx]=1;
		// 자신 포함
		solve(idx+1);
		visited[idx]=0;
	}
}
