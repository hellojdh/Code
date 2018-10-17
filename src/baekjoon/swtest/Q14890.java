package baekjoon.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14890 {
	static int n,l;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		for(int i=0;i<n;i++) {
			if(solve(i,0,0)) result++;
			if(solve(0,i,1)) result++;
		}
		System.out.println(result);
	}
	
	private static boolean solve(int x,int y,int sw) {
		int t = arr[x][y]; // 처음위치 저장
		int cnt = 0;
		boolean flag = false; // 낮아진 부분 판단
		for(int i=0;i<n;i++) {
			// 이전것 tt sw의 값에 따라 행검사 열검사
			int tt = (sw==0?arr[x][i]:arr[i][y]);
			// 이전 것과 같다면 개수 +1
			if(tt==t) {
				cnt++;
				// 낮아졌단은 판단이 있을 때, 세는 개수가 L개가 된다면
				if(flag && cnt>=l) {
					flag = false;
					cnt-=l; // 쌓은거에서 l개만큼 빼주기
				}
			}else if(Math.abs(tt-t)!=1) {
				// 높이 차이가 1이 넘으면 false
				return false;
			}else if(tt>t) {
				// flag 가 true일 경우 개수를 따져줘서 아니면 false
				if(flag) {
					if(cnt<l) return false;
					else cnt=0;
				}
				// 이전 것 보다 크다면 이태까지 cnt의 개수로 판단
				if(cnt<l) return false;
				cnt=1; // cnt 초기화
			}else if(tt<t) {
				// flag가 true일 경우, cnt개수로 따져주기
				if(flag) if(cnt<l) return false;
				// 이전 것 보다 작아진다면 앞으로 L개가 모이면 가능.
				flag = true;
				cnt=1;
			}
			t = tt;
		}
		if(flag) if(cnt<l) return false;
		return true;
	}
}
