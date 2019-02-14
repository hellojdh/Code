package swexpert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int z=1;z<=tc;z++) {
            sb.append('#').append(z).append(' ');
            String t = br.readLine();
            int len = t.length();
            int sum = 0;

            // 어차피 수는 똑같으므로 앞에서부터 단계만 따져주자.
            int cnt = 0;
            for(int i=0;i<len;i++){
                sum += t.charAt(i)-'0';
                cnt++;
                // 2개를 더해서 2자리가 나오면 더해주기
                if(sum>=10){
                    sum = sum/10 + sum%10;
                    cnt++;
                }
            }
            // 짝수번 진행이 아니면 B의 승리 (A부터 시작이니)
            if(cnt%2!=0) sb.append('B').append('\n');
            else sb.append('A').append('\n');
        }
        System.out.println(sb);
    }// end of main
}// end of class