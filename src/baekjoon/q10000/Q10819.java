package baekjoon.q10000;

import java.util.Scanner;

public class Q10819 {
	static int n;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		visited = new int[n];
		tArr = new int[n];
		result = 0;
		solve(0);
		System.out.println(result);
	}
	
	static int result;
	static int[] visited,tArr; // 방문 배열, 임시 배열
	private static void solve(int cnt) {
		// 배열이 만들어 지면
		if(cnt==n) {
			int sum = 0;
			// 만든 배열로 값 계산
			for(int i=0;i<n-1;i++)
				sum += Math.abs(tArr[i]-tArr[i+1]);
			// 최대값 찾기
			result = Math.max(result, sum);
			return;
		}
		
		
		for(int i=0;i<n;i++) {
			if(visited[i]==1) continue; 
			visited[i] = 1; // 방문 표시
			tArr[cnt] = arr[i]; // 새로운 배열 만들기
			solve(cnt+1);
			visited[i] = 0; // 방문 해제
		}
	}
}
