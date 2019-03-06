package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16987 {
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 최대 몇 개의 계란을 깰 수 있는지 맞춰보자.

        // N이 8밖에 안된다. 다 해보자.
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken()); // 내구도
            arr[i][1] = Integer.parseInt(st.nextToken()); // 무게
        }

        // 1) 가장 왼쪽 계란을 든다.
        solve(0,0);
        System.out.println(max);
    }// end of main

    static int max = 0;
    // 들고있는 계란의 오른쪽만 봐주면 된다.
    public static void solve(int now,int egg) {
        // 단 가장 최근에 든 계란이 가장 오른쪽 계란일 경우 계란 치는 과정을 종료한다.
        max = max<egg?egg:max;
        if(now>=n) {
            return;
        }
        // 요번 계란이 깨진 계란이면 다음으로 넘기기
        if(arr[now][0]<=0) {
            solve(now+1, egg);
            return;
        }

        for(int i=0;i<n;i++) {
            if(i==now) continue;
            // 2) 깨지지 않은 다른 계란 중 하나를 친다. 손에 든 계란이 깨졌거나 다른 계란이 다 깨졌으면 치지 않고 넘어간다.
            // 손에 있던 계란을 원래자리에 내려놓는다.

            // 계란 치기(내구도 - 무게)
            // 깨지지 않은 계란 중 치기
            if(arr[i][0]>0) {
                arr[now][0] -= arr[i][1];
                arr[i][0] -= arr[now][1];

                // 손에 있떤 계란을 내려놓자
                if(arr[now][0]<=0) {
                    // 3) 방금 든 계란의 한 칸 오른쪽 계란을 손에들고 2번부터 다시 진행한다.
                    if(arr[i][0]<=0) solve(now+1,egg+2);
                    else solve(now+1,egg+1);
                }else {
                    if(arr[i][0]<=0) solve(now+1,egg+1);
                    else solve(now+1,egg);
                }
                arr[i][0] += arr[now][1];
                arr[now][0] += arr[i][1];
            }
        }
    }
}// end of class