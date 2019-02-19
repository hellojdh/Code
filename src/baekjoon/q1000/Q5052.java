import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5052 {
    static int cnt = 1;
    static int[][] trie = new int[100000+10][10];
    static boolean[] end = new boolean[100000+10]; // 끝나는 전화번호가 있나
    static boolean[] exist = new boolean[100000+10]; // 이 노드의 자식이 있나
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int z=0;z<tc;z++) {
            int n = Integer.parseInt(br.readLine());
            init();
            boolean flag = false;
            for(int i=0;i<n;i++) {
                if(flag) br.readLine();
                else if(!insert(br.readLine()))
                    flag = true;
            }
            if(flag) sb.append("NO").append('\n');
            else sb.append("YES").append('\n');
        }
        System.out.println(sb);
    }// end of main


    public static void init() {
        cnt = 1;
        for(int i=0;i<100010;i++) {
            for(int j=0;j<10;j++) {
                trie[i][j] = 0;
            }
            exist[i] = false;
            end[i] = false;
        }
    }

    public static boolean insert(String t) {
        int len = t.length();
        int node = 0;
        for(int i=0;i<len;i++) {
            int tt = t.charAt(i)-'0';
            if(trie[node][tt]==0) {
                // 들어가는 도중 끝나는 경우
                if(end[node])
                    return false;
                exist[node] = true;
                trie[node][tt] = cnt++;
                node = trie[node][tt];
            }else {
                node = trie[node][tt];
            }
        }
        if(exist[node]) return false;
        end[node] = true; // 종료
        return true;
    }
}// end of class