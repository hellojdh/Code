package programmers.level1;

public class 피보나치수 {
    public int solution(int n) {
    	if(n == 1 || n == 2) return 1;
    	
    	int t1 = 0;
    	int t2 = 1;
    	int result = 0;
    	for(int i=1; i<n; i++) {
    		result = (t1 + t2)%1234567;
    		t1 = t2;
    		t2 = result;
    	}
    	return result;
    }
}
