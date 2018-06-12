package programmers.level1;

// 보류 문제
public class 행렬의곱셈 {
    static int[][] solution(int[][] arr1, int[][] arr2) {
    	int len = arr1.length > arr2.length? arr1.length:arr2.length;
    	int len2 = arr1[0].length > arr2[0].length? arr1[0].length:arr2[0].length;
    	int[][] result = new int[len][len2];
    	for(int i=0; i<len; i++) {    	
    		for(int j=0; j<len2; j++) {
    			result[i][j] = arr1[i][j] * arr2[i][j];
    		}    		
    	}    	
    	return result;
    }
}
