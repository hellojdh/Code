package swexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q7728 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[10];
        int tc = Integer.parseInt(br.readLine());
        for(int z = 1; z <= tc; z++){
            String n = br.readLine();
            int len = n.length();
            int result = 0;

            for(int i = 0; i < len; i++){
                int t = n.charAt(i)-'0';
                if(arr[t]!=z){
                    result++;
                    arr[t] = z;
                }
            }

            sb.append('#').append(z).append(' ').append(result).append('\n');
        }
        System.out.println(sb);
    }// end of main
}// end of class
