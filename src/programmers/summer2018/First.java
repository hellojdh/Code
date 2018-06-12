package programmers.summer2018;

import java.util.Arrays;

public class First {
	public int solution(int[] d, int budget) {
		Arrays.sort(d);
		
		int sum  = 0;
		int cnt  = 0;
		for(int i=0; i<d.length; i++) {
			sum += d[i];
			if(sum > budget) break;
			cnt++;
		}
		return cnt;
	}
}
