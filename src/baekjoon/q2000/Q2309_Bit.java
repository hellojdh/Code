package baekjoon.q2000;

import java.util.Arrays;
import java.util.Scanner;

public class Q2309_Bit {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		for(int i=0;i<9;i++)
			arr[i] = sc.nextInt();
		// 오름차순 출력을 위해 미리 정렬해두기
		Arrays.sort(arr);
		
		for(int i=0;i<(1<<9);i++) {
			int sum = 0;
			// bit(1) 개수가 7개일 경우
			if(Integer.bitCount(i)==7) {
				for(int j=0;j<9;j++) {
					//j만큼 1을 이동하여 i와 and 연산 결과가 1이라면(0보다 크다면)
					if((1<<j&i)>0) sum+=arr[j];
				}
				if(sum==100) {
					for(int j=0;j<9;j++) 
						if((1<<j&i)>0) System.out.println(arr[j]);
					break;
				}
			}
		}
	}
}
