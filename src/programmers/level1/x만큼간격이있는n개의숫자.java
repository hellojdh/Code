package programmers.level1;

public class x만큼간격이있는n개의숫자 {
	public long[] solution(int x, int n) {
		long[] result = new long[n];
		long temp = x;
		for(int i=0; i<n; i++) {
			result[i] = temp;
			temp += x;
		}
		return result;
	}
}
