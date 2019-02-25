import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12100 {
    static int n;
    static int[][] arr,copy;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        copy = new int[n][n];
        visited = new boolean[n][n];
        max = 0;
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(max<arr[i][j]) max = arr[i][j];
            }
        }

        // 최대 5번을 이동시켜 얻을 수 있는 가장 큰 블록
        save = new int[5];
        init();
        make(0);
        System.out.println(max);
    }

    public static void reverse(int w) {
        // 위 아래 바꾸기
        if(w==1) {
            for(int i=0;i<n/2;i++) {
                for(int j=0;j<n;j++) {
                    int t = copy[i][j];
                    copy[i][j] = copy[n-i-1][j];
                    copy[n-i-1][j] = t;
                }
            }
        }else {
            // 좌 우 바꾸기
            for(int i=0;i<n/2;i++) {
                for(int j=0;j<n;j++) {
                    int t = copy[j][i];
                    copy[j][i] = copy[j][n-i-1];
                    copy[j][n-i-1] = t;
                }
            }
        }
    }

    static boolean[][] visited;
    public static void goUp() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                visited[j][i] = false;
                // 위쪽부터 봐주면서 수를 찾으면
                if(copy[j][i]!=0) {
                    // 전 단계부터 봐주기
                    for(int k=j-1;k>=0;k--) {
                        // 쭉 보면서 0 이아닌 수를 찾으면
                        if(copy[k][i]!=0) {
                            // 합처지지 않은 같은 수라면
                            if(!visited[k][i]&&copy[k][i]==copy[j][i]) {
                                copy[j][i] = 0;
                                copy[k][i] *= 2;
                                if(copy[k][i]>max) max = copy[k][i];
                                visited[k][i] = true;
                            }
                            break;
                        }
                    }
                }
            }
        }
        // 빈칸 떨구기
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(copy[j][i]!=0) {
                    for(int k=0;k<j;k++) {
                        if(copy[k][i]==0) {
                            copy[k][i] = copy[j][i];
                            copy[j][i] = 0;
                        }
                    }
                }
            }
        }
    }

    public static void goLeft() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                visited[i][j] = false;
                // 위쪽부터 봐주면서 수를 찾으면
                if(copy[i][j]!=0) {
                    // 전 단계부터 봐주기
                    for(int k=j-1;k>=0;k--) {
                        // 쭉 보면서 0 이아닌 수를 찾으면
                        if(copy[i][k]!=0) {
                            // 합처지지 않은 같은 수라면
                            if(!visited[i][k]&&copy[i][k]==copy[i][j]) {
                                copy[i][j] = 0;
                                copy[i][k] *= 2;
                                if(copy[i][k]>max) max = copy[i][k];
                                visited[i][k] = true;
                            }
                            break;
                        }
                    }
                }
            }
        }
        // 빈칸 떨구기
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(copy[i][j]!=0) {
                    for(int k=0;k<j;k++) {
                        if(copy[i][k]==0) {
                            copy[i][k] = copy[i][j];
                            copy[i][j] = 0;
                        }
                    }
                }
            }
        }
    }

    // 0 1 2 3 상 하 좌 우
    public static void go(int w) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)
                visited[i][j] = false;
        }
        // 하 우 일경우 상 좌 로 바꿔주기
        if(w==1 || w==3) {
            reverse(w);
        }

        if(w<2) goUp();
        else goLeft();

        // 다시 원상 복귀
        if(w==1 || w==3) {
            reverse(w);
        }

    }

    public static void init() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                visited[i][j] = false;
                copy[i][j] = arr[i][j];
            }
        }
    }

    static int max = 0;
    static int[] save;
    public static void make(int cnt) {
        if(cnt==5) {
            // 5번의 이동이 결정되면 체크
            init();
            for(int i=0;i<5;i++)
                go(save[i]);
            return;
        }

        for(int i=0;i<4;i++) {
            save[cnt] = i;
            make(cnt+1);
        }
    }
}
