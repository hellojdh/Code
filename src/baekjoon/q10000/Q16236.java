package baekjoon.q10000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16236 {
	static int n,x,y;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
				// 아기 상어 최초 위치
				if(arr[i][j]==9) {
					x=i;y=j;
				}
			}
		}
		// 먹이 탐색할 때 중복 제거
		visited = new boolean[n][n];
		solve();
	}
	
	// 최적의 먹이를 먹고 다시 먹이 탐색할 때
	private static void init() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				visited[i][j] = false;
		}
	}
	
	static boolean[][] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	private static void solve() {
		Queue<Pair> queue = new LinkedList<>();
		// 초기 크기 2
		queue.add(new Pair(x,y,2,0,0));
		visited[x][y] = true;
		// 걸린 시간
		int result = 0;
		while(!queue.isEmpty()) {
			int eatX=99,eatY=99; // 먹이감 발견시 그 위치
			int eat=0,big=0,cnt=0; // for문으로 한 cnt씩 봐주므로, t를 밖에서 사용하기 위해
			int size = queue.size();
			// 최소로 도달하면 거기서 부터 다시 탐색을 해야하기 때문에
			// 같은 cnt씩 묶어서 봐준다.
			for(int j=0;j<size;j++) {
				Pair t = queue.poll();
				for(int i=0;i<4;i++) {
					int tx = t.x+dir[i][0];
					int ty = t.y+dir[i][1];
					if(tx<0 || ty<0 || tx>=n || ty>=n) continue;
					if(visited[tx][ty]) continue;
					// 현 몸집부다 크면 못 지나감
					if(arr[tx][ty]>t.big) continue;
					visited[tx][ty]=true;
					queue.add(new Pair(tx,ty,t.big,t.eat,t.cnt+1));
					// 아기 상어보다 작은 먹이를 발견하면
					if(arr[tx][ty]!=0&& arr[tx][ty]!=t.big) {
						// 조건에 따라서 위쪽  & 왼쪽이 우선권
						if(tx<eatX) {
							eatY = ty;
							eatX = tx;
							eat = t.eat;
							big = t.big;
							cnt = t.cnt+1;
						}else if(tx==eatX) {
							if(ty<eatY) {
								eatY = ty;
								eatX = tx;
								eat = t.eat;
								big = t.big;
								cnt = t.cnt+1;
							}
						}
					}
				}
			}
			// eatX가 바뀌었다는것은 이번 cnt에서 먹을것이 있다는 뜻.
			if(eatX!=99) {
				eat++; // 아그작 먹자
				// 크기 커지기
				if(eat==big) {
					big++;
					eat=0;
				}
				// 현 먹이 먹은 곳으로 아기 상어 이동
				arr[x][y] = 0;
				arr[eatX][eatY] = 9;
				result += cnt; // 거기까지의 탐색 거리
				x = eatX; y = eatY; // 아기 상어 위치 이동
				init(); // 재 탐색을 위한 방문 초기화
				queue.clear(); // 탐색하던 것들은 필요 없으므로 제거
				visited[eatX][eatY] = true;
				// 현 위치에서 아기상어 다시 탐색
				queue.add(new Pair(eatX,eatY,big,eat,0));
			}
		}
		System.out.println(result);
	}
	
	static class Pair{
		int x,y,big,eat,cnt;
		Pair(int x,int y,int big,int eat,int cnt){
			this.x = x;
			this.y = y;
			this.big = big;
			this.eat = eat;
			this.cnt = cnt;
		}
	}
}
