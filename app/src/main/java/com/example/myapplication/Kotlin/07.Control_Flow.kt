package com.example.myapplication.Kotlin

//07. 제어흐름
//- if, else

fun main(args: Array<String>){
    val a:Int = 5
    val b:Int = 10

    if(a>b){
     //      1  a>b
        println("a>b")
    }else if(a<b){
    //      2  b>a
        println("b>a")
    }else {
    //      3  a=b
        println("a=b")
    }


//값을 리턴하는 if 사용
    val max = if(a>b){
        a
    }else{
        b
    }
    println(max)

    // 엘비스 연산자
    val n1 : Int? =null
    val n2 = n1 ?: 10 // n1이 널이면 10 널이 아니면 n1이 n2에 대입된다.

    println(n1)
    println(n2)

}