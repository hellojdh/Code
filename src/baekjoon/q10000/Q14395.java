package baekjoon.q10000;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q14395 {
	static long s,t;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextLong();
		t = sc.nextLong();
		if(s==t) System.out.println(0);
		else System.out.println(solve());
	}
	
	static HashSet<Long> set = new HashSet<>();
	// 우선 순위는 * + - /
	private static String solve() {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(s, ""));
		set.add(s);
		while(!queue.isEmpty()) {
			Pair n = queue.poll();
			if(n.n==t) {
				return n.cal;
			}
			for(int i=0;i<4;i++) {
				long tN = cal(n.n,i);
				if(tN<1) continue;
				if(set.contains(tN)) continue;
				set.add(tN);
				queue.add(new Pair(tN, n.cal+dir[i]));
			}
		}
		return "-1";
	}
	
	static String[] dir = {"*","+","-","/"};
	private static long cal(long n,int sw) {
		switch (sw) {
		case 0: return n*n;
		case 1: return n+n;
		case 2: return n-n;
		case 3: return n/n;
		}
		return 0;
	}
	
	static class Pair{
		long n;
		String cal;
		Pair(long n,String cal){
			this.n= n;
			this.cal = cal;
		}
	}
}
