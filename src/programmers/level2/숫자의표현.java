package programmers.level2;

public class 숫자의표현 {
	public int solution(int n) {
		int cnt = 0;
		int sum = 0;
		
		for(int i=1; i<n/2; i++) {
			sum = 0;
			for(int j=i; ; j++) {
				sum += j;
				if(sum == n) cnt++;
				else if(sum > n) break;
			}
		}		
		return cnt+1;
		// 주어진 자연수를 연속된 자연수로 표현하는 방법의 수는
		// 주어진 수의 홀수 약수의 개수와 같다라는 이론이 있다.
	}

}
