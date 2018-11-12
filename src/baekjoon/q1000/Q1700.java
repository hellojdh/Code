package baekjoon.q1000;

import java.util.HashSet;
import java.util.Scanner;

public class Q1700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 구멍의 개수
        int m = sc.nextInt(); // 제품 수
        int[] arr = new int[m];
        for(int i=0;i<m;i++)
            arr[i] = sc.nextInt();

        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<m;i++){
            int t = arr[i];
            // 이미 꼽혀있는 거면 그대로 가져간다
            if(set.contains(t)) continue;
            // 새로 꼽아야할 경우
            // 1) 다 꼽혀있다면
            if(set.size()==n){
                int idx = -3, target = 0;
                for(int tt:set){
                    int tIdx = 9999;
                    // 제일 안쓰이는 걸 찾자.
                    for(int j=i+1;j<m;j++){
                        // 똑같은게 있다면 해당 index 저장
                        if(tt==arr[j]){
                            tIdx = j;
                            break;
                        }
                    }
                    // tIdx가 변하지 않았다면 이 뒤로 사용되지 않는다는 것이다.
                    if(tIdx==9999){
                        target = tt;
                        break;
                    }else{
                        // 가장 나중에 사용되는걸 찾자.
                        if(tIdx>idx){
                            idx = tIdx;
                            target = arr[tIdx];
                        }
                    }
                }
                // 콘센트 빼주기
                set.remove(target);
                result++;
            }
            // 2) 남는 곳이 있다면
            set.add(t);
        }
        System.out.println(result);
    }
}
