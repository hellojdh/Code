package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6593 {
    static int l,r,c;
    static int[][] q = new int[29000][3];
    static int[][][] arr = new int[30][30][30];
    static int[] dx = {1,0,-1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        xx:		while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(l==0) {
                break;
            }
            int sx = 0,sy = 0, sz = 0;
            for(int i=0;i<l;i++) {
                for(int j=0;j<r;j++) {
                    String t = br.readLine();
                    for(int k=0;k<c;k++) {
                        char tt = t.charAt(k);
                        arr[i][j][k] = tt;
                        if(tt=='S') {
                            sx = j;
                            sy = k;
                            sz = i;
                        }
                    }
                }
                br.readLine();
            }
            int front = 0,rear = 0;
            q[++rear][0] = sx;
            q[rear][1] = sy;
            q[rear][2] = sz;
            int time = 0;
            while(front<rear) {

                time++;
                int size = rear-front;
                for(int i=0;i<size;i++) {
                    int x = q[++front][0];
                    int y = q[front][1];
                    int z = q[front][2];

                    for(int j=0;j<6;j++) {
                        int tx = x+dx[j];
                        int ty = y+dy[j];
                        int tz = z+dz[j];
                        if(tx<0||ty<0||tz<0||tx>=r||ty>=c||tz>=l) continue;
                        if(arr[tz][tx][ty]!='#') {
                            if(arr[tz][tx][ty]=='E') {
                                sb.append(String.format("Escaped in %d minute(s).", time)).append('\n');
                                continue xx;
                            }
                            q[++rear][0] = tx;
                            q[rear][1] = ty;
                            q[rear][2] = tz;
                            arr[tz][tx][ty] = '#';
                        }
                    }
                }
            }// end of while(front<rear)
            sb.append("Trapped!").append('\n');
        }// end of while(true)
        System.out.println(sb);
    }// end of main
} // end of class