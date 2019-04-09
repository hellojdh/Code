package baekjoon.q10000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q10866 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    if(deque.size()==0)
                        sb.append(-1).append('\n');
                    else sb.append(deque.getFirst()).append('\n');
                    break;
                case "back":
                    if(deque.size()==0)
                        sb.append(-1).append('\n');
                    else sb.append(deque.getLast()).append('\n');
                    break;
                case "empty":
                    if(deque.size()==0)
                        sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "pop_front":
                    if(deque.size()==0)
                        sb.append(-1).append('\n');
                    else sb.append(deque.pollFirst()).append('\n');
                    break;
                case "pop_back":
                    if(deque.size()==0)
                        sb.append(-1).append('\n');
                    else sb.append(deque.pollLast()).append('\n');
                    break;
                case "size":
                    sb.append(deque.size()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }// end of main
}// end of class