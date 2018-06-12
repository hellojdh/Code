package programmers.level1;

public class 정수내림차순으로배치하기 {
    static long solution(long n) {
    	String t = n+"";
    	int[] array = new int[10];
    	
    	int temp = 0;
    	for(int i=0; i<t.length(); i++) {
    		temp = Integer.parseInt(t.charAt(i)+"");
    		array[temp]++;
    	}
    	
    	String result = "";
    	for(int i=9; i>0; i--) {
    		for(int j=0; j<array[i]; j++) {
    			result+=i;
    		}
    	}
    	
    	return Long.parseLong(result);
    }
}
