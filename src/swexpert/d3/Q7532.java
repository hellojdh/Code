package swexpert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int i = 1; i <= tc; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int ts = e, tm = e;
            int result = e;
            int div = 24;
            while (true){
                if(ts==s && tm==m){
                    break;
                }
                ts+=div;
                if(ts>365)
                    ts%=365;
                tm+=div;
                if(tm>29)
                    tm%=29;
                result += div;

            }
            sb.append('#').append(i).append(' ').append(result).append('\n');
        }
        System.out.println(sb);
    }// end of main
}// end of class