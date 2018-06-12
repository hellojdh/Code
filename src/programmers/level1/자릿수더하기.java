package programmers.level1;

public class 자릿수더하기 {
    static int solution(int n) {
    	String r = n+"";
    	int result = 0;
    	for(int i=0; i<r.length(); i++) {
    		result += Integer.parseInt(r.substring(i, i+1));
    	}
    	return result;
    }
}
