package baekjoon.q1000;

import java.util.Scanner;

public class Q3019 {
	static int c,p;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt(); // 열 수
		p = sc.nextInt(); // 블록 번호
		arr = new int[c];
		for(int i=0;i<c;i++)
			arr[i] = sc.nextInt();
		
		// 결과 초기화
		result = 0;
		makeBlock();
		System.out.println(result);
	}
	
	private static void makeBlock() {
		// 블록의 아랫면만 따져주면 된다.
		switch (p) {
		case 1: // ㅣ
			solve("0");
			solve("0000");
			break;
		case 2: // ㅁ
			solve("00");
			break;
		case 3: // 지렁이
			solve("001");
			solve("10");
			break;
		case 4: // 지렁이 좌우 전환
			solve("100");
			solve("01");
			break;
		case 5: // ㅗ
			solve("000");
			solve("01");
			solve("101");
			solve("10");
			break;
		case 6: // ㄴ 좌우 전환
			solve("000");
			solve("00");
			solve("011");
			solve("20");
			break;
		case 7: // ㄴ
			solve("000");
			solve("02");
			solve("110");
			solve("00");
			break;
		}
	}
	
	static int result;
	private static void solve(String block) {
		int len = block.length();
		// 전체 열에대해서 살피기
		for(int i=0;i<=c-len;i++) {
			//해당 열에서 블록이 가지고 있는 열의 길이만큼 살피기
			boolean flag = true;
			for(int j=i;j<i+len-1;j++) {
				int now = block.charAt(j-i)-'0'; // 현재 
				int next = block.charAt(j-i+1)-'0'; // 다음
				// 블록의 아래 모양과 똑같지 않으면 통과
				if(now-next != arr[j]-arr[j+1]) {
					flag = false;
					break;
				}
			}
			if(flag) result++;
		}
	}
}
