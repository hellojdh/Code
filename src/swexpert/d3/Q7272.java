package swexpert.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q7272 {
    static int n;
    static int[] check = new int[130];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] t = {'C','E','F','G','H','I','J','K','L',
                'M','N','S','T','U','V','W','X','Y','Z'};
        char[] tt = {'A','D','O','P','Q','R'};
        for(int i=0;i<t.length;i++) {
            check[t[i]] = 1;
        }
        for(int i=0;i<tt.length;i++) {
            check[tt[i]] = 2;
        }
        check['B'] = 3;
        int tc = Integer.parseInt(br.readLine());
xx:		for(int z=1;z<=tc;z++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            String b = st.nextToken();
            int len = a.length();
            if(len!=b.length()) {
                bw.write("#"+z+" DIFF\n");
                continue xx;
            }

            for(int i=0;i<len;i++) {
                if(check[a.charAt(i)]==check[b.charAt(i)]) {

                }else {
                    bw.write("#"+z+" DIFF\n");
                    continue xx;
                }
            }
            bw.write("#"+z+" SAME\n");
        }// end of tc
        bw.flush();
    }// end of main
}// end of class