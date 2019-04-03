package swexpert.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4050 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int z=1;z<=tc;z++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr = new int[n];

            for(int i=0;i<n;i++)
                arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);

            int len = arr.length;
            int result = 0;
            int sum = 0;
            int cnt = 0;
            for(int i=len-1;i>=0;i--) {
                cnt++;
                if(cnt==3) {
                    result += sum;
                    cnt = 0;
                    sum = 0;
                }else {
                    sum += arr[i];
                }
            }

            if(cnt!=0) {
                result += sum;
            }

            sb.append('#').append(z).append(' ')
                    .append(result).append('\n');
        }// end of tc
        System.out.println(sb);
    }// end of main
}// end of class