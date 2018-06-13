package programmers.level2;

import java.util.StringTokenizer;

public class 시저암호_보류 {
	public String solution(String s, int n) {
		StringTokenizer st = new StringTokenizer(s);
		
		String curr = "";
		String result = "";
		int temp = 0;
		while(st.hasMoreTokens()) {
			curr = st.nextToken();
			
			for(int i=0; i<curr.length(); i++) {
				// 소문자 일경우
				temp = curr.charAt(i);
				if(temp > 94) {
					temp = temp+n;
					if(temp >122) {
						temp = temp-122+96;
					}
				}else {
					temp = temp+n;
					if(temp >90) {
						temp = temp-90+64;
					}
				}
				result+=(char)temp;
			}
			
			if(st.hasMoreTokens()) result+=" "; 
		}		
		return result;
	}

}
