package swexpert.swtest;

import java.io.IOException;
import java.util.Scanner;

public class Q4008 {
	static int n;
    static int[] arr,num;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i=1;i<=tc;i++) {
            n = sc.nextInt();
            arr = new int[4];
            num = new int[n];
            for(int j=0;j<4;j++)
                arr[j] = sc.nextInt();
            for(int j=0;j<n;j++)
                num[j] = sc.nextInt();
            max = Integer.MIN_VALUE; min = Integer.MAX_VALUE;
            solve(arr[0],arr[1],arr[2],arr[3],num[0],1);
            System.out.println("#"+i+" "+(max-min));
        }
    }
    
    // + - * /
    private static int max,min;
    private static void solve(int p,int m,int mul,int div,int sum,int idx) {
        if(idx==n) {
            max = Math.max(max,sum);
            min = Math.min(min,sum);
            return;
        }
        
        for(int i=0;i<4;i++) {
            switch(i) {
            case 0:
                if(p>0)    solve(p-1,m,mul,div,sum+num[idx],idx+1);
                break;
            case 1:
                if(m>0) solve(p,m-1,mul,div,sum-num[idx],idx+1);
                break;
            case 2:
                if(mul>0) solve(p,m,mul-1,div,sum*num[idx],idx+1);
                break;
            case 3:
                if(div>0) solve(p,m,mul,div-1,sum/num[idx],idx+1);
                break;
            }
        }
    }
}
