package swexpert.d3;

import java.util.Scanner;

public class Q5431 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		for(int i=1;i<=tc;i++) {
			int n = sc.nextInt();// 수강생 수
			int k = sc.nextInt();// 과제 제출자 수
			int[] arr = new int[n+1];
			// 제출자 체크
			for(int j=0;j<k;j++)
				arr[sc.nextInt()]=1;
			sb.append("#"+i+" ");
			for(int j=1;j<=n;j++) {
				if(arr[j]==0) sb.append(j+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
