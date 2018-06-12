package programmers.level1;

public class 핸드폰번호가리기 {
    static String solution(String phone_number) {
    	int star = phone_number.length() -4;
    	String result = "";
    	for(int i=0; i<star; i++) {
    		result += "*";
    	}
    	result += phone_number.substring(star);
    	return result;
    	
    }
}
