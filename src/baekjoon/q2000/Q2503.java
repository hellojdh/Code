package baekjoon.q2000;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2503 {
	static List<Pair> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 상태 담아 놓기
		for(int i=0;i<n;i++)
			list.add(new Pair(sc.next(),sc.nextInt(),sc.nextInt()));
		// 조합 만들기
		solve(0);
		System.out.println(result);
	}
	
	static int result;
	static int[] arr = new int[3];
	static int[] visited = new int[10];
	private static void solve(int cnt) {
		if(cnt==3) {
			// 문자 만들기
			String n = "";
			for(int i=0;i<3;i++)
				n += arr[i];
			// 조건 들과 다 비교
			for(Pair t:list) {
				int s=0,b=0;
				for(int i=0;i<3;i++) {
					if(n.charAt(i)==t.n.charAt(i)) s++;
					else if(t.n.contains(n.charAt(i)+"")) b++;
				}
				if(t.s==s && t.b==b) continue;
				return;
			}
			result++;			
			return;
		}
		
		for(int i=1;i<=9;i++) {
			// 이미 선택된 번호면 패스
			if(visited[i]==1) continue;
			// 해당 번호 선택
			arr[cnt] = i;
			visited[i] = 1;
			solve(cnt+1);
			visited[i] = 0;
			// 해당 번호 미선택
		}
	}
	
	static class Pair{
		private int s,b;
		private String n;
		Pair(String n,int s,int b){
			this.n = n;
			this.s = s;
			this.b = b;
		}
	}
}
