package baekjoon.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14499 {
	static int n,m,x,y,k;
	static int[][] arr,dice;
	static int[] order;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 지도 세로 크기
		m = Integer.parseInt(st.nextToken()); // 지도 가로 크기
		x = Integer.parseInt(st.nextToken()); // 주사위 놓을 곳 x
		y = Integer.parseInt(st.nextToken()); // 주사위 놓을 곳 y
		k = Integer.parseInt(st.nextToken()); // 명령의 개수
		
		// 예제에서 주사위의 전개도를 주었다. 이를 이용해 주사위를 표현해보자.
		dice = new int[4][3];
		arr = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 명령 저장
		order = new int[k];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++)
			order[i] = Integer.parseInt(st.nextToken());
		
		solve();
	}
	
	// 주사위의 윗면은 항상 dice[1][3]
	// 주사위를 굴리자!(우 좌 상 하)
	private static void change(int k) {
		int t = 0,up=0,bottom=0,left=0,right=0;
		switch (k) {
		case 1: // 오른쪽으로 굴림(바닥기준으로 앞 뒤는 동일)
			// 우측->바닥, 바닥->좌측, 좌측->윗면, 윗면->우측
			up = dice[3][1]; bottom = dice[1][1];
			left = dice[1][0]; right = dice[1][2];
			dice[1][1]=right; dice[1][0]=bottom;
			dice[3][1]=left;  dice[1][2]=up;
			break;
		case 2: // 왼쪽으로 굴림
			// 우측->윗면, 바닥->우측, 좌측->바닥, 윗면->좌측
			up = dice[3][1]; bottom = dice[1][1];
			left = dice[1][0]; right = dice[1][2];
			dice[1][1]=left;   dice[1][0]=up;
			dice[3][1]=right;  dice[1][2]=bottom;
			break;
		case 3: // 위로 굴림(좌 우는 동일)
			t = dice[3][1];
			for(int i=3;i>0;i--)
				dice[i][1] = dice[i-1][1];
			dice[0][1] = t;
			break;
		case 4: // 아래로 굴림(좌 우는 동일)
			t = dice[0][1];
			for(int i=0;i<3;i++)
				dice[i][1] = dice[i+1][1];
			dice[3][1] = t;
			break;
		}
	}
	
	// 우 좌 상 하 1 2 3 4
	static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
	private static void solve() {
		for(int i=0;i<k;i++) {
			x = x+dir[order[i]-1][0];
			y = y+dir[order[i]-1][1];
			if(x>=n || x<0 || y>=m || y<0) {
				// 지도 밖으로 나가는 경우 원상 복귀 시켜준후 다음 명령
				x = x-dir[order[i]-1][0];
				y = y-dir[order[i]-1][1];
				continue;
			}
			// 굴리기
			change(order[i]);
			// 아랫면 숫자 바꿔주기
			// 이동한 칸의 수가 0이면 바닥면 수가 칸에 복사
			if(arr[x][y]==0) arr[x][y]=dice[1][1];
			else {
				// 아닐 경우는 반대 & 칸에 쓰여있는 수가 0인된다.
				dice[1][1] = arr[x][y];
				arr[x][y] = 0;
			}
			// 윗면 출력
			System.out.println(dice[3][1]);
		}
	}
}
