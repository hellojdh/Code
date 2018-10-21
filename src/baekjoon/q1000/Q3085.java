package baekjoon.q1000;

import java.util.Scanner;

public class Q3085 {
	static int n;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		for(int i=0;i<n;i++) {
			String t = sc.next();
			for(int j=0;j<n;j++)
				arr[i][j] = t.charAt(j);
		}
		// 결과 초기화
		result = 0;
		
		// 다 바꿔보자
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				solve(i,j);
		}
		System.out.println(result);
	}
	
	static int result;
	private static void solve(int x,int y) {
		// 인근 칸만 바꿀 수 있으므로 자신의 오른쪽과 아래를 바꿔보자.
		
		// 1) 오른쪽 바꾸기
		if(y<n-1) {
			int t = arr[x][y];
			arr[x][y] = arr[x][y+1];
			arr[x][y+1] = t;
			// 검사
			check(x,y);
			// 원상 복귀
			arr[x][y+1] = arr[x][y];
			arr[x][y] = t;
		}
		// 2) 아래 바꾸기
		if(x<n-1) {
			int t = arr[x][y];
			arr[x][y] = arr[x+1][y];
			arr[x+1][y] = t;
			// 검사
			check2(x,y);
			// 원상 복귀
			arr[x+1][y] = arr[x][y];
			arr[x][y] = t;
		}
	}
	
	private static void check2(int x,int y) {
		int ty = arr[0][y], tx1=arr[x][0], tx2=arr[x+1][0];
		int xCnt = 0, yCnt1=0, yCnt2=0;
		for(int i=0;i<n;i++) {
			// 세로를 바꿧을 때는 행 두개 열 하나 검사
			if(tx1==arr[x][i]) {
				yCnt1++;
			}else {
				tx1 = arr[x][i];
				yCnt1=1;
			}
			if(tx2==arr[x+1][i]) {
				yCnt2++;
			}else {
				tx2 = arr[x+1][i];
				yCnt2=1;
			}
			
			if(ty==arr[i][y]) {
				xCnt++;
			}else {
				ty = arr[i][y];
				xCnt=1;
			}
			result=Math.max(result,Math.max(xCnt, Math.max(yCnt1,yCnt2)));
		}
	}
	
	private static void check(int x,int y) {
		int ty = arr[x][0], tx1=arr[0][y], tx2=arr[0][y+1];
		int yCnt = 0, xCnt1=0, xCnt2=0;
		for(int i=0;i<n;i++) {
			// 가로를 바꿧을 때는 열 두개 행 하나 검사
			if(tx1==arr[i][y]) {
				xCnt1++;
			}else {
				tx1 = arr[i][y];
				xCnt1=1;
			}
			
			if(tx2==arr[i][y+1]) {
				xCnt2++;
			}else {
				tx2 = arr[i][y+1];
				xCnt2=1;
			}
			
			if(ty==arr[x][i]) {
				yCnt++;
			}else {
				ty = arr[x][i];
				yCnt=1;
			}
			result=Math.max(result,Math.max(yCnt, Math.max(xCnt1,xCnt2)));
		}
	}
}
