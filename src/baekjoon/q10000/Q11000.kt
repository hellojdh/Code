package baekjoon.q10000

import java.util.*
import kotlin.Comparator

fun main(args:Array<String>){
    var sc : Scanner = Scanner(System.`in`)
    var n = sc.nextInt()
    var arr : Array<Pair> = Array(n,{Pair(0,0) })
    for(i in 0..(n-1))
        arr[i] = Pair(sc.nextInt(),sc.nextInt())

    Arrays.sort(arr, Comparator { o1: Pair, o2: Pair ->
        if(o1.e==o2.e) o1.s.compareTo(o2.s)
        else o1.e.compareTo(o2.e) })
    var result = 1
    var end = arr[0].e
    for(i in 1..(n-1)){
        if(arr[i].s>=end){
            result++
            end = arr[i].e
        }
    }
    println(result)
}
class Pair(val s: Int, val e: Int)