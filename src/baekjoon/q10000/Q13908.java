package baekjoon.q10000;

import java.util.Scanner;

public class Q13908 {
	static int n,m;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[10];
		// 무조건 써야할 건 true 값을 넣어놔준다.
		for(int i=0;i<m;i++)
			visited[sc.nextInt()] = true;
		// 모든 경우를 살펴보자.
		solve(0,0);
		System.out.println(result);
	}
	
	static int result = 0;
	private static void solve(int idx,int cnt) {
		if(idx==n) {
			// 무조건 사용해야할 m개를 사용하지 않았으면 개수 카운트 x
			if(cnt!=m) return;
			result++;
			return;
		}
		
		for(int i=0;i<=9;i++) {
			// 무조건 사용해야할 것이라면
			if(visited[i]) {
				visited[i] = false;
				// 사용했다고 개수를 올려주자.
				solve(idx+1,cnt+1);
				visited[i] = true;
				continue;
			}
			solve(idx+1,cnt);
		}
	}
}
