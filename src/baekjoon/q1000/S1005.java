package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 위상 정렬 그래프 탐색 선행 탐색
public class S1005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int caseNum = Integer.parseInt(br.readLine());		
		for(int i=0; i<caseNum; i++) {
			String[] st = br.readLine().split(" ");
			int b = Integer.parseInt(st[0]);
			int l = Integer.parseInt(st[1]);
			// 공간복잡도 O(N)
			int[] time = new int[b+1];
			
			st = br.readLine().split(" ");
			for(int j=1; j<=b; j++) {
				time[j] = Integer.parseInt(st[j-1]);
			}
			
			ArrayList<ArrayList<Integer>> grape = new ArrayList<>();
			ArrayList<ArrayList<Integer>> grapeF = new ArrayList<>();
			for(int j=0; j<=b; j++) {
				grape.add(new ArrayList<>());
				grapeF.add(new ArrayList<>());
			}
			
			for(int j=0; j<l; j++) {
				st = br.readLine().split(" ");
				grape.get(Integer.parseInt(st[1])).add(Integer.parseInt(st[0]));
				grapeF.get(Integer.parseInt(st[0])).add(Integer.parseInt(st[1]));
			}
			
			int target = Integer.parseInt(br.readLine());
			Queue<Integer> queue = new LinkedList<>();
			// 공간복잡도 O(2N)
			int dp[] = new int[b+1];
			for(int j=1; j<=b; j++) {
				if(grape.get(j).isEmpty()) {
					dp[j] = time[j];
					queue.add(j);
				}				
			}
			
			while(!queue.isEmpty()) {
				int j = queue.remove();
				if(j == target) break;
				for(int curr: grapeF.get(j)) {
					if(dp[curr] < dp[j] + time[curr]) {
						dp[curr] = dp[j] + time[curr];
					}
					queue.add(curr);
				}
			}
			System.out.println(dp[target]);
		}
		br.close();
	}
}