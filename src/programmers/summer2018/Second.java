package programmers.summer2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Second {
	public int[] solution(int n, String words) {
		List<String> list  = new ArrayList<>();
		List<String> array = new ArrayList<>(Arrays.asList(words));
		char front = ' ';
		char back  = ' ';
		int cnt	   = 1;
		int circle = 1;
		boolean check = true;
		
		for(String t: array) {
			if(list.contains(t)) {
				check = false;
				break;
			}
			list.add(t);
			if(back != ' ') {
				front = t.charAt(0);
				if(front != back) {
					check = false;
					break;
				}
				back = t.charAt(t.length()-1);
			}else {
				back = t.charAt(t.length()-1);
			}			
			circle++;
			if(circle > n) {
				circle = 1;
				cnt++;
			}
		}
		int[] result = new int[2];
		if(check) {
			result[0] = 0; 		result[1] = 0;
		}else {
			result[0] = circle;	result[1] = cnt;
		}
		return result;		
	}
}
