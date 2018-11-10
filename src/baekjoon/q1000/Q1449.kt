package baekjoon.q1000

import java.util.*

fun main(args:Array<String>){
    var sc : Scanner = Scanner(System.`in`)
    var n = sc.nextInt()
    // 양쪽의 0.5개의 사용을 미리 빼주기
    var L = sc.nextInt()-1
    // 최대 1000개
    var arr : Array<Int> = Array(1001,{0})
    for(i in 1..n)
        arr[sc.nextInt()] = 1

    var result = 0
    for(i in 1..1000){
        if(arr[i]==1){ // 물이 센곳이면
            result++ // 테이프 하나를 사용
            // L-1 길이만큼 사용해서 덮을 수 있는곳을 다 덮어주기
            for(j in i..(i+L)) {
                if(j==1001) break
                arr[j] = 0
            }
        }
    }
    println(result)
}