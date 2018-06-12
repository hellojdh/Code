package programmers.summer2018;

public class Firth {
	public long solution(int[][] land, int P, int Q) {
		long result = 0;
		long min 	= 0;
		
		for(int i=land.length; i>0; i--) {
			for(int j=0; j<land.length; j++) {
				for(int k=0; k<land.length; k++) {
					if(land[j][k] >i) {
						result += (long)(land[j][k] - i)*(long)Q;
					}else {
						result += (long)(i - land[j][k])*(long)P;
					}
				}
				if(result >= min && min != 0) break;
			}
			if(result < min || min == 0) min = result;
			result = 0;
		}
		
		return min;			
	}
}
