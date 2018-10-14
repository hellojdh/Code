package swexpert.d3;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Q5688 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		solve();
		int tc = sc.nextInt();
		for(int i=1;i<=tc;i++) {
			sb.append("#"+i+" ");
			String t = sc.next();
			if(map.containsKey(t))
				sb.append(map.get(t)+"\n");
			else sb.append("-1\n");
		}
		System.out.print(sb);
	}
	
	static HashMap<String,Integer> map = new HashMap<>();
	private static void solve() {
		// 10^18이 최대이므로 10^6 승까지의 세 제곱근을 구해준다.
		for(int i=1;i<1_000_001;i++) {
			BigInteger big = new BigInteger(i+"");
			map.put(big.pow(3).toString(), i);
		}
	}
}
