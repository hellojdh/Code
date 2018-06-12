package programmers.level1;

public class 하샤드수 {
    public boolean solution(int x) {
    	String t = String.valueOf(x);    	
    	int sum = 0;
    	
    	for(int i=0; i<t.length(); i++) {
    		sum += Integer.parseInt(t.charAt(i)+"");
    	}    	
    	return x%sum==0;
    }
}
