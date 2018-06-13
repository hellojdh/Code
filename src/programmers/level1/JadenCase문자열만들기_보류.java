package programmers.level1;

import java.util.StringTokenizer;

// 보류 문제
public class JadenCase문자열만들기_보류 {
	
    public static String solution(String s) {
    	String[] temp = s.split(" ");
    	String result = "";
    	for(int i=0; i<temp.length; i++) {
    		result += temp[i].substring(0,1).toUpperCase() + temp[i].substring(1).toLowerCase();
    		if(i != temp.length-1) result += " ";
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		int[] t = {1,2,3,4,5};
	}
}
