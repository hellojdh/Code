package swexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7193 {
    static int result,len,mod;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int z=1;z<=tc;z++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            String t = st.nextToken();
            result = 0;
            len = t.length();
            mod = n-1;
            for(int i=0;i<len;i++) {
                result += t.charAt(i);
            }
            result -= len*'0';
            sb.append('#').append(z).append(' ')
                    .append(result%mod).append('\n');
        }
        System.out.println(sb);
    }// end of main
}// end of class