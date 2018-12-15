package swexpert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6190 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++){
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                arr[j] = Integer.parseInt(st.nextToken());

            // 2개의 곱이므로 2중 포문을 이용해 구해보자.
            // 두번째 곱해지는건 앞선것보다 인자가 크게한다(중복 방지)
            // 전부 양수이므로 초기값은 -1(수가 없다면 -1 출력이라)
            int result = -1;
            for(int j=0;j<n;j++){
                for(int k=j+1;k<n;k++){
                    // 결과 값보다 큰 값만 단조 증가 수 체크하자
                    if(result<arr[j]*arr[k])
                        if(solve(arr[j]*arr[k]))
                            result = arr[j]*arr[k];
                }
            }
            System.out.println("#"+i+" "+result);
        }
    }

    // 단조 증가하는 수 확인
    private static boolean solve(int n){
        int t = n%10;
        n /=10;
        while(n!=0){
            if(n%10>t) return false;
            t = n%10;
            n /=10;
        }
        return true;
    }
}
