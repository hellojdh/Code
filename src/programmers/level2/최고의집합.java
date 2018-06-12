package programmers.level2;

public class 최고의집합 {
	int[] t;
	int[] result;
	int temp;
	public int[] solution(int n, int s) {
		int max = 0;
		t = new int[n+1];
		result = new int[n];
		temp = s;
		find(1);
		
		if(!check) {
			t = new int[1];
			t[0] = -1;
			return t;
		}
		return result;		
	}
	int max = 0;
	int multiMax = 0;
	boolean check = false;
	
	public void find(int a) {
		if(t[t.length-1] != 0) {
			for(int i=1; i<=t.length; i++) {
				max += t[i];
			}
			if(max == temp) {
				int mulTemp = 0;
				for(int i=1; i<=t.length; i++) {
					mulTemp *= t[i];
				}
				if(multiMax < mulTemp) {
					mulTemp = mulTemp;
					check = true;
					for(int i=1; i<=t.length; i++) {
						result[i-1] = t[i];
					}
				}
			}else {
				t[t.length-1] = 0;
			}
		}
		for(int i=a; i<(temp/2)+1; i++) {
			t[a] = i;
			find(i+1);
		}
	}
}
