package programmers.level1;

import java.util.Arrays;

public class 서울에서김서방찾기 {
	public static void main(String[] args) {
		String[] a = {"Jane","Kim"};
		System.out.println(solution(a));
		
	}
    static String solution(String[] seoul) {
//    	int result = 0;
//    	for(int i=0; i<seoul.length; i++) {
//    		if(seoul[i] == "Kim") {
//    			result = i;
//    			break;
//    		}
//    	}    	
//    	return "김서방은 "+result+"에 있다";
    	
    	return "김서방은 "+Arrays.asList(seoul).indexOf("Kim")+"에 있다";
    }
}
