package programmers.level1;

public class 문자열다루기기본 {
	public static void main(String[] args) {
		System.out.println(solution("1234"));
	}
    static boolean solution(String s) {
    	int len = s.length();
    	if(len == 4 || len == 6) {
    		for(int i=0; i<len; i++) {
    			try {
    				Integer.parseInt(s.substring(i, i+1));
    			}catch(Exception e) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
}
