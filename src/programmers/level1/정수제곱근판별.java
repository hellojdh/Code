package programmers.level1;

public class 정수제곱근판별 {
    static long solution(long n) {
    	long a = (int)Math.sqrt(n);
    	if(a*a != n) return -1;
    	else return (a+1)*(a+1);
    }
}
