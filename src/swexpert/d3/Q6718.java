package swexpert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6718 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append("#"+(i+1)+" ");
            int t = Integer.parseInt(br.readLine());
            // 1km = 1000m 모든 범위가 적으므로 분류해주자.
            if(t<100) sb.append(0);
            else if(t>=100&&t<1000) sb.append(1);
            else if(t>=1000&&t<10000) sb.append(2);
            else if(t>=10000&&t<100000) sb.append(3);
            else if(t>=100000&&t<1000000) sb.append(4);
            else sb.append(5);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
