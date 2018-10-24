package baekjoon.q1000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5014 {
	static int[] arr,move;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// F(0) S(1) G(2)
		// 건물에서 가장 높은 층은 F층이다.
		arr = new int[3];
		for(int i=0;i<3;i++)
			arr[i] = sc.nextInt();
		// U(0) D(1)
		move = new int[2];
		move[0] = sc.nextInt();
		move[1] = sc.nextInt();
		visited = new boolean[arr[0]+1];
		solve();
	}
	
	static boolean[] visited;	
	private static void solve() {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(arr[1], 0)); // S층 넣어주기
		visited[arr[1]] = true;
		boolean flag = false;
		while(!queue.isEmpty()) {
			Pair t = queue.poll();
			// 도착 가능하면
			if(t.n==arr[2]) {
				flag = true;
				System.out.println(t.cnt);
				break;
			}
			
			// 위층 보내기 && 최상층 넘어가지 않으면 && 방문 한적 없으면
			if(move[0]!=0&&t.n+move[0]<=arr[0]&&!visited[t.n+move[0]]) {
				visited[t.n+move[0]]=true;
				queue.add(new Pair(t.n+move[0], t.cnt+1));
			}
			// 아래층 보내기 && 최하층 밑으로 가지 않으면 && 방문 한적 없으면
			if(move[1]!=0&&t.n-move[1]>0&&!visited[t.n-move[1]]) {
				visited[t.n-move[1]]=true;
				queue.add(new Pair(t.n-move[1], t.cnt+1));
			}
		}
		if(!flag) System.out.println("use the stairs");
	}
	
	static class Pair{
		int n,cnt;
		Pair(int n,int cnt){
			this.n= n;
			this.cnt = cnt;
		}
	}
}
