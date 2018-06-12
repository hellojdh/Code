package programmers.level1;

import java.util.Arrays;

public class 수박수박수박수박수 {
	public static void main(String[] args) {
		System.out.println(solution(7));		
	}
    static String solution(int n) {
    	char su = '수';
    	char bak = '박';
    	boolean check = true;
    	String result = "";
    	for(int i=0; i<n; i++) {
    		result += check? su:bak;
    		check = !check;
    	}
    	return result;
//    	return new String(new char [n/2+1]).replace("\0", "수박");
    }
}
