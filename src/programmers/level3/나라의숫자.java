package programmers.level3;

public class 나라의숫자 {
	public String solution(int n) {
		String result = "";
		int t = 0;
		while(true) {
			t = n%3;
			n = n/3;			
			if(t == 0) n-=1;
			
			switch (t) {
			case 0:
				result += "4";				
				break;
			case 1:
				result += "1";
				break;
			case 2:
				result += "2";
				break;
			}
			if(n<4) break;
		}
		return new StringBuilder(result).reverse().toString();
	}
	public static void main(String[] args) {
		float a = 123456789.0e-5f;
		System.out.printf("%f %e", a,a);
	}
}
