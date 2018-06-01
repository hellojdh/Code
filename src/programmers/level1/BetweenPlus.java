package programmers.level1;

import java.util.Stack;

public class BetweenPlus {
	public static void main(String[] args) {
		System.out.println(solution(3,5));
		System.out.println(solution(3,3));
		System.out.println(solution(5,3));
	}
	
	public static long solution(int a, int b) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		int result = 0;
		for(int i=min; i<=max; i++) {
			result += i;
		}
		return result;
	}
}
