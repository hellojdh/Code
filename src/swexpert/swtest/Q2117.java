package swexpert.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2117 {
	static int n,m;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int i=1;i<=tc;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // n*n 크기의 배열
			m = Integer.parseInt(st.nextToken()); // 하나의 집이 지불하는 비용
			arr = new int[n][n];
			visited = new boolean[n][n];
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<n;k++)
					arr[j][k] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			for(int j=0;j<n;j++)
				for(int k=0;k<n;k++)
					solve(j,k);
			sb.append("#"+i+" "+max+"\n");
		}
		System.out.print(sb);
	}
	
	static int max;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	private static void solve(int x,int y) {
		Queue<Pair> queue = new LinkedList<>();
		List<Pair> list = new ArrayList<>();
		list.add(new Pair(x, y, 1));
		init(); // 새 좌표마다 초기화 해주기
		// 보안 구역 맵 끝까지 키우기 (한쪽 끝에서 시작해도 반대쪽까지 다 닿을 정도)
		int sum = 0;
		if(arr[x][y]==1) sum++;
		for(int i=1;i<2*n+1;i++) {
			for(Pair t:list)
				queue.add(t);
			list.clear();
			visited[x][y] = true;
			while(!queue.isEmpty()) {
				Pair t = queue.poll();
				if(t.cnt==i) {
					// 새로 그리는게 아니고 +1 칸씩 시켜주는 것이므로 이어서 나가자
					list.add(new Pair(t.x,t.y,t.cnt));
					continue;
				}
				for(int j=0;j<4;j++) {
					int tx = t.x+dir[j][0];
					int ty = t.y+dir[j][1];
					if(tx<0 || ty<0 || tx>=n || ty>=n) continue;
					if(visited[tx][ty]) continue;
					visited[tx][ty] = true;
					if(arr[tx][ty]==1) sum++;
					queue.add(new Pair(tx, ty, t.cnt+1));
				}
			}
			// 운영 비용이 더 많이 들면 처리 x
			if((sum*m)-(i*i+(i-1)*(i-1))<0){}
			else {
				// 아니라면 현 집 계수 최대값 계산
				max = Math.max(max, sum);
			}
		}
	}
	
	private static void init() {
		for(int i=0;i<n;i++)
			Arrays.fill(visited[i],false);
	}
	
	static class Pair{
		private int x,y,cnt;
		public Pair(int x,int y,int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt; // 보안 구역 만들기 체크
		}
	}
}