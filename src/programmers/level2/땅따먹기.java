package programmers.level2;

import java.util.Set;

public class 땅따먹기 {
	public int solution(int[][] land) {
		int result = 0;
		for(int i=0; i<land.length-1; i++) {
			land[i+1][0] += Math.max(land[i][1], Math.max(land[i][2], land[i][3]));
			land[i+1][1] += Math.max(land[i][0], Math.max(land[i][2], land[i][3]));
			land[i+1][2] += Math.max(land[i][0], Math.max(land[i][1], land[i][3]));
			land[i+1][3] += Math.max(land[i][0], Math.max(land[i][1], land[i][2]));
		}
		
		int endSize = land.length -1;
		result = Math.max(land[endSize][0], Math.max(land[endSize][1], Math.max(land[endSize][2], land[endSize][3])));
		return result;
	}
}
