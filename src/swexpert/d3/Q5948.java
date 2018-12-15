package swexpert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        // 정렬을 위해서
        List<Integer> list = new ArrayList<>();
        // 중복 방지를 위해서
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int[] arr;
        for(int i=1;i<=tc;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[7];
            for(int j=0;j<7;j++)
                arr[j] = Integer.parseInt(st.nextToken());

            // 초기화
            list.clear();
            set.clear();
            for(int j=0;j<7;j++){
                for(int k=j+1;k<7;k++){
                    for(int z=k+1;z<7;z++)
                        // 3개를 더한 값을 만들어 준다.
                        // 중복 제거를 위해 set을 사용
                        set.add(arr[j]+arr[k]+arr[z]);
                }
            }
            // 정렬을 위해 set의 자료들을 list로 만들어주기
            list.addAll(set);
            Collections.sort(list,Collections.reverseOrder());
            // 제일 큰거에서 5번째
            sb.append("#"+i+" "+list.get(4)+"\n");
        }
        System.out.println(sb);
    }
}
