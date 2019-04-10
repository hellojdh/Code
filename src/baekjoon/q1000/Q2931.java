package baekjoon.q1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2931 {
    static int n,m,target;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 블록이 정확히 1칸 지워졌다.
        xx:		for(int z=1;z<=1;z++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n+2][m+2];
            int sx = 0,sy = 0;
            int ex = 0,ey = 0;
            for(int i=1;i<=n;i++) {
                String t = br.readLine();
                for(int j=1;j<=m;j++) {
                    arr[i][j] = t.charAt(j-1);
                    if(arr[i][j]=='M') {
                        sx = i;
                        sy = j;
                    }
                    if(arr[i][j]=='Z') {
                        ex = i;
                        ey = j;
                    }
                }
            }// end of input

            // M 부터 출발 시켜서 다음 길이 못간다면 후보군중 놓고 출발

            // 우선 출발 M에서 출발할 수 있는 방향을 검사

            // 위쪽 검사(| + 1 4)
            int t = arr[sx-1][sy];
            target = 'Z';
            if(t=='|'||t=='+'||t=='1'||t=='4') {
                solve(sx-1,sy,sx,sy);
                sb.append(rX).append(' ').append(rY)
                        .append(' ').append((char)rShape).append('\n');
                break xx;
            }
            // 아랫쪽 검사(| + 2 3)
            t = arr[sx+1][sy];
            if(t=='|'||t=='+'||t=='2'||t=='3') {
                solve(sx+1,sy,sx,sy);
                sb.append(rX).append(' ').append(rY)
                        .append(' ').append((char)rShape).append('\n');
                break xx;
            }

            // 왼쪽 검사(- + 1 2)
            t = arr[sx][sy-1];
            if(t=='-'||t=='+'||t=='1'||t=='2') {
                solve(sx,sy-1,sx,sy);
                sb.append(rX).append(' ').append(rY)
                        .append(' ').append((char)rShape).append('\n');
                break xx;
            }

            // 오른쪽 검사(- + 3 4)
            t = arr[sx][sy+1];
            if(t=='-'||t=='+'||t=='3'||t=='4') {
                solve(sx,sy+1,sx,sy);
                sb.append(rX).append(' ').append(rY)
                        .append(' ').append((char)rShape).append('\n');
                break xx;
            }

            // 여기까지 온것은 M 바로 다음에 빈칸이 있었던것 => Z 에서 출발시키자.
            target = 'M';
            t = arr[ex-1][ey];
            if(t=='|'||t=='+'||t=='1'||t=='4') {
                solve(ex-1,ey,ex,ey);
                sb.append(rX).append(' ').append(rY)
                        .append(' ').append((char)rShape).append('\n');
                break xx;
            }
            // 아랫쪽 검사(| + 2 3)
            t = arr[ex+1][ey];
            if(t=='|'||t=='+'||t=='2'||t=='3') {
                solve(ex+1,ey,ex,ey);
                sb.append(rX).append(' ').append(rY)
                        .append(' ').append((char)rShape).append('\n');
                break xx;
            }

            // 왼쪽 검사(- + 1 2)
            t = arr[ex][ey-1];
            if(t=='-'||t=='+'||t=='1'||t=='2') {
                solve(ex,ey-1,ex,ey);
                sb.append(rX).append(' ').append(rY)
                        .append(' ').append((char)rShape).append('\n');
                break xx;
            }

            // 오른쪽 검사(- + 3 4)
            t = arr[ex][ey+1];
            if(t=='-'||t=='+'||t=='3'||t=='4') {
                solve(ex,ey+1,ex,ey);
                sb.append(rX).append(' ').append(rY)
                        .append(' ').append((char)rShape).append('\n');
                break xx;
            }


            // 여기까지 왔으면 M과 Z사이에 블럭이 하나도 없는것 즉 1칸 차이로 갈 수 있는것
            // 연결이 유일한 경우니깐 대각선은 안봐도 된다.
            // 우 두칸
            if(sy+2<=m) {
                if(arr[sx][sy+2]=='Z') {
                    rX = sx;
                    rY = sy+1;
                    rShape = '-';
                    sb.append(rX).append(' ').append(rY)
                            .append(' ').append((char)rShape).append('\n');
                    break xx;
                }
            }

            // 좌 두칸
            if(sy-2>=1) {
                if(arr[sx][sy-2]=='Z') {
                    rX = sx;
                    rY = sy-1;
                    rShape = '-';
                    sb.append(rX).append(' ').append(rY)
                            .append(' ').append((char)rShape).append('\n');
                    break xx;
                }
            }

            // 상 두칸
            if(sx-2>=1) {
                if(arr[sx-2][sy]=='Z') {
                    rX = sx-1;
                    rY = sy;
                    rShape = '|';
                    sb.append(rX).append(' ').append(rY)
                            .append(' ').append((char)rShape).append('\n');
                    break xx;
                }
            }

            // 하 두칸
            if(sx+2<=n) {
                if(arr[sx+2][sy]=='Z') {
                    rX = sx+1;
                    rY = sy;
                    rShape = '|';
                    sb.append(rX).append(' ').append(rY)
                            .append(' ').append((char)rShape).append('\n');
                    break xx;
                }
            }
        }// end of tc
        System.out.println(sb);
    }

    static int[][][] dir = {
            {},
            {{1,0},{0,1}},  // 1
            {{-1,0},{0,1}}, // 2
            {{0,-1},{-1,0}},// 3
            {{0,-1},{1,0}}, // 4
            {{1,0},{-1,0}}, // |
            {{0,-1},{0,1}}, // -
            {{0,-1},{0,1},{-1,0},{1,0}} // +
    };

    static int rX,rY,rShape;
    // + 는 특수 블럭으로 양방향 모두 지나가야한다!!!!
    public static void solve(int x,int y,int lx, int ly) {
        // 그 블럭 모양대로 일단 보내자
        int tx = 0,ty = 0;
        switch (arr[x][y]) {
            case '|':
                for(int i=0;i<2;i++) {
                    tx = x+dir[5][i][0];
                    ty = y+dir[5][i][1];
                    if(tx==lx&&ty==ly) continue;
                    // 가는 도중 .을 만나면 거기가 빈칸.
                    // 4방향 탐색을 해서 맞는 블록을 만들어 주자.
                    // 그리고 종료
                    if(arr[tx][ty]=='.') {
                        findLoad(tx,ty);
                        return;
                    }
                    solve(tx, ty,x,y);
                    return;
                }
                break;
            case '-':
                for(int i=0;i<2;i++) {
                    tx = x+dir[6][i][0];
                    ty = y+dir[6][i][1];
                    if(tx==lx&&ty==ly) continue;
                    // 가는 도중 .을 만나면 거기가 빈칸.
                    // 4방향 탐색을 해서 맞는 블록을 만들어 주자.
                    // 그리고 종료
                    if(arr[tx][ty]=='.') {
                        findLoad(tx,ty);
                        return;
                    }
                    solve(tx, ty,x,y);
                    return;
                }
                break;
            case '+':
                // +는 무작정 이동시켜주면 안된다. 방금 들어온 곳을 이동시켜야한다.
                // +로 이동한 지점의 반대편으로 보내주면 된다.
                for(int i=0;i<4;i++) {
                    // 좌 우 상 하
                    tx = x+dir[7][i][0];
                    ty = y+dir[7][i][1];
                    // 이번게 이전꺼면
                    if(tx==lx&&ty==ly) {
                        // 요거의 반대편으로 tx,ty를 이동
                        switch (i) {
                            case 0: // 우로 이동
                                tx = x+dir[7][1][0];
                                ty = y+dir[7][1][1];
                                break;
                            case 1:
                                tx = x+dir[7][0][0];
                                ty = y+dir[7][0][1];
                                break;
                            case 2:
                                tx = x+dir[7][3][0];
                                ty = y+dir[7][3][1];
                                break;
                            case 3:
                                tx = x+dir[7][2][0];
                                ty = y+dir[7][2][1];
                                break;
                        }
                    }else continue;
                    // 가는 도중 .을 만나면 거기가 빈칸.
                    // 4방향 탐색을 해서 맞는 블록을 만들어 주자.
                    // 그리고 종료
                    if(arr[tx][ty]=='.') {
                        findLoad(tx,ty);
                        return;
                    }
                    solve(tx, ty,x,y);
                    return;
                }
                break;
            case '1':
                for(int i=0;i<2;i++) {
                    tx = x+dir[1][i][0];
                    ty = y+dir[1][i][1];
                    if(tx==lx&&ty==ly) continue;
                    // 가는 도중 .을 만나면 거기가 빈칸.
                    // 4방향 탐색을 해서 맞는 블록을 만들어 주자.
                    // 그리고 종료
                    if(arr[tx][ty]=='.') {
                        findLoad(tx,ty);
                        return;
                    }
                    solve(tx, ty,x,y);
                    return;
                }
                break;
            case '2':
                for(int i=0;i<2;i++) {
                    tx = x+dir[2][i][0];
                    ty = y+dir[2][i][1];
                    if(tx==lx&&ty==ly) continue;
                    // 가는 도중 .을 만나면 거기가 빈칸.
                    // 4방향 탐색을 해서 맞는 블록을 만들어 주자.
                    // 그리고 종료
                    if(arr[tx][ty]=='.') {
                        findLoad(tx,ty);
                        return;
                    }
                    solve(tx, ty,x,y);
                    return;
                }
                break;
            case '3':
                for(int i=0;i<2;i++) {
                    tx = x+dir[3][i][0];
                    ty = y+dir[3][i][1];
                    if(tx==lx&&ty==ly) continue;
                    // 가는 도중 .을 만나면 거기가 빈칸.
                    // 4방향 탐색을 해서 맞는 블록을 만들어 주자.
                    // 그리고 종료
                    if(arr[tx][ty]=='.') {
                        findLoad(tx,ty);
                        return;
                    }
                    solve(tx, ty,x,y);
                    return;
                }
                break;
            case '4':
                for(int i=0;i<2;i++) {
                    tx = x+dir[4][i][0];
                    ty = y+dir[4][i][1];
                    if(tx==lx&&ty==ly) continue;
                    // 가는 도중 .을 만나면 거기가 빈칸.
                    // 4방향 탐색을 해서 맞는 블록을 만들어 주자.
                    // 그리고 종료
                    if(arr[tx][ty]=='.') {
                        findLoad(tx,ty);
                        return;
                    }
                    solve(tx, ty,x,y);
                    return;
                }
                break;
        }

    }// end of main

    // 길을 가는 도중 .을 만났을 경우 만들어줘야할 블럭 찾기
    static int[] dx = {-1,1,0,0}; // 상 하 좌 우
    static int[] dy = {0,0,-1,1};
    public static void findLoad(int x,int y) {
        rX = x;
        rY = y;
        // 왼쪽이 갈 수 있는 곳인지 판단하기
        int t = arr[x][y-1];
        if(t=='-'||t=='+'||t=='1'||t=='2'||t==target) {
            // 왼쪽이 갈 수 있는 곳이라면 후보는 - + 3 4
            // 오른쪽도 갈 수 있는 지 봐주자
            t = arr[x][y+1];
            if(t=='-'||t=='+'||t=='3'||t=='4'||t==target) {
                // 그러면 후보는 - +
                // 위에만 한 번 더 봐주자
                t = arr[x-1][y];
                if(t=='+'||t=='|'||t=='1'||t=='4'||t==target) {
                    // 위쪽이 갈 수 있다면 최종은 +
                    rShape = '+';
                }else {
                    // 위쪽이 갈 수 없다면 최종은 -
                    rShape = '-';
                }
            }else {
                // 오른쪽이 갈 수 없는 곳이라면 후보는 3 4
                // 위에만 한 번 더 봐주자
                t = arr[x-1][y];
                if(t=='+'||t=='|'||t=='1'||t=='4'||t==target) {
                    // 위쪽이 갈 수 있다면 최종은 3
                    rShape = '3';
                }else {
                    // 위쪽이 갈 수 없다면 최종은 4
                    rShape = '4';
                }
            }
        }else {
            // 왼쪽이 갈 수 없는 곳이라면 후보는 | 1 2
            // 위쪽을 봐주자
            // 오른쪽도 갈 수 있는 지 봐주자
            t = arr[x][y+1];
            if(t=='-'||t=='+'||t=='3'||t=='4'||t==target) {
                // 왼쪽이 갈 수 없는데 오른쪽이 갈 수 있다면 후보는 1,2

                // 위를 봐주자
                t = arr[x-1][y];
                if(t=='+'||t=='|'||t=='1'||t=='4'||t==target) {
                    // 위에가 갈 수 있는 곳이라면
                    rShape = '2';
                }else {
                    // 위에가 갈 수 없는 곳이라면
                    rShape = '1';
                }
            }else {
                // 왼쪽이 갈 수 없는데 오른쪽이 갈 수 없다면
                rShape = '|';
            }
        }
    }
}// end of class