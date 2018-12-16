package swexpert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            // n 크기의 배열 선언
            int[] arr = new int[n];
            // q개의 작업이 주어진다.
            for(int j=1;j<=q;j++){
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                // L~R 까지 작업 번호로 바뀜.
                // 배열이 0부터 시작이니 L-1~R-1까지
                for(int k=l-1;k<r;k++)
                    arr[k] = j;
            }
            sb.append("#"+i);
            for(int j=0;j<n;j++)
                sb.append(" "+arr[j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
