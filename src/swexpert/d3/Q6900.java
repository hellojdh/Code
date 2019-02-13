package swexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6900 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int z=1;z<=tc;z++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String[] arr = new String[n];
            int[] value = new int[n];
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = st.nextToken();
                value[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            yy:         for(int i=0;i<m;i++) {
                String t = br.readLine();
                xx:             for(int k=0;k<n;k++) {
                    for(int j=0;j<8;j++) {
                        if(arr[k].charAt(j)=='*') continue;
                        if(arr[k].charAt(j)!=t.charAt(j)) continue xx;
                        if(j==7) {
                            result+=value[k];
                            continue yy;
                        }
                    }
                }
            }
            sb.append('#').append(z).append(' ')
                    .append(result).append('\n');
        }// end of tc
        System.out.println(sb);
    }// end of main
}// end of class