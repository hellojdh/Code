package programmers.level1;

import java.util.StringTokenizer;

public class 최댓값과최솟값 {
    static String solution(String s) {
    	int max = -9999999;
    	int min = 9999999;
    	
    	StringTokenizer st = new StringTokenizer(s);
    	int temp = 0;
    	while(st.hasMoreTokens()) {
    		temp = Integer.parseInt(st.nextToken());
    		if(temp > max) max = temp;
    		if(temp < min) min = temp;
    	}
    	return min+" "+max;
    }
}
