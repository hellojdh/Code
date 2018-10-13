package swexpert.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2477 {
	static int n,m,k,a,b;
    static int[] arrN,arrM,arrK;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arrN = new int[n];
            arrM = new int[m];
            arrK = new int[k];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                arrN[j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++)
                arrM[j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<k;j++)
                arrK[j] = Integer.parseInt(st.nextToken());
            sb.append("#"+i+" "+solve()+"\n");
        }
        System.out.print(sb);
    }
    
    private static int solve() {
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.tTime>o2.tTime) return 1;
                else if(o1.tTime==o2.tTime) {
                    if(o1.nNum>o2.nNum) return 1;
                    else if(o1.nNum==o2.nNum) {
                        if(o1.cNum>o2.cNum) return 1;
                        else return -1;
                    }else return -1;
                }else return -1;
            }
        });
        Queue<Pair> queue2 = new LinkedList<>();
        for(int i=0;i<k;i++)
            queue.add(new Pair(i+1,0,11,0,0,0,0));
        boolean[] visitedN = new boolean[n];
        boolean[] visitedM = new boolean[m];
        int result = 0;
        while(!queue.isEmpty()||!queue2.isEmpty()) {        
            // 각 size
            int size = queue.size();
            int size2 = queue2.size();
            for(int i=0;i<size2;i++) {
                Pair t = queue2.poll();
                if(t.mTime==0) {
                    boolean flag = false;
                    for(int j=0;j<m;j++) {
                        if(visitedM[j]) continue;
                        visitedM[j] = true;
                        t.mNum=j;
                        t.mTime++;
                        flag = true;
                        queue2.add(t);
                        break;
                    }
                    if(flag) continue;
                    queue2.add(t);
                    continue;
                }
                if(t.mTime==arrM[t.mNum]) {
                    visitedM[t.mNum] = false;
                    if(t.nNum+1==a && t.mNum+1==b)
                        result += t.cNum;
                    continue;
                }else {
                    t.mTime++;
                    queue2.add(t);
                    continue;
                }
            }
                
            for(int i=0;i<size;i++) {
                Pair t = queue.poll();
                t.tTime++;
                if(t.time!=arrK[t.cNum-1]) {
                    t.time++;
                    queue.add(t);
                    continue;
                }
                if(t.nTime==0) {
                    boolean flag = false;
                    for(int j=0;j<n;j++) {
                        if(visitedN[j]) continue;
                        visitedN[j] = true;
                        t.nNum = j;
                        t.nTime++;
                        flag = true;
                        queue.add(t);
                        break;
                    }
                    if(flag) continue;
                    queue.add(t);
                    continue;
                }
                if(t.nTime==arrN[t.nNum]) {
                    // 시간이 다됐다면 queue2로 넣어주기
                    visitedN[t.nNum] = false;
                    queue2.add(t);
                    continue;
                }else {
                    t.nTime++;
                    queue.add(t);
                    continue;
                }
            }
        }
        if(result==0) result=-1;
        return result;
    }
    
    static class Pair{
        private int cNum,time,nNum,nTime,mNum,mTime,tTime;
        Pair(int cNum,int time,int nNum,int nTime,int mNum,int mTime,int tTime){
            this.cNum = cNum;
            this.time = time;
            this.nNum = nNum;
            this.nTime = nTime;
            this.mNum = mNum;
            this.mTime = mTime;
            this.tTime = tTime;
        }
    }
}
