package swexpert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5550 {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i=1;i<=tc;i++) {
			String t = br.readLine();
			int result = 0; // 개구리 수
			int tResult = 0; // 잉여 개구리 수
			boolean flag = true;
			arr = new int[5]; // c r o a k
			// 각 문자마다 +1을 시켜주고 다음번 문자에서는 전 문자를 -1 시켜준다.
			// k 까지 잘 도착시 tResult(잉여 개구리수)를 +1 시켜준다.
			// c가 처음부터 시작할 때 잉여 개구리수가 있다면 그 개구리로 시작 -> 전체 결과 영향 x
			for(int j=0;j<t.length();j++) {
				switch (t.charAt(j)) {
				case 'c':
					if(tResult!=0) {
						tResult--;
						result--;
					}
					result++;
					arr[0]++;
					break;
				case 'r':
					arr[0]--; arr[1]++;
					if(arr[0]<0) {
						flag = false;
						result = -1;
					}
					break;
				case 'o':
					arr[1]--; arr[2]++;
					if(arr[1]<0) {
						flag = false;
						result = -1;
					}
					break;
				case 'a':
					arr[2]--; arr[3]++;
					if(arr[2]<0) {
						flag = false;
						result = -1;
					}
					break;
				case 'k':
					arr[3]--; tResult++;
					if(arr[3]<0) {
						flag = false;
						result = -1;
					}
					break;
				}
				if(!flag) break;
			}
			// 개수가 남아 있을 경우 불가능
			for(int j=0;j<5;j++) {
				if(arr[j]!=0) {
					result=-1;
					break;
				}
			}
			System.out.println("#"+i+" "+result);
		}
	}
}
