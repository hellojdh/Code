package baekjoon.swtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q15686 {
	static int n,m;
	static int[][] arr;
	static List<Pair> list = new ArrayList<>();
	static List<Pair> list2 = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][n];
		// list는 치킨집
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==2)
					list.add(new Pair(i, j));
				if(arr[i][j]==1)
					list2.add(new Pair(i,j));
			}
		}
		solve();
	}
	
	private static void solve() {
		int result = Integer.MAX_VALUE;
		int size = list.size();
		int size2 = list2.size();
		for(int i=0;i<(1<<size);i++) {
			// m개 이하로 선택하면 
			int cnt = Integer.bitCount(i);
			// m이 1이상이므로 다 망할경우는 없다.
			if(cnt==0) continue;
			if(cnt<=m) {
				// 치킨 집들중에 거리가 가장 짧은게 치킨 거리
				int sum = 0;
				// 집(사람) 마다 생존한 모든 치킨집과 거리를 따져 최소값을 구해준다.
				for(int k=0;k<size2;k++) {
					// N이 최대 50일 경우, 49+49 = 98이므로 100으로 잡아주었다.
					int min = 100;
					for(int j=0;j<size;j++) {
						if(((1<<j)&i)>0) {
							// 집(사람)과 망하지 않을 치킨집의 거리 계산
							int t = Math.abs(list2.get(k).x-list.get(j).x)
									+Math.abs(list2.get(k).y-list.get(j).y);
							// 그 집의 가장 짧은 치킨 거리 찾기
							if(min>t) min = t;
						}
					}
					// 집마다의 치킨 거리를 더해주기
					sum += min;
				}
				// 모든 도시의 치킨 거리의 최소 찾기
				result = Math.min(result, sum);
			}
		}
		System.out.println(result);
	}
	
	static class Pair{
		private int x,y;
		Pair(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
