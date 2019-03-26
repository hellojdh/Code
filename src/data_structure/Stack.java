package data_structure;

public class Stack {
    public static int[] stack = new int[100];
    public static int top = -1;
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            push(i);
        }
        System.out.println("===== pop ======");
        for(int i=0;i<10;i++){
            System.out.print(pop()+" ");
        }
    }

    public static void push(int t){
        stack[++top] = t;
    }

    public static int pop(){
        return stack[top--];
    }
}
