package swexpert.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7338 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int z=1;z<=tc;z++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long year = Long.parseLong(st.nextToken());
            int month = Integer.parseInt(st.nextToken());

            long dist = year-2016;
            long tYear = year-dist/13;
            int tMonth = (int)(dist%13);
            month-=tMonth;
            if(month<=0) {
                tYear--;
                month+=13;
            }
            sb.append('#').append(z).append(' ')
                    .append(tYear).append(' ').append(month).append('\n');
        }// end of tc
        System.out.println(sb);
    }// end of main
}// end of class