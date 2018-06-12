package programmers.level2;

import java.util.Arrays;

public class 야근지수 {
	public long solution(int n, int[] works) {
        Arrays.sort(works); 
		for(int i=0; i<n; i++) {
			int t = findBig(works);
			works[t] = works[t]-1;
		}		
		long result = 0;
		for(int t: works) {
			if(t<=0) continue;
			result += t*t;
		}		
		return result;
	}
	
	public int findBig(int[] works) {
		int big	   = 0;
        int result = 0;
		for(int i=works.length-1; i>=0; i--) {
			if(works[i] > big){
                if(big != 0){
                    result = i;
                    break;  
                } 
                big = works[i];
                result = i;
            }
		}
		return result;
	}	
}
