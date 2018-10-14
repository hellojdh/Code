package swexpert.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4014 {
	static int n,x;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            
            for(int j=0;j<n;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<n;k++)
                    arr[j][k] = Integer.parseInt(st.nextToken());
            }
            
            sb.append("#"+i+" "+solve()+"\n");
        }
        System.out.print(sb);
    }
    
    private static int solve() {
        int result = 0;
        // 가로 탐색
        for(int i=0;i<n;i++) {
            int cnt = 0;
            int temp = arr[i][0];
            boolean flag = true;
            boolean flag2 = false;
            for(int j=0;j<n;j++) {
                if(temp==arr[i][j]) {
                    cnt++;
                    if(flag2&&cnt==x) {
                        cnt = 0;
                        flag2 = false;
                    }
                }else if(temp-1==arr[i][j]) {
                    // 앞 칸이 낮아졌다는건 앞쪽에 활주로를 체크해야함
                    if(flag2&&cnt<x) {
                        flag = false;
                        flag2 = false;
                        break;
                    }
                    cnt = 1;
                    flag2 = true;
                    temp = arr[i][j];
                }else if(temp+1==arr[i][j]) {
                    if(flag2&&cnt<x) {
                        flag = false;
                        flag2 = false;
                        break;
                    }
                    flag2 = false;
                    // 현 칸이 낮다는건 cnt를 기준으로 활주로를 체크해야함
                    if(cnt<x) {
                        flag = false;
                        break;
                    }
                    cnt = 1;
                    temp = arr[i][j];
                }else {
                    // 한 칸 차이가 아니면 활주로 불가
                    flag = false;
                    flag2 = false;
                    break;
                }
            }
            if(flag2) if(cnt<x) flag = false;
            if(flag) result++;
        }
        // 세로 탐색
        for(int i=0;i<n;i++) {
            int cnt = 0;
            int temp = arr[0][i];
            boolean flag = true;
            boolean flag2 = false;
            for(int j=0;j<n;j++) {
                if(temp==arr[j][i]) {
                    cnt++;
                    if(flag2&&cnt==x) {
                        cnt = 0;
                        flag2 = false;
                    }
                }else if(temp-1==arr[j][i]) {
                    // 앞 칸이 낮아졌다는건 앞쪽에 활주로를 체크해야함
                    if(flag2&&cnt<x) {
                        flag = false;
                        flag2 = false;
                        break;
                    }
                    cnt = 1;
                    flag2 = true;
                    temp = arr[j][i];
                }else if(temp+1==arr[j][i]) {
                    if(flag2&&cnt<x) {
                        flag = false;
                        flag2 = false;
                        break;
                    }
                    flag2 = false;
                    // 현 칸이 낮다는건 cnt를 기준으로 활주로를 체크해야함
                    if(cnt<x) {
                        flag = false;
                        break;
                    }
                    cnt = 1;
                    temp = arr[j][i];
                }else {
                    // 한 칸 차이가 아니면 활주로 불가
                    flag = false;
                    flag2 = false;
                    break;
                }
            }
            if(flag2) if(cnt<x) flag = false;
            if(flag) result++;
        }
        return result;
    }
}
