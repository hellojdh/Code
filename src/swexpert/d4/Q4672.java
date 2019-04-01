package swexpert.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q4672 {
    static int[] arr;
    static int len;
    static HashMap<String, Integer> map = new HashMap<>();
    // 재구성 하는거니, 아예 새로 만들자.
    static boolean[] visited;
    static int max;
    public static int solve(int idx,String t) {
        if(map.containsKey(t)) {
            if(max>map.get(t)) return 0;
            return map.get(t);
        }
        if(idx==cnt2) {
            // 팰린드롬 검사
            int result = 0; // 일단 길이만큼 가진다.
            // 부분 문자열 검사
            for(int i=0;i<cnt2;i++) {
                xx:				for(int j=i;j<cnt2;j++) {
                    String tt = t.substring(i, j+1);
                    // 만들어진것 팰린드롬 검사
                    int len2 = tt.length();
                    for(int k=0;k<len2/2;k++) {
//						System.out.println(t.charAt(k)+"     "+t.charAt(len2-k-1));
                        if(tt.charAt(k)==tt.charAt(len2-k-1)) {
                        }else {
                            continue xx;
                        }
                    }

                    result++;
                }
            }
            max = max<result?result:max;
            return result;
        }
        int max = 0;
        for(int i=0;i<cnt2;i++) {
            if(visited[i]) continue;
            visited[i] = true;
            max = Math.max(max,solve(idx+1, t+(char)arr[i]));
            visited[i] = false;
        }
        map.put(t, max);
        return max;
    }

    static int cnt2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int z=1;z<=tc;z++) {
            String t = br.readLine();
            map.clear();

            // 문자열 받기
            len = t.length();
            arr = new int[len];
            visited = new boolean[len];
            max = 0;
            int[] check = new int[26];
            for(int i=0; i<len; i++) {
                check[t.charAt(i)-'a']++;
            }

            int cnt = 0;
            cnt2 = 0;
            for(int i=0;i<26;i++) {
                if(check[i]==1) {
                    cnt++;
                    check[i] = 0;
                }else if(check[i]>=2) {
                    cnt2+=check[i];
                }
            }
            arr = new int[cnt2];
            int idx = 0;
            for(int i=0;i<26;i++) {
                if(check[i]!=0) {
                    for(int j=0;j<check[i];j++) {
                        arr[idx++] = i;
                    }
                }
            }
            sb.append('#').append(z).append(' ')
                    .append(solve(0,"")+cnt).append('\n');
        }// end of tc
        System.out.println(sb);
    }// end of main
}// end of class