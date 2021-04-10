package com.example.myapplication.Kotlin

//09. 배열

// 배열이 필요한 이유
// - 그룹(모음집)이 필요할때

fun main(args :Array<String>){

    //배열을 생성하는 방법(1)
    val group1 = arrayOf<Int>(1,2,3,4,5)

    println(group1 is Array)

    //배열을 생성하는 방법(2)
    var number1=10
    var group2 = arrayOf(1,2,3.5,"Hello")
    //타입을 지정하지 않으면 여러가지 타입이 들어간 배열생성가능

    //배열의 값을 꺼내는 방법(1)
    //group1.get(Index)
    val test1=group1.get(0) // 인덱스에 주의해야
    println(test1)

    //배열의 값을 꺼내는 방법(2)
    val test3=group1[0]
    println(test3)

    //배열의 값을 바꾸는 방법(1)
    group1.set(0,100)//->group1[0]==100함, 인덱스 주
    group1[1]=200

    //Array 의 Bounds ( Size )
    // - 처음 만들때 결정됨

    //배열 생성하는 방법 (3)
    val a1 = intArrayOf(1,2,3) // int형만 넣어야함
    val a2 = charArrayOf('a','b') // Char -> ' ' , String -> " "
    val a3 = doubleArrayOf (3.4,100.23)
    val a4 = booleanArrayOf(true,false,true)

    //배열을 생성하는 방법 (4) -> lambda를 활용한 방
    val a5 = Array(10,{0}) //size 10, 0으로 초기화법
    val a6 = Array(5,{1;2;3;4;5})

}
