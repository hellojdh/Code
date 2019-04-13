package data_structure;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args){
        int[] arr = {2,6,4,3,4,1,56,7,9,9,7,6,54,13};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int targetIdx = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j]<arr[targetIdx]){
                    targetIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[targetIdx];
            arr[targetIdx] = tmp;
        }
    }
}
