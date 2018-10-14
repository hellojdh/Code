package swexpert.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q5658 {
	static int n,k,cut;
    static char[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            String t = br.readLine();
            arr = new char[t.length()];
            for(int j=0;j<t.length();j++)
                arr[j] = t.charAt(j);
            cut = t.length()/4;
            list.clear();
            solve();
            Collections.sort(list);
            Collections.reverse(list);
            sb.append("#"+i+" "+list.get(k-1)+"\n");
        }
        System.out.print(sb);
    }
    
    static     List<Integer> list = new ArrayList<>();
    private static void solve() {
        boolean flag = true;
        // 원하는 개수만큼 도달할 때까지
        while(flag) {
            flag = false;
            // 우선적으로 숫자를 뽑아내기
            for(int i=0;i<arr.length;) {
                int idx=0;
                String sNum = "";
                while(idx!=cut) {
                    sNum += arr[i++];
                    idx++;
                }
                int t = getInt(sNum);
                if(!list.contains(t)) {
                    list.add(t);
                    flag = true;
                }
            }
            // 회전 시키기
            rotate();
        }
    }
    
    private static int getInt(String t) {
        return Integer.parseInt(t,16);
    }
    
    private static void rotate() {
        // 시계 방향 회전이니 가장 마지막걸 저장
        char lastN = arr[arr.length-1];
        for(int i=arr.length-1;i>0;i--)
            arr[i] = arr[i-1]; 
        arr[0] = lastN;
    }
}
