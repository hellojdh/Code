package swexpert.d3;

import java.util.Scanner;

public class Q5549 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		for(int i=1;i<=tc;i++) {
			String t = sc.next();
			int last = Integer.parseInt(t.substring(t.length()-1));
			if(last%2==0) sb.append("#"+i+" Even\n");
			else sb.append("#"+i+" Odd\n");
		}
		System.out.print(sb);
	}
}
