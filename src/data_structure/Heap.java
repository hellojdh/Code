package data_structure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Heap {
    static int[] heap = new int[40];
    static Integer[] check = new Integer[30];
    static int heapSize = 0;

    public static void main(String[] args){
        Random random = new Random();
        for(int i=0;i<30;i++) {
            check[i] = random.nextInt(3000);
            push(check[i]);
        }

        Arrays.sort(check, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<30;i++)
            System.out.print(check[i]+" ");
        System.out.println();
        for(int i=0;i<30;i++)
            System.out.print(pop()+" ");
    }

    public static int pop(){
        int parent = 1, child = 2;
        int tmp = heap[heapSize]; // Last Data
        int result = heap[1];

        while(child<heapSize){
            if(child+1<heapSize && heap[child] < heap[child+1])
                child++;

            if(tmp>=heap[child])
                break;

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = tmp;
        heapSize--;
        return result;
    }

    public static void push(int data){
        int target = heapSize+1;

        while(target!=1 && data>heap[target/2]){
            heap[target] = heap[target/2];
            target /= 2;
        }

        heap[target] = data;
        heapSize++;
    }
}
