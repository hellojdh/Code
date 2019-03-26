package data_structure;

public class Queue {
    static int[] queue = new int[100];
    static int front = -1, rear = -1;
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            add(i);
        }

        System.out.println("===== poll =====");
        for(int i=0;i<10;i++){
            System.out.print(poll()+" ");
        }
    }

    public static void add(int data){
        queue[++rear] = data;
    }

    public static int poll(){
        return queue[++front];
    }
}
