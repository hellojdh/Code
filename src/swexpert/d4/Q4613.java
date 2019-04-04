package swexpert.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4613 {
    static int n,m,resultW,resultR;
    static int[][] arr = new int[50][3];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine().trim());
        for(int z=1;z<=tc;z++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            for(int i=0;i<n;i++) {
                String t = br.readLine();
                arr[i] = new int[]{0,0,0};
                for(int j=0;j<m;j++) {
                    switch (t.charAt(j)) {
                        case 'W':
                            arr[i][0]++;
                            break;
                        case 'B':
                            arr[i][1]++;
                            break;
                        case 'R':
                            arr[i][2]++;
                            break;
                    }
                }
            }

            // 0 1 2 => W B R
            resultW = 0; resultR = 0;
            // 맨 윗줄은 무조건 하얀색이어야 한다.
            resultW += (arr[0][1]+arr[0][2]);

            // 맨 아래는 무조건 빨강
            n--;
            resultR += (arr[n][0]+arr[n][1]);
            // 전체 결과 초기화
            result = Integer.MAX_VALUE;
            solve(1,0,0,resultW+resultR);
            sb.append('#').append(z).append(' ')
                    .append(result).append('\n');
        }// end of tc
        System.out.println(sb);
    }// end of main

    static int result;
    public static void solve(int idx,int cntB,int flag,int sum) {
        // 전체 결과보다 크다면 return
        if(result<sum) return;
        if(idx==n) {
            // 파랑이 없었다면 끝.
            if(cntB==0) return;
            result = sum;
            return;
        }
        // 0W  1B  2R
        // 이전이 하양이였다면 -> 하양 and 파랑
        if(flag==0) {
            solve(idx+1,cntB,0,sum+arr[idx][1]+arr[idx][2]);
            solve(idx+1,cntB+1,1,sum+arr[idx][0]+arr[idx][2]);
        }
        // 이전이 파랑이였다면 -> 파랑 and 빨강
        else if(flag==1) {
            solve(idx+1,cntB+1,1,sum+arr[idx][0]+arr[idx][2]);
            solve(idx+1,cntB,2,sum+arr[idx][0]+arr[idx][1]);
        }
        // 이전이 빨강이였다면 -> 빨강
        else {
            solve(idx+1,cntB,2,sum+arr[idx][0]+arr[idx][1]);
        }
    }
}// end of class