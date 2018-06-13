package programmers.level2;

public class 가장큰정사각형찾기 {
	public int solution(int[][] board) {
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				try {
					if(board[i][j] >= 1 && board[i-1][j] >= 1 && board[i][j-1] >= 1 && board[i-1][j-1] >= 1) {
						board[i][j]+= Math.min(board[i][j-1], Math.min(board[i-1][j], board[i-1][j-1]));
					}
				}catch(Exception e) {}
			}
		}
		
		int max = 0;
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j] > max) max = board[i][j];
			}
		}
		
		return max*max;
	}
}
