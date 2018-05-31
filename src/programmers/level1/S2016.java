package programmers.level1;

import java.util.Calendar;

// 요일 Calendar 날짜 간단
public class S2016 {
	public static void main(String[] args) {
		solution(5, 24);
	}
	public static String solution(int a, int b) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(2016, a-1, 24);
		switch(calendar.get(calendar.DAY_OF_WEEK)){
	        case 1:
	        	return "SUN";
	        case 2:
	        	return "MON";
	        case 3:
	        	return "TUE";
	        case 4:
	        	return "WED";
	        case 5:
	        	return "THU";
	        case 6:
	        	return "FRI";
	        case 7:
	        	return "SAT";          
	    }
		return "";
		/////////////////////// 더 간단히 바꾸기 ////////////////////////
//	    Calendar calendar = Calendar.getInstance();
//      calendar.set(2016, a-1, b);
//      return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT,new Locale("ko-KR")).toUpperCase();		
	}
}
