package baekjoon.q10000;

import java.util.Scanner;

public class Q14391 {
	static int n,m;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 세로 크기
		m = sc.nextInt(); // 가로 크기
		arr = new int[n][m];
		visited = new int[n][m];
		for(int i=0;i<n;i++) {
			String t = sc.next();
			for(int j=0;j<m;j++)
				arr[i][j] = t.charAt(j)-'0';
		}
		// 모든 경우의 수를 보자
		solve(0,0);
		System.out.println(result);
	}
	
	// 1 가로 0 세로
	private static void check() {
		// 가로
		int sum=0;
		for(int i=0;i<n;i++) {
			int tSum=0;
			for(int j=0;j<m;j++) {
				if(visited[i][j]==1) {
					tSum*=10; // 연속될 시 자리수 올리기
					tSum+=arr[i][j];
				}else {
					sum+=tSum;
					tSum=0; // 연속이 깨질시 초기화
				}
			}
			sum+=tSum; // 한 행 계산 결과 저장
		}
		
		// 세로
		for(int i=0;i<m;i++) {
			int tSum=0;
			for(int j=0;j<n;j++) {
				if(visited[j][i]==0) {
					tSum*=10; // 연속될 시 자리수 올리기
					tSum+=arr[j][i];
				}else {
					sum+=tSum;
					tSum=0; // 연속이 깨질시 초기화
				}
			}
			sum+=tSum;
		}
		result = Math.max(result, sum);
	}
	
	static int result;
	static int[][] visited;
	private static void solve(int x,int y) {
		// 모든 선택 완료
		if(x>=n) {
			// 검사
			check();
			return;
		}
		// 한 행 선택 완료시 다음 행으로
		if(y>=m) {
			solve(x+1,0);
			return;
		}
		// 해당 좌표 선택
		visited[x][y]=1;
		solve(x, y+1);
		visited[x][y]=0;
		
		// 해당 좌표미선택
		solve(x,y+1);
	}
}
