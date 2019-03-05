package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16986 {
    static int n,k;
    static int[][] arr,arr2= new int[3][20];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        // 친구들이 미리 낼 것들
        for(int i=0;i<20;i++) {
            arr2[1][i] = Integer.parseInt(st.nextToken())-1;
            arr2[2][i] = Integer.parseInt(st2.nextToken())-1;
        }

        // 지우 경희 민호 순으로 경기
        // 지우가 모든 손동작을 다르게 내어 우승할 수 있으면 1
        visited = new int[n]; // 손동작 체크!
        solve(0,1,0,0,0,0,0);

        // [i][j] ==2 i번 손동작이 j번을 이긴다.
        // 비길 경우에는 순서가 뒤인 사람이 이긴다.
        System.out.println(0);
    }// end of main

    static int[] visited;
    public static void solve(int vs1,int vs2,int round,int round2,int win1,int win2,int win3) {
        if(win1==k) {
            System.out.println(1);
            System.exit(0);
        }
        if(win2==k||win3==k) return;

        if(vs1==0) {
            // 상대방이 낸 것
            int v = 0;
            if(vs2==1) v = arr2[vs2][round];
            else v = arr2[vs2][round2];

            // 안낸 것중에 이길걸 내자
            for(int i=0;i<n;i++) {
                // 안쓴거일 경우 보내주기
                if(visited[i]==1) continue;
                visited[i] = 1;
                // 지거나 비기면 vs2가 무조건 이기는것
                if(arr[i][v]==0||arr[i][v]==1) {
                    if(vs2==1) {
                        solve(1, 2, round+1,round2,win1,win2+1,win3);
                    }else {
                        solve(1, 2, round,round2+1,win1,win2,win3+1);
                    }
                }else {
                    // 지우(0)가 이김
                    if(vs2==1) {
                        solve(0, 2, round+1,round2,win1+1,win2,win3);
                    }else {
                        solve(0, 1, round,round2+1,win1+1,win2,win3);
                    }
                }
                visited[i] = 0;
            }
        }else {
            // 지우가 없는 경기일 경우
            int v = arr2[vs1][round];
            int v2 = arr2[vs2][round2];
            if(arr[v][v2]==1||arr[v][v2]==0) {
                // v가 졌다
                solve(0,2, round+1,round2+1, win1, win2, win3+1);
            }else{
                // v가 이겼다.
                solve(0,1, round+1,round2+1, win1, win2+1, win3);
            }
        }
    }
}// end of class