package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17071 {
    static int subin,dongSeng;
    static int[][] arr = new int[500001][2];
    static int[][] q = new int[1000100][2];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        dongSeng = Integer.parseInt(st.nextToken());

        // 홀 짝 에 수빈이가 도달할 수 있는 곳 표시해놓기
        int front = 0, rear = 0;
        q[++rear][0] = subin;
        q[rear][1] = 0;

        int time = 0;
        while(front<rear){
            time++;
            int size = rear-front;
            for(int i=0;i<size;i++) {
                int n = q[++front][0]; // 위치
                int tTime = q[front][1]; // 시간(홀짝)

                for (int t : new int[]{n + 1, n - 1, n * 2}) {
                    if (t <= 500000 && t >= 0) {
                        if (arr[t][1 - tTime] == 0) {
                            arr[t][1 - tTime] = time;
                            q[++rear][0] = t;
                            q[rear][1] = 1 - tTime;
                        }
                    }
                }
            }
        }
        arr[subin][0] = 0;
        for(int i=0;;i++){
            dongSeng+=i;
            if(dongSeng>500000){
                System.out.println(-1);
                break;
            }
            if(arr[dongSeng][(i%2)]<=i){
                System.out.println(i);
                break;
            }
        }

    }// end of main
}// end of class