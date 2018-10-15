package baekjoon.q2000;

import java.util.Arrays;
import java.util.Scanner;

public class Q2309 {
	static int[] arr,visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		visited = new int[9];
		for(int i=0;i<9;i++)
			arr[i] = sc.nextInt();
		solve(0,0,0);
	}
	
	// 키의 합은 100, 하나만 출력하면 되므로 출력후 flag로 빠저나온다.
	static boolean flag = false;
	private static void solve(int idx,int cnt,int sum) {
		if(flag) return;
		// 7개를 모았을 때
		if(cnt==7) {
			// 합이 100이라면 
			if(sum==100) {
				int[] result = new int[7];
				// 7개 체크된 값을 받아. 출력한다.
				for(int i=0,index=0;i<9;i++)
					if(visited[i]==1) result[index++]=arr[i];
				Arrays.sort(result);
				for(int i:result)
					System.out.println(i);
				flag = true;
			}
			return;
		}
		if(idx>=9) return;
		// 현재 포함
		visited[idx] = 1;
		solve(idx+1,cnt+1,sum+arr[idx]);
		visited[idx] = 0;
		
		// 현재 미포함
		solve(idx+1,cnt,sum);
	}
}
