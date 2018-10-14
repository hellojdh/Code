package swexpert.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q5656 {
	static int n,w,h;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new int[h][w];
            temp = new int[h][w];
            for(int j=0;j<h;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<w;k++)
                    arr[j][k] = Integer.parseInt(st.nextToken());
            }
            set = new HashSet<>();
            result = Integer.MAX_VALUE;
            solve();
            sb.append("#"+i+" "+result+"\n");
        }
        System.out.print(sb);
    }
    
    private static void solve() {
        // n은 최대 4번
        // w최대 12 -> 12^4 = 20736 밖에 안된다. 완전 탐색 진행
        for(int i=0;i<w;i++) {
            for(int j=0;j<w;j++)
                for(int k=0;k<w;k++)
                    for(int l=0;l<w;l++)
                        toBomb(i,j,k,l);
        }
    }
    
    static int[][] temp;
    static HashSet<String> set;
    private static void toBomb(int t1,int t2,int t3,int t4) {
        // 새로운 경우를 위한 배열 초기화
        initTemp();
        
        // n번의 케이스를 반복문으로 돌리기 위해서 배열 생성.
        int[] tArr = new int[n];
        switch(n) {
        case 1:
            tArr[0] = t1;
            break;
        case 2:
            tArr[0] = t1; tArr[1] = t2;
            break;
        case 3:
            tArr[0] = t1; tArr[1] = t2; tArr[2] = t3;
            break;
        case 4:
            tArr[0] = t1; tArr[1] = t2; tArr[2] = t3; tArr[3] = t4;
            break;
        }
        String t = "";
        for(int i=0;i<n;i++)
            t += tArr[i];
        
        // 이미 해본 케이스 일경우 return;
        if(set.contains(t))
            return;
        set.add(t);
        for(int i=0;i<n;i++) {
            for(int j=0;j<h;j++) {
                if(temp[j][tArr[i]]!=0) {
                    bomb(j,tArr[i],temp[j][tArr[i]]);
                    break;
                }
            }
            // 블록을 다 뿌셨으면 빈칸 없애고 다음번 진행
            down();
        }
        // 4번 다 뿌수고 남은 블록 세기
        count();
    }
    
    private static void bomb(int x,int y,int n) {
        temp[x][y] = 0;
        // n==1이면 자기 자시만 0으로 만들고 return
        if(n==1) return;
        // 위쪽
        for(int i=1;i<n;i++) {
            if(x-i<0) break;
            if(temp[x-i][y]!=0) {
                bomb(x-i,y,temp[x-i][y]);
            }
        }
        // 왼쪽
        for(int i=1;i<n;i++) {
            if(y-i<0) break;
            if(temp[x][y-i]!=0) {
                bomb(x,y-i,temp[x][y-i]);
            }
        }
        // 오른쪽
        for(int i=1;i<n;i++) {
            if(y+i>=w) break;
            if(temp[x][y+i]!=0) {
                bomb(x,y+i,temp[x][y+i]);
            }
        }
        // 아래
        for(int i=1;i<n;i++) {
            if(x+i>=h) break;
            if(temp[x+i][y]!=0) {
                bomb(x+i,y,temp[x+i][y]);
            }
        }
    }
    
    static int result;
    private static void count() {
        int cnt = 0;
        for(int i=0;i<h;i++) {
            for(int j=0;j<w;j++)
                if(temp[i][j]!=0) cnt++;
        }
        result = Math.min(result, cnt);
    }
    
    private static void down() {
        // 한 열별로 행 끝에서 부터 쭉 보기
        for(int i=0;i<w;i++) {
            for(int j=h-1;j>=0;j--) {
                // 쭉 찾아 올라가다 0을 발견하면
                if(temp[j][i]==0) {
                    // 그 위에를 살펴봐 0이 아닌 idx가 있으면 바꿔주고 그 idx를 0으로
                    // 만약 위쪽에 0이 아닌게 없으면 바꿀 필요없으므로 해당 열 끝내기
                    boolean flag = true;
                    for(int k=j-1;k>=0;k--) {
                        if(temp[k][i]!=0) {
                            temp[j][i] = temp[k][i];
                            temp[k][i] = 0;
                            flag = false;
                            break;
                        }
                    }
                    if(flag) break;
                }
            }
        }
    }
    
    private static void initTemp() {
        for(int i=0;i<h;i++) {
            for(int j=0;j<w;j++)
                temp[i][j] = arr[i][j];
        }
    }
}
