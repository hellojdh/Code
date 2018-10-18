package baekjoon.swtest;

import java.io.IOException;
import java.util.Scanner;

public class Q12100 {
	static int n;
	static int[] dArr;
	static int[][] arr;
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	arr = new int[n][n];
    	copy = new int[n][n];
    	// 방향을 저장하고 있을 arr
    	dArr = new int[5];
    	visited = new int[n][n];
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++)
    			arr[i][j] = sc.nextInt();
    	}
    	result = 0;
    	init();
    	// DFS를 통해 모든 조건 만들어 주기
    	solve(0);
    	System.out.println(result);
    }
    
    // 상 하 좌 우 모든 경우를 살펴보자, 최대 5번
    static int result;
    private static void solve(int idx) {
    	// 방향 5개가 완성되었다면
    	if(idx==5) {
    		// 새로쓸 배열 초기화
    		init();
    		for(int i=0;i<5;i++) {
    			// 해당 방향으로 기울이기
    			twist(dArr[i]);
    			init2();
    		}
			// 최대 값 찾기
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++)
					result = Math.max(copy[j][k], result);
			}
    		return;
    	}
    	
    	// 모든 방향을 만들어보자.
    	for(int i=0;i<4;i++) {
    		dArr[idx] = i;
    		solve(idx+1);
    	}
    }
    
    private static void change(int sw) {
    	if(sw==2) {
    		// 좌우 바꿔주기
	    	for(int i=0;i<n;i++) {
	    		for(int j=0;j<n/2;j++) {
	    			int t = copy[i][n-j-1];
	    			copy[i][n-j-1] = copy[i][j];
	    			copy[i][j] = t;
	    		}
	    	}
    	}else {
    		// 상하 바꿔주기
	    	for(int i=0;i<n/2;i++) {
	    		for(int j=0;j<n;j++) {
	    			int t = copy[n-i-1][j];
	    			copy[n-i-1][j] = copy[i][j];
	    			copy[i][j] = t;
	    		}
	    	}
    	}
    }
    
    static int[][] visited;
    // 상 하 좌 우
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    private static void twist(int d) {
    	// 아래와 오른쪽 인경우 반대로 봐줘야 하므로 뒤집어 주자
    	boolean dFlag = false;
    	if(d==3) {
    		change(2);
    		dFlag = true;
    		d=2;
    	}else if(d==1) {
    		change(0);
    		dFlag = true;
    		d=0;
    	}
		for(int j=0;j<n;j++) {
			for(int i=0;i<n;i++) {
				if(copy[i][j]==0) continue;
				int tx = i+dir[d][0];
				int ty = j+dir[d][1];
				// 범위 벗어났으면 그대로
				if(tx<0 || ty<0 || tx>=n ||ty>=n) continue;
				// 다음께 0이라면 -> 0이 아닐때까지 찾아주자
				boolean flag = false;
				if(copy[tx][ty]==0) {
					while(copy[tx][ty]==0) {
						tx = tx+dir[d][0];
						ty = ty+dir[d][1];
						if(tx<0 || ty<0 || tx>=n ||ty>=n) {
							// 범위를 넘어가면 전꺼로 돌려주기
							tx = tx-dir[d][0];
							ty = ty-dir[d][1];
							flag = true;
							break;
						}
					}
					// 끝 부분 도착일 경우
					if(flag) {
						copy[tx][ty] = copy[i][j];
						copy[i][j] =0;
						continue;
					}
					// 0이 아니면 나오게 된다. -> 같은지 보고 결정
					if((copy[tx][ty]==copy[i][j])&&visited[tx][ty]==0) {
						// 같다면 합쳐주기
						copy[tx][ty]*=2;
						// 현재 것은 0으로
						copy[i][j]=0;
						// 이번에 합친곳 방문 처리
						visited[tx][ty] = 1;
					}else {
						// 다르다면 전 것 까지 옮겨주기
						tx = tx-dir[d][0];
						ty = ty-dir[d][1];
						copy[tx][ty] = copy[i][j];
						copy[i][j] = 0;
					}
				}else {
					// 다음께 0이 아니라면-> 같은지 보고 결정
					if((copy[tx][ty]==copy[i][j])&&visited[tx][ty]==0) {
						// 같다면 합쳐주기
						copy[tx][ty]*=2;
						// 현재 것은 0으로
						copy[i][j]=0;
						// 이번에 합친곳 방문 처리
						visited[tx][ty] = 1;
					}
				}
			}
		}
		if(dFlag) change(d);
    }
    private static void init2() {
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++)
    			visited[i][j]=0;
    	}
    }
    
    static int[][] copy;
    private static void init() {
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++)
    			copy[i][j]=arr[i][j];
    	}
    }
}
