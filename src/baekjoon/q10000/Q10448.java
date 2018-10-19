package baekjoon.q10000;

import java.util.Scanner;

public class Q10448 {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=0;i<tc;i++) {
			n = sc.nextInt();
			// 1~1000 으로 삼각수로 수가 증가하면 별로 많지 않고 3개로 만들 수 있는가 이므로
			// 완전 탐색을 진행한다.
			result = 0;
			solve(0);
			System.out.println(result);
		}
	}
	
	static int result,num;
	private static void solve(int cnt) {
		// 되는 결과가 나왔다면 탐색이 필요 없으므로 return
		if(result==1) return;
		
		// 삼각수 3개를 모으면 결과 확인
		if(cnt==3) {
			if(num==n) result = 1;
			return;
		}
		
		// 앞에서 부터 삼각수 들을 더해주자.
		for(int i=1,t=2;i<1000;i+=t++) {
			// i가 n을 넘는다면 더하지 않아도 된다.
			if(i>n) return;
			// cnt가 0 일 경우를 제외한 값은 더해주기
			if(cnt==0) num=i;
			else num+=i;
			solve(cnt+1);
			// 더했던 값 다시 빼주기
			if(cnt!=0) num-=i;
		}
	}
}
