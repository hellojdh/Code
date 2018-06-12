package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 제일작은수제거하기 {
    static int[] solution(int[] arr) {
    	int[] result = new int[arr.length-1];
    	int small = 9999999;
    	int idx = -9;
    	List<Integer> list = new ArrayList<>();
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i] < small) {
    			small = arr[i];
    			idx = i;
    		}
    		list.add(arr[i]);
    	}
    	
    	list.remove(idx);
    	if(list.isEmpty()) result[0] = -1;
    	int i=0;
    	for(int t : list) {
    		result[i++] = t;
    	}
    	return result;
    }
}
