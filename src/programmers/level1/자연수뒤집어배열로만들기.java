package programmers.level1;

public class 자연수뒤집어배열로만들기 {
	public static void main(String[] args) {
		solution(12345);
	}
    static int[] solution(long n) {
    	int len = String.valueOf(n).length();
    	String t = n+"";
    	int[] result = new int[len];
    	
    	for(int i=0,j=len-1; i<len; i++,j--) {
    		result[j] = Integer.parseInt(t.charAt(i)+"");
    		System.out.println(t.charAt(i));
    	}
    	
    	return result;
    	
    }
}
