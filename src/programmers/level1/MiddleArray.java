package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class MiddleArray {	
	public static void main(String[] args) {
		// Stream을 사용하여 구할수도 있다.
		List<String> test = new ArrayList<>();
		test.add("ddd2");
		test.add("aaa2");
		test.add("bbb1");
		test.add("aaa1");
		test.add("bbb3");
		test.add("ccc");
		test.add("bbb2");
		test.add("ddd1");
		test.stream()
			.sorted()
			.filter((s) -> s.startsWith("a"))
			.forEach(System.out::printf);
	}
    static double solution(int[] arr) {
    	double sum = 0;
    	for(int t: arr) {
    		sum += t;
    	}
    	
    	return sum/arr.length;
    }
}
