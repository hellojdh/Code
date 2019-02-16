package swexpert.d3;

import java.io.*;
import java.util.StringTokenizer;

public class Q6958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int z=1;z<=tc;z++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int cntMax=0,cntH=0;

            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine(), " 0");
                int cnt = st.countTokens();
                if(cnt>cntMax) {
                    cntMax = cnt;
                    cntH=1;
                }else if(cnt==cntMax) {
                    cntH++;
                }
            }

            bw.write(String.format("#%d %d %d\n",z,cntH,cntMax));
        }
        bw.flush();
    }// end of main
}// end of class