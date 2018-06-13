package programmers.level1;

import java.util.StringTokenizer;

public class 이상한문자만들기_보류 {
    static String solution(String s) {
    	StringTokenizer st = new StringTokenizer(s);
    	String result = "";
    	String target = "";
    	String temp	  = "";
    	while(st.hasMoreTokens()) {
    		target = st.nextToken();
    		temp = "";
    		for(int i=0; i<target.length(); i++) {
    			if(i%2 == 0) temp += target.substring(i, i+1).toUpperCase();
    			else temp += target.substring(i,i+1).toLowerCase();
    		}
    		for(int i=0; i<s.length(); i++) {
    			
    		}
    		if(st.hasMoreTokens()) {
    			result += temp+" ";
    		}else {
    			result += temp;
    		}
    	}
    	return result;
    }
}
