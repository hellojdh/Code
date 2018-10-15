package swexpert.d4;

import java.io.IOException;
import java.util.Scanner;

public class Q4796 {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// Input 파일 문제로 Scanner 사용
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int tc = Integer.parseInt(br.readLine());
		int tc = sc.nextInt();
		for(int i=1;i<=tc;i++) {
//			n = Integer.parseInt(br.readLine());
			n = sc.nextInt();
//			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n];
			for(int j=0;j<n;j++)
				arr[j] = sc.nextInt();
//				arr[j] = Integer.parseInt(st.nextToken());

			System.out.println("#"+i+" "+solve());
		}
	}
	
	private static int solve() {
		int result = 0;
		// 2중 반복문으로 전체를 봐도 되지만, n이 최대 1억이므로 시간 초과의 가능성이 있다.
		// 따라서 1 2 3 7 6 5 4 일경우 올라가는것 3개, 내려가는것 3개로 9개의 조합이 가능해진다.
		// 이 개수 만큼 + 를 시키면서 반복문을 진행해주자.
		
		for(int j=0;j<n;) {
			int num = arr[j];
			boolean flag = true;
			int cntUp = 1,cntDown = 0;
			for(int k=j+1;k<n;k++) {
				// true일 경우는 커저야한다.
				if(flag) {
					// 커질경우
					if(num<arr[k]) {
						num = arr[k];
						cntUp++;
					}else {
						// 작아질 경우
						flag = false;
						num = arr[k];
						cntUp--;
						cntDown++;
					}
				}else {
					// false일 경우는 작아저야한다.
					if(num>arr[k]) {
						cntDown++;
						num = arr[k];
					}else {
						break;
					}
				}
			}
			// 조합 계산
			result += (cntUp*cntDown);
			// j 값 idx 올려주기
			j += cntUp+cntDown;
		}
		return result;
	}
}
