package swexpert.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q7103 {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[32767+200];
        for(int i=0;i*i<=32767;i++) {
            int t = i*i;
            for(int j=i;(t+j*j)<=32767;j++) {
                int t2 = t+j*j;
                for(int k=j;(t2+k*k)<=32767;k++) {
                    int t3 = t2+k*k;
                    for(int z=k;(t3+z*z)<=32767;z++) {
                        int t4 = t3+z*z;
                        arr[t4]++;
                    }
                }
            }
        }
        int tc = Integer.parseInt(br.readLine().trim());
        for(int z=1;z<=tc;z++) {
            n = Integer.parseInt(br.readLine().trim());
            bw.write(String.format("#%d %d\n",z,arr[n]));
        }
        bw.flush();
    }// end of main
}// end of class