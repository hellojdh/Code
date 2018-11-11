package baekjoon.q10000

import java.util.*

fun main(args:Array<String>){
    var sc : Scanner = Scanner(System.`in`)
    var n = sc.nextInt()
    var total = sc.nextInt()
    var arr : Array<Int> = Array(n,{0})
    for(i in 0..(n-1))
        arr[i] = sc.nextInt()
    var result = 0
    // 최소 동전 수이므로 큰 동전 값부터 살펴보자
    for(i in (n-1) downTo 0){
        // 큰 동전을 사용할 수 있는 만큼 사용해주기
        while(true){
            if(total-arr[i]>=0){
                total-=arr[i]
                result++
            }else break
        }
    }
    println(result)
}