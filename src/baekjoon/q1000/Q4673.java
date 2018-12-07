package baekjoon.q1000;

import java.io.IOException;

public class Q4673 {
    public static void main(String args[]) throws IOException {
        int[] arr = new int[10001];
        // 1~10000
        arr[0]=1;
        for(int i=0;i<10001;i++){
            if(arr[i]!=0) continue;
            int tn = i;
            // 셀프 넘버가 아닌것 골라주기
            while(true){
                int size = (tn+"").length();
                int t = tn;
                for(int j=0;j<size;j++)
                    tn += (t+"").charAt(j)-'0';
                if(tn>10000 || arr[tn]!=0) break;
                arr[tn] = 1;
            }
        }
        // 셀프 넘버 출력
        for(int i=0;i<10001;i++)
            if(arr[i]==0) System.out.println(i);
    }
}
