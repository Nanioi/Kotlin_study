package com.example.myapplication.Kotlin

//11. 반복문

fun main(array:Array<String>){
    val a= mutableListOf<Int>(1,2,3,4,5,6,7,8,9)

    //반복하는 방법 (1)
    for (item in a){
        println(item)
    }
    for (item in a){
        if(item == 5) println("is 5")
        else println("is not 5")
    }
    println()

    //반복하는 방법 (2)
    for((index,item) in a.withIndex()){
        println("index : " + index + " value : " + item )
        // 문자열 + 아무거나 = 문자열
    }
    println()

    //반복하는 방법 (3)
    a.forEach {
        println(it)
    }

    //반복하는 방법 (4)
    a.forEach{ item->
        println(item)
    }

    //반복하는 방법 (5)
    a.forEachIndexed{ index,item ->
        println("index : " + index + " value : " + item )
    }

    //반복하는 방법 (6)
    println(a.size) // 9
    for(i in 0 until a.size){ // 0 - 8까지 , 마지막 포함 X
        println(a.get(i))
        println(a[i])
    }
    println()

    //반복하는 방법 (7)
    for(i in 0 until a.size step(2)){
        println(a.get(i)) //짝수
    }
    println()

    //반복하는 방법(8)
    for(i in a.size -1 downTo (0)){
        println(a[i])//역순
    }
    println()

    //반복하는 방법 (9)만
    for(i in a.size-1 downTo (0) step(2)){
        println(a[i]) // 홀수 역순
    }

    //반복하는 방법 (10)
    for(i in 0..10){ // 0-10까지 마지막을 포함
        println(i)
    }

    //반복하는 방법 (11)
    //while문을 벗어날 조건을 반드시 포함해야함
    var x:Int =0
    var y:Int =4

    while(x<y){
        x++
        println("x")
    }

    //반복하는 방법 (12)
    //while문의 조건이 만족하지 않더라도 do의 실행이 반드시 한번은 실행됨
    // 조건 만족까지 무한 반복
    // 조건문 벗어날 조건 반드시 포함해야함
    do{
        println("hello")
        x--
    }while(x>y)

    //구구단
    for(x in 1..9){
        for(y in 1..9){
            println("$x x $y = ${x*y}")
        }
    }
}