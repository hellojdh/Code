package swexpert.d3;

import java.util.Scanner;

public class Q6019 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i=1;i<=tc;i++){
            int d = sc.nextInt();
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double f = sc.nextDouble();
            double mok = d/(a+b);
            double result = mok*f;
            System.out.printf("#"+i+" %.6f\n",result);
        }
    }
}
