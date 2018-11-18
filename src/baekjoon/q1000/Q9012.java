package baekjoon.q1000;

import java.util.Scanner;

public class Q9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int tc = sc.nextInt();
        for(int i=0;i<tc;i++){
            String t = sc.next();
            stack.clear();
            for(int j=0;j<t.length();j++){
                if(t.charAt(j)=='('){
                    stack.push(1);
                }else{
                    // 항상 짝이 있어야하므로 미리 ( 가 들어와있지 않았다면 실패
                    if(stack.size()==0){
                        stack.push(1);
                        // 실패시 바로 종료시키기
                        break;
                    }else stack.pop();
                }
            }
            if(stack.size()!=0) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}

// 필요한 기능만 구현
class Stack<T>{
    private Node<T> top;
    private int size;

    void clear(){
        size = 0;
        top = null;
    }
    int size(){
        return size;
    }
    void push(T data){
        if(size==0) top = new Node(data,null);
        else top = new Node(data,top);
        size++;
    }

    T pop(){
        if(size==0) return null;
        else{
            T t = top.data;
            top = top.prev;
            size--;
            return t;
        }
    }

    private class Node<T>{
        T data;
        Node prev;
        Node(T data, Node prev){
            this.data = data;
            this.prev = prev;
        }
    }
}
