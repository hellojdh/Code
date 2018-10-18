package baekjoon.swtest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q14502 {
	static int n,m;
	static int[][] arr,copy;
	static List<Pair> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt(); // 세로 크기
    	m = sc.nextInt(); // 가로 크기
    	arr = new int[n][m];
    	copy = new int[n][m];
    	visited = new boolean[n][m];
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			arr[i][j] = sc.nextInt();
    			// 바이러스 장소 넣어주기
    			if(arr[i][j]==2) list.add(new Pair(i, j));
    			else if(arr[i][j]==0) safeCnt++;
    		}
    	}
    	// 결과값 초기화
    	result = 0;
    	solve(0,0,0);
    	// 벽을 세우는데 3개를 사용했기 때문에 -3을 해준다.
    	System.out.println(result-3);
    }
    
    private static void solve(int x,int y,int cnt) {
    	// 벽 3개를 세웠으면 체크하러 가기
    	if(cnt==3) {
    		check();
    		return;
    	}
    	
    	// y index가 범위를 넘겼으면 x를 +1시켜 다음줄로.
    	if(y>=m) {
    		solve(x+1,0,cnt);
    		return;
    	}
    	
    	// x index가 범위를 넘겼으면 끝.
    	if(x>=n) return;
    	
    	
    	// 맵에서 해당 장소가 0 즉, 벽을 세울 수 있다면 세워주자.
    	if(arr[x][y]==0) {
    		arr[x][y] = 1;
    		solve(x,y+1,cnt+1);
    		arr[x][y] = 0;
    	}
    	// 세울 수 없다면 그냥 다음 index로 넘겨주자.
    	solve(x,y+1,cnt);
    }
    
    static int result,safeCnt;
    static boolean[][] visited;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static void check() {
    	init(); // 검사전 초기화
    	Queue<Pair> queue = new LinkedList<>();
    	int safe = safeCnt;
    	// 바이러스 queue에 넣어주기
    	for(Pair t:list) {
    		visited[t.x][t.y] = true;
    		queue.add(t);
    	}
    	// 바이러스 퍼트리기
    	while(!queue.isEmpty()) {
    		Pair t = queue.poll();
    		for(int i=0;i<4;i++) {
    			int tx = t.x+dir[i][0];
    			int ty = t.y+dir[i][1];
    			if(tx<0 || ty<0 || tx>=n || ty>=m) continue;
    			if(visited[tx][ty]) continue;
    			if(arr[tx][ty]==0) {
    				visited[tx][ty] = true;
    				queue.add(new Pair(tx, ty));
    				safe--; // 안전 범위 개수 감소
    			}
    		}
    	}
    	// safe(이번 케이스의 안전 범위 개수)와 전체 값 비교
    	result = Math.max(result, safe);
    }
    
    // 검사하기전 맵 & 방문 초기화
    private static void init() {
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			copy[i][j] = arr[i][j];
    			visited[i][j] = false;
    		}
    	}
    }
    
    static class Pair{
    	private int x,y;
    	Pair(int x,int y){
    		this.x = x;
    		this.y = y;
    	}
    }
}
