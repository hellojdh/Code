package swexpert.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6109 {
    static int n;
    static int[][] arr = new int[20][20];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int z=1;z<=tc;z++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            char order = st.nextToken().charAt(0);

            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0;j<n;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            switch (order) {
                case 'l':
                    left();
                    break;
                case 'r':
                    swapR();
                    left();
                    swapR();
                    break;
                case 'u':
                    up();
                    break;
                case 'd':
                    swapD();
                    up();
                    swapD();
                    break;
            }
            sb.append('#').append(z).append('\n');
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++)
                    sb.append(arr[i][j]).append(' ');
                sb.append('\n');
            }
        }// end of tc
        System.out.println(sb);
    }// end of main

    public static void swapD() {
        int div = n/2;
        for(int i=0;i<div;i++) {
            for(int j=0;j<n;j++) {
                int t = arr[i][j];
                arr[i][j] = arr[n-i-1][j];
                arr[n-i-1][j] = t;
            }
        }
    }

    public static void up() {
        int idx = 0;
        for(int j=0;j<n;j++) {
            idx = 0;
            for(int i=0;i<n;i++) {
                // 현 숫자 저장 초기화 하면서 진행
                int t = arr[i][j];
                if(t!=0&&idx!=i) {
                    // 놓을 칸과 같다면
                    arr[i][j] = 0;
                    if(idx!=i&&arr[idx][j]==t) {
                        arr[idx++][j] *= 2;
                    }else {
                        if(arr[idx][j]==0) {
                            arr[idx][j] = t;
                        }else {
                            arr[++idx][j] = t;
                        }
                    }
                }
            }
        }
    }

    private static void swapR() {
        int div = n/2;
        for(int i=0;i<n;i++) {
            for(int j=0;j<div;j++) {
                int t = arr[i][j];
                arr[i][j] = arr[i][n-j-1];
                arr[i][n-j-1] = t;
            }
        }
    }

    private static void left() {
        int idx = 0;
        for(int i=0;i<n;i++) {
            idx = 0;
            for(int j=0;j<n;j++) {
                // 현 숫자 저장 초기화 하면서 진행
                int t = arr[i][j];
                if(t!=0&&j!=idx) {
                    // 놓을 칸과 같다면
                    arr[i][j] = 0;
                    if(idx!=j&&arr[i][idx]==t) {
                        arr[i][idx++] *= 2;
                    }else {
                        if(arr[i][idx]==0) {
                            arr[i][idx] = t;
                        }else {
                            arr[i][++idx] = t;
                        }
                    }
                }
            }
        }
    }
}// end of class