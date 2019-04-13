package data_structure;

import java.util.HashSet;

public class MergeSort {
    public static void main(String[] args) {
        String num = "123";


    }
    HashSet<String> hs = new HashSet<>();
    private boolean isWrong(String num) {

        for(int i=1,j=1,k=1;i<10;k++){
            if(i==j) continue;
            if(j==k||i==k) continue;
            if(k==10){
                k=1;
                j++;
            }
            if(j==10){
                j=1;
                i++;
            }
        }

        if(hs.contains(num)) return false;
        else return true;
    }
}
