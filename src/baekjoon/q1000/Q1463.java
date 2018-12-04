package baekjoon.q1000;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q1463 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        // 최소값을 찾는 것이므로 최대값으로 채워놓기.
        Arrays.fill(arr,99999999);
        // Bottom Up 방식으로 아래서 부터 올라가보자.
        // 1로 만들기 이므로 자기자신은 0번 싸이클
        arr[1] = 0;
        for(int i=2;i<=n;i++){
            // 2로 나눠질 경우
            if(i%2==0) arr[i] = Math.min(arr[i],arr[i/2]+1);
            // 3으로 나눠질 경우
            if(i%3==0) arr[i] = Math.min(arr[i],arr[i/3]+1);
            // -1 경우
            arr[i] = Math.min(arr[i],arr[i-1]+1);
            // 세가지 케이스중 가장 작은 값을 같도록 한다.
        }
        System.out.println(arr[n]);
    }
}
