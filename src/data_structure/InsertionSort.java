package data_structure;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] agrs){
        int[] arr = {10,9,8,7,8,4546,6,5,4,3,2,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr){
        int j = 0;
        for(int i = 1; i < arr.length; i++){
            int target = arr[i];
            for(j = i-1; j >= 0; j--){
                if(target<arr[j]){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = target;
        }
    }
}
