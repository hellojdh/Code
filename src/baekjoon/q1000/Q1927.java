import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1927 {
    static int[] heap;
    static int heapSize;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        heap = new int[n+3];
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            if(t==0) sb.append(poll()).append('\n');
            else push(t);
        }
        System.out.println(sb);
    }// end of main

    public static int poll() {
        if(heapSize==0) return 0;
        int result = heap[1];
        int parent = 1,child = 2;
        int tmp = heap[heapSize];

        while(child<heapSize) {

            if(child + 1 <heapSize && heap[child]>heap[child+1])
                child++;

            if(tmp<=heap[child])
                break;

            heap[parent] = heap[child];
            parent = child;
            child*=2;
        }
        heap[parent] = tmp;
        heapSize--;
        return result;
    }

    public static void push(int data) {
        int target = heapSize+1;

        // 최소힙 -> 작은걸 head로
        while(target!=1 && heap[target/2]>data) {
            heap[target] = heap[target/2];
            target/=2;
        }
        heap[target] = data;
        heapSize++;
    }
}// end of class