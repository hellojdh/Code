package baekjoon.q1000;

import java.util.Scanner;

public class Q1107 {
	static int n,k;
	static String tN;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 이동 하고자하는 채널
		k = sc.nextInt(); // 고장난 버튼 수
		arr = new int[10]; // 버튼
		
		// 고장난 버튼 입력 받기
		for(int i=0;i<k;i++)
			arr[sc.nextInt()]++;
		
		// 현 채널은 100번이다.
		// 1) + - 로 이동했을 경우(그만 큼 눌러야한다)
		result = Math.abs(n-100);
		
		// 2) 버튼 눌러서 최대한 가까이 간 후, + -로 이동했을 경우
		tN = n+""; // n을 앞에서 부터 한자리씩 체크
		len = tN.length(); // n의 길이
		if(result!=0) solve(0,0);
		System.out.println(result);
	}
	
	static int result,len;
	private static void solve(int idx,int tmpN) {
		// index가 끝까지 만들어 졌다면 새로운 숫자와 체크
		if(idx!=0) result = Math.min(idx+Math.abs(n-tmpN), result);
		if(idx>=len+1) return;
		
		// 모든 경우 찾기
		for(int i=0;i<10;i++) {
			if(arr[i]==0) {
				solve(idx+1,tmpN*10+i);
			}
		}
	}
}
