package swexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q7732 {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        for(int z = 1; z <= n; z++) {
            String[] sTime = br.readLine().split(":");
            String[] eTime = br.readLine().split(":");

            // 초 따져주기
            int second = Integer.parseInt(eTime[2])
                    -Integer.parseInt(sTime[2]);
            // 분 따져주기
            int minute = Integer.parseInt(eTime[1])
                    -Integer.parseInt(sTime[1]);
            // 시간 따져주기
            int hour = Integer.parseInt(eTime[0])
                    -Integer.parseInt(sTime[0]);

            // - 따져주기
            if(second<0) {
                second+=60;
                minute-=1;
            }

            if(minute<0) {
                minute+=60;
                hour-=1;
            }

            if(hour<0) hour+=24;



            sb.append('#').append(z).append(' ');
            if(hour<10) sb.append('0').append(hour);
            else sb.append(hour);
            sb.append(':');

            if(minute<10) sb.append('0').append(minute);
            else sb.append(minute);
            sb.append(':');

            if(second<10) sb.append('0').append(second);
            else sb.append(second);

            sb.append('\n');
        }
        System.out.println(sb);
    }// end of main
}// end of class
