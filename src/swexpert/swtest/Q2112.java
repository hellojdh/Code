package swexpert.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2112 {
	static int d,w,k;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken()); // 합격 기준
            arr = new int[d][w];
            // 입력 받기
            for(int j=0;j<d;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<w;k++)
                    arr[j][k] = Integer.parseInt(st.nextToken());
            }
            min = Integer.MAX_VALUE;
            solve(0,0);
            sb.append("#"+i+" "+min+"\n");
        }
        System.out.print(sb);
    }
    
    // 두께 d는 3~13 , w는 1~20
    // 0은 A, 1은 B
    static int min;
    private static void solve(int idx,int insert) {
        // 최소 값을 찾는 것이므로 진행중 크거나 같은 값이 나오면 진행할 필요가 없다.
        if(insert>=min) return;
        
        // 조건이 다 만들어 졌다면 check하러 들어가기
        if(idx>=d) {
            // 통과 했다면 약물 개수 최소값 찾기
            if(check())
                min = Math.min(min, insert);
            return;
        }
        // 해당 idx 주입 안하기
        solve(idx+1,insert);
        
        // 원래 거 copy
        int[] tArr = new int[w];
        for(int i=0;i<w;i++)
            tArr[i] = arr[idx][i];
        
        // 해당 idx 주입 하기(A)
        for(int i=0;i<w;i++)
            arr[idx][i] = 0;
        solve(idx+1,insert+1);
        
        // 해당 idx 주입 하기(B)
        for(int i=0;i<w;i++)
            arr[idx][i] = 1;
        solve(idx+1,insert+1);
        
        // copy한것 되돌려놓기
        for(int i=0;i<w;i++)
            arr[idx][i] = tArr[i];
    }
    
    private static boolean check() {
        // k개 연속
        for(int i=0;i<w;i++) {
            boolean flag = false;
            int t = arr[0][i];
            int cnt=0;
            // 연속된게 K개 있는지 찾자.
            for(int j=0;j<d;j++) {
                if(t==arr[j][i]) cnt++;
                else{
                    cnt=1;
                    t=arr[j][i];
                }
                // k개가 된다면 해당 열은 더 진행 할 필요 x
                if(cnt==k) {
                    flag=true;
                    break;
                }
            }
            // 한 줄이라도 안되면 바로 false
            if(!flag) return false;
        }
        return true;
    }
}
