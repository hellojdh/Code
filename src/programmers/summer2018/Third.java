package programmers.summer2018;

import java.util.Arrays;

public class Third {
	public int solution(int[] A, int[] B) {
		int wCnt = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		
		// O(N^2)
		int t = 0;
		for(int i=0; i<A.length; i++) {
			for(int j=t; j<B.length; j++) {
				if(A[i] < B[j]) {
					wCnt++;
					t = j+1;
					break;
				}
			}
		}
		
		return wCnt;
	}
}
