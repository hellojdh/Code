package programmers.level1;

public class 문자열내p와y의개수 {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        s = s.toLowerCase();
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i) == 'p')
        		p++;
        	else if(s.charAt(i) == 'y')
        		y++;
        }

        return p==y;
        
//        s = s.toLowerCase();
//        return s.chars().filter((value)->'p'==value).count() 
//        		== s.chars().filter((value)->'y'==value).count();
//        조금 느리긴 하지만 간단히 표현가능
    }
}
