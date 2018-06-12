package programmers.level1;

import java.util.Arrays;

public class 소수찾기 {
	public static void main(String[] args) {
		String[] a = {"Jane","Kim"};
		
	}
    static int solution(int n) {
    	boolean[] result = new boolean[n+1];
    	Arrays.fill(result, true);
    	
    	for(int i=2; i<=n; i++) {
    		for(int j=2; j<=n; j++) {
    			int t = i*j;
    			if(t>n) break;    			
    			result[t] = false;
    		}
    	}
    	
    	int cnt = -2;
    	for(boolean t: result) {
    		if(t) cnt++;
    	}
    	
    	return cnt;
    }
}
