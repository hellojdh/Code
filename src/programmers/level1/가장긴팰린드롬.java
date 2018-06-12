package programmers.level1;

public class 가장긴팰린드롬 {
	public static void main(String[] args) {
		System.out.println(solution("abcdcba"));
		System.out.println(solution("abbaaaaaabba"));
		System.out.println(solution("abbaaaaaa"));
		System.out.println(solution("ddaabbb"));
	}
	
	public static int solution(String s) {
		int len = s.length();
		int max = 1;
		int tMax = 1;
		int p = 0;
		for(int i=0; i<len-1; i++) {
			tMax = 1;
			if(s.charAt(i) == s.charAt(i+1)) {
				int t = i+i+1;
				tMax = 0;
				for(int j=i+1; j<=len-1; j++) {
					try {
						char left = s.charAt(t-j);
						char right = s.charAt(j);
						if(left == right) {
							tMax+=2;
						}else {
							break;
						}
					}catch(Exception e) {
						break;
					}
				}
			}
			if(tMax > max)
				max = tMax;	
			tMax = 1;
				for(int j=i-1; j>=0; j--) {
					try {
						char left = s.charAt(j);
						char right = s.charAt(i+(i-j));
						if(left == right) {
							tMax+=2;
						}else {
							break;
						}
					}catch(Exception e) {break;}
				}
				if(tMax > max)
					max = tMax;	
			}
		return max;
	}
}
