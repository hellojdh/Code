package programmers.level1;

public class 콜라츠추측 {
	public static void main(String[] args) {
		System.out.println(solution(626331));
	}
    static int solution(int num) {
    	int temp = num;
    	int cnt = 0;
    	while(temp != 1) {
    		if(temp%2 == 0) {
    			temp = temp/2;
    		}else {
    			temp = temp*3 + 1;
    			if(temp<0) return -1;
    		}
    		cnt++;
    		if(cnt == 500) return -1;
    	}
    	return cnt;
    }
}
