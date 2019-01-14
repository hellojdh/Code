package swexpert.d4;

import java.io.*;

public class Q6731 {
    static int n;
    static char[] garo,sero;
    static boolean[][] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for(int z=1;z<=tc;z++){
            n = Integer.parseInt(br.readLine().trim());
            arr = new boolean[n][n];
            garo = new char[n];
            sero = new char[n];
            // W = false, B = true
            for(int i=0;i<n;i++){
                String t = br.readLine();
                // 입력 하면서 가로 탐색
                for(int j=0;j<n;j++) {
                    if (t.charAt(j) == 'B') {
                        arr[i][j] = true;
                        garo[i]++;
                        sero[j]++;
                    }
                }
            }

            int result = 0;
            // 세로 개수 세기
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int t = garo[i]+sero[j];
                    if(arr[i][j]){
                        if(--t%2!=0) result++;
                    }else{
                        if(t%2!=0) result++;
                    }
                }
            }
            bw.write("#"+z+" "+result+"\n");
        }// end of tc
        bw.flush();
    } // end of main
}// end of class
