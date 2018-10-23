package baekjoon.q10000;

import java.util.Scanner;

public class Q10971 {
	static int n;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				arr[i][j] = sc.nextInt();

		// 방문 체크
		visited = new int[n];
		// 모든 경우를 살펴보자.
		result = Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
			solve(i,i,0,0); // 도시들 마다 출발을 해보자
		System.out.println(result);
	}
	
	static int[] visited;
	static int result;
	private static void solve(int start,int idx,int sum,int cnt) {
		// 결과값 보다 크면 필요없다.
		if(result<sum) return;
		// 모든 조건을 살펴봤다면
		if(cnt==n) {
			if(start==idx) result = Math.min(result, sum);
			return;
		}
		
		for(int i=0;i<n;i++) {
			// 맨 처음 시작 자기자신 제외
			if(idx==i) continue;
			// 이미 방문한 곳이라면 패스
			if(visited[i]==1) continue;
			// 갈 수 없는 곳이면 패스
			if(arr[idx][i]==0) continue;
			visited[i] = 1;
			solve(start, i, sum+arr[idx][i], cnt+1);
			visited[i] = 0;
		}
	}
}
