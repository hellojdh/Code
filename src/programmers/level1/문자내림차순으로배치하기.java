package programmers.level1;

import java.util.Arrays;

public class 문자내림차순으로배치하기 {
	public String solution(String s) {
		char[] result = s.toCharArray();
		Arrays.sort(result);
		return new StringBuilder(result.toString()).reverse().toString();
	}
}
