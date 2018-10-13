package swexpert.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2115 {
	static int n,m,c;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken()); // 채취 가능 벌통 수(연속)
            c = Integer.parseInt(st.nextToken()); // 담기 가능 제한 수
            arr = new int[n][n];
            for(int j=0;j<n;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<n;k++)
                    arr[j][k] = Integer.parseInt(st.nextToken());
            }
            
            visited = new boolean[n][n];
            list = new ArrayList<>();
            max = 0;
            // 열은  n-m만큼만 진행 해주면 된다.
            for(int j=0;j<n;j++) {
                for(int k=0;k<=n-m;k++)
                    solve(j,k);
            }
            result = 0;
            // list 안에 들어간 값들로 Max값 찾기
            solve2(0,0,0);
            sb.append("#"+i+" "+result+"\n");
        }
        System.out.print(sb);
    }
    
    static int result;
    static boolean[][] visited;
    private static void solve2(int idx,int sum,int cnt) {
        // getMax와 동일한 방식으로 모든 조건을 살펴 Max값을 찾아주자.
        if(cnt==2) {
            result = Math.max(result, sum);
            return;
        }
        // idx를 넘을경우 return
        if(idx>=list.size()) return;
        
        int x = list.get(idx).x;
        int y = list.get(idx).y;
        
        boolean flag = false;
        for(int i=y;i<y+m;i++) {
            if(visited[x][i]) {
                flag = true;
                break;
            }
        }
        if(flag) {
            // 해당 index가 포함 안되도 다음걸로 넘겨는 주기.
            solve2(idx+1,sum,cnt);
            return;
        }
        
        // 겹치지 않는다면 겹침 체크해주기
        for(int i=y;i<y+m;i++)
            visited[x][i] = true;
        // 자신 포함
        solve2(idx+1,sum+list.get(idx).value,cnt+1);
        // 이제 사용안하므로 겹침 체크 풀어주기
        for(int i=y;i<y+m;i++)
            visited[x][i] = false;
        // 자신 미포함
        solve2(idx+1,sum,cnt);
    }
    
    // 최대 값을 찾아라? -> 모든 경우의 수를 따져보자
    static int max;
    static List<Pair> list;
    private static void solve(int x,int y) {
        // 한 줄씩 m칸으로 만들 수 있는 모든 경우의 수를 찾고 List에 넣어주기
        
        // m 칸씩 살펴보므로 index를 초과하면 종료 
        if(y+m>n) {
            return;        
        }
        // 선택할 칸 체크
        int[] tArr = new int[m];
        // m 개만큼 넣기
        for(int i=y,idx=0;i<y+m;i++)
            tArr[idx++] = arr[x][i];
        // 얻은 m개 값으로 모든 조건을 따져서 가장 큰값 구해주기
        tSum=0;
        getMax(tArr,0,0,0);
        list.add(new Pair(tSum, x, y));
    }
    
    static int tSum;
    private static void getMax(int[] tArr,int idx,int sum,int sSum) {
        // 끝까지 살펴봤으면 종료
        if(idx==m) {
            tSum = Math.max(tSum, sSum);
            return;
        }
        // c보다 작다면 해당 index 포함
        if(sum+tArr[idx]<=c) {
            getMax(tArr, idx+1, sum+tArr[idx], sSum+tArr[idx]*tArr[idx]);
        }
        // 해당 index 미포함
        getMax(tArr,idx+1,sum,sSum);
    }
    
    static class Pair{
        private int value,x,y;
        public Pair(int value,int x,int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
}
