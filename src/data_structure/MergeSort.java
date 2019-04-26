package data_structure;

public class MergeSort {
    static int[] arr,copy;
    public static void main(String[] args) {
        arr = new int[100];
        copy = new int[100];
        mergeSort(0,arr.length-1);
    }
    public static void mergeSort(int left, int right){
        if(right-left<1) return;
        int mid = (right+left)/2;

        mergeSort(left,mid);
        mergeSort(mid+1,right);

        // 합쳐주기
        int tLeft = left, tRight = mid+1;
        int idx = left;
        while(tLeft<=mid && tRight<=right){
            if(arr[tLeft]<arr[tRight]){
                copy[idx++] = arr[tLeft++];
            }else{
                copy[idx++] = arr[tRight++];
            }
        }

        while(tLeft<=mid)
            copy[idx++] = arr[tLeft++];
        while(tRight<=right)
            copy[idx++] = arr[tRight++];

        for(int i = left; i <= right; i++){
            arr[i] = copy[i];
        }
    }


}
