package programmers.level1;

import java.util.Stack;

public class OpenClose {
	public static void main(String[] args) {
		System.out.println(solution("()()"));
		System.out.println(solution("(())()"));
		System.out.println(solution(")()("));
		System.out.println(solution("(()("));
	}
	
	public static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		if(s.charAt(0) == ')') return false;
		for(int i=0; i<s.length(); i++) {
			switch(s.charAt(i)) {
			case '(':
				stack.push('(');
				break;
			case ')':
				try {
					stack.pop();
				}catch(Exception e) {
					return false;
				}
			}
		}
		if(!stack.isEmpty()) return false;
		return true;
	}
}
