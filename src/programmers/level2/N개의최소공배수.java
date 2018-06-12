package programmers.level2;

import java.util.Arrays;

public class N개의최소공배수 {
	public int solution(int[] arr) {
		Arrays.sort(arr);
		int max = arr[arr.length];
		boolean check = false;
		while(true) {
			for(int i=0; i<arr.length; i++) {
				if(max % arr[i] == 0) {
					if(i == arr.length-1) check = true;
					continue;
				}
				else break;
			}
			if(check) break;
			max++;
		}
		return max;
	}
}
