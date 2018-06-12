package programmers.level2;

public class 다음큰숫자 {
	public int solution(int n) {
		String c = Integer.toBinaryString(n);
		int cnt = 0;
		
		for(int i=0; i<c.length(); i++) {
			if('1' == c.charAt(i)) cnt++;
		}
		
		int t = n+1;
		int tCnt = 0;
		while(true) {
			c = Integer.toBinaryString(t++);
			for(int i=0; i<c.length(); i++) {
				if('1' == c.charAt(i)) tCnt++;
			}
			if(tCnt == cnt) break;
			tCnt = 0;
		}
		return t-1;
//		Integer.bitCount(i)
	}

}
