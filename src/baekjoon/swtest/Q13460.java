package baekjoon.swtest;

import java.util.Scanner;

public class Q13460 {
	static int n,m;
	static int[][] arr;
	static Pair t,t2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 세로 크기
		m = sc.nextInt(); // 가로 크기
		arr = new int[n][m];
		copy = new int[n][m];
		t = new Pair(0, 0, 0, 0);
		t2 = new Pair(0, 0, 0, 0);
		for(int i=0;i<n;i++) {
			String str = sc.next();
			for(int j=0;j<m;j++) {
				arr[i][j]= str.charAt(j);
				// R 과 B의 위치 받기
				if(arr[i][j]=='R') {
					t.rx = i; t.ry = j;
				}else if(arr[i][j]=='B'){
					t.bx = i; t.by = j;
				}
			}
		}
		// 움직이는 조합을 모두 만들어 주자.
		solve(0,-1);
		if(result==11) result=-1;
		System.out.println(result);
	}
	
	static int[][] copy;
	private static void init() {
		// R B 위치 초기화
		t2.rx = t.rx; t2.ry = t.ry;
		t2.bx = t.bx; t2.by = t.by;
		end = false; // 게임끝 초기화
		// 맵  복사
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) 
				copy[i][j] = arr[i][j];
		}
	}
	
	// 하 우 상 좌
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	private static boolean lean(int d) {
		int rx=t2.rx, ry=t2.ry, bx=t2.bx, by=t2.by;
		// R 출구 체크, RB R이 이동중 B를 만났나(만난것은 한 칸 뒤로 옮기도록)
		boolean flagR=false,flagRB=false,
				flagBR=false,flagB=false;
		// 빨강 먼저 이동
		while(true) {
			rx = rx+dir[d][0]; ry = ry+dir[d][1];
			// 길외에 것을 만난다면
			if(copy[rx][ry]!='.') {
				// 출구 일경우
				if(copy[rx][ry]=='O')
					flagR=true; // R 나감 체크
				else if(copy[rx][ry]=='B') {
					flagRB = true; // B 만남 체크
					continue; // B일경우 일단 쭉 간다.
				}
				// # 이므로 한 칸 뒤로 물려주기
				rx = rx-dir[d][0]; ry = ry-dir[d][1];
				break;
			}
		}
		// R이 움직이다 B를 만났다면 R이 한 칸뒤로 움직여야한다.
		if(flagRB) {
			rx = rx-dir[d][0];
			ry = ry-dir[d][1];
		}
		// 파랑 이동
		while(true) {
			bx = bx+dir[d][0]; by = by+dir[d][1];
			// 길외에 것을 만난다면
			if(copy[bx][by]!='.') {
				// 출구 일경우
				if(copy[bx][by]=='O')
					flagB=true; // B 나감 체크
				else if(copy[bx][by]=='R') {
					flagBR = true; // R 만남 체크
					continue; // R일경우 일단 쭉 간다.
				}
				// # 이므로 한 칸 뒤로 물려주기
				bx = bx-dir[d][0]; by = by-dir[d][1];
				break;
			}
		}
		// R은 만났고, B가 움직이다 R을 만났다면,  
		if(!flagRB && flagBR) {
			bx = bx-dir[d][0];
			by = by-dir[d][1];
		}
		// 바뀐 값들 넣어주기
		copy[t2.rx][t2.ry]='.';
		copy[rx][ry] = 'R';
		copy[t2.bx][t2.by]='.';
		copy[bx][by] = 'B';
		
		// 시작값 바꿔주기
		t2.rx=rx; t2.ry=ry;
		t2.bx=bx; t2.by=by;
		
		// B가 끝났다면 false
		if(flagB) {
			end = true; // 게임 끝
			return false;
		}
		// R이 끝났다면 true
		if(flagR) return true;
		return false;
	}
	
	// 최대 10이므로 11로 지정
	static int result=11;
	static boolean end;
	static int[] visited = new int[10];
	private static void solve(int idx,int prev) {
		// 10가지의 모든 방향이 만들어졌으면
		if(idx==10) {
			// 그 방향들 가지고 체크하기
			init(); // copy 배열 초기화
			for(int i=0;i<10;i++) {
				if(result<=i+1) return;
				if(lean(visited[i])) {
					// true라면 게임 끝. 이태까지 횟수 최소 구하기
					result = Math.min(result, i+1);
					return;
				}
				// 게임이 끝났다면 바로 끝
				if(end) break;
			}
			return;
		}
		
		// 연속적으로 같은 방향으로의 동작을 할 필요는 없다.
		for(int i=0;i<4;i++) {
			if(i==prev) continue;
			visited[idx] = i;
			solve(idx+1,i);
		}
	}
	
	static class Pair{
		int rx,ry,bx,by;
		Pair(int rx,int ry,int bx,int by){
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
		}
	}
}
