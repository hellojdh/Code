package swexpert.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4301 {
    static int n,m;
    static int[][] arr;
    static int[] dx = {2,0};
    static int[] dy = {0,2};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int z=1;z<=tc;z++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n+2][m+2];

            int result = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j]==0){
                        result++;
                        for(int k=0;k<2;k++){
                            arr[i+dx[k]][j+dy[k]] = -1;
                        }
                    }
                }
            }// end of for(i)
            sb.append('#').append(z).append(' ')
                    .append(result).append('\n');
        }
        System.out.println(sb);
    }// end of main
}// end of class