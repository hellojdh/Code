package baekjoon.q1000;

import java.util.Scanner;

public class Q5373 {
	static int[][] cube = new int[6][9];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i=0;i<tc;i++) {
        	int n = sc.nextInt();
            init(); // 큐브 초기화
        	for(int j=0;j<n;j++) {
        		String t = sc.next();
        		int m = 0; // 면 지정
        		switch(t.charAt(0)) {
        		case 'U':m=0;break;
        		case 'D':m=1;break;
        		case 'F':m=2;break;
        		case 'B':m=3;break;
        		case 'L':m=4;break;
        		case 'R':m=5;break;
        		}
        		if(t.charAt(1)=='-') {
        			// 반 시계라면 3번 돌리기
        			for(int k=0;k<3;k++)
        				solve(m);
        		}else solve(m);
        	}
        	for(int j=0;j<9;j+=3) {
        		System.out.println(""+(char)cube[0][j]+(char)cube[0][j+1]+(char)cube[0][j+2]);
        	}
        }
    }
    
    static int[][] selfR = {{2,8},{5,7},{8,6},{6,0},{7,3},{3,1}};
    // 위 아래 앞 뒤 왼 오
    static int[][] other = {{3,5,2,4}, // 위
    						{2,5,3,4}, // 아래
    						{0,5,1,4}, // 앞
    						{0,4,1,5}, // 뒤
    						{0,2,1,3}, // 좌
    						{0,3,1,2}}; // 우
    static int[][][] otherR2 = {{{0,0},{1,1},{2,2}},
    							{{6,6},{7,7},{8,8}},
    							{{2,8},{5,7},{8,6}},
    							{{2,0},{5,1},{8,2}},
    							{{2,6},{5,3},{8,0}},
    							{{2,2},{5,5},{8,8}}};
    static int[][][] otherR = {{{0,0},{1,1},{2,2},{0,0},{1,1},{2,2},{0,0},{1,1},{2,2}}, // 위
    							{{6,6},{7,7},{8,8},{6,6},{7,7},{8,8},{6,6},{7,7},{8,8}},// 아래
    							{{6,0},{7,3},{8,6},{0,2},{3,1},{6,0},{0,2},{1,5},{2,8}},// 앞
    							{{2,0},{1,3},{0,6},{0,6},{3,7},{6,8},{6,8},{7,5},{8,2}},// 뒤
    							{{6,6},{3,3},{0,0},{6,6},{3,3},{0,0},{6,2},{3,5},{0,8}},// 좌
    							{{2,6},{5,3},{8,0},{0,8},{3,5},{6,2},{2,2},{5,5},{8,8}}}; // 우 
    private static void solve(int m) {
    	// 자신 돌리기
    	int t = cube[m][0];
    	int t2 = cube[m][1];
    	for(int i=5;i>=0;i--)
    		cube[m][selfR[i][1]] = cube[m][selfR[i][0]];
    	// 임시 저장 되돌리기
    	cube[m][2]=t; cube[m][5]=t2;
    	
    	// 주변 돌리기
    	int[] arr = new int[3];
    	for(int i=0;i<3;i++)
    		arr[i] = cube[other[m][3]][otherR2[m][i][0]];

    	for(int i=6;i>=0;i-=3) {
    		for(int j=i;j<3+i;j++) {
        		cube[other[m][i/3+1]][otherR[m][j][1]] 
        				=cube[other[m][i/3]][otherR[m][j][0]];
    		}
    	}
    	// 임시 저장한거 돌려놓기
    	for(int i=0;i<3;i++)
    		cube[other[m][0]][otherR2[m][i][1]] = arr[i];
    }
    
    // 위 아래 앞 뒤 왼 오
    static int[] initCube = {'w','y','r','o','g','b'};
    private static void init() {
    	for(int i=0;i<6;i++) {
    		for(int j=0;j<9;j++) 
    			cube[i][j] = initCube[i];
    	}
    }
}