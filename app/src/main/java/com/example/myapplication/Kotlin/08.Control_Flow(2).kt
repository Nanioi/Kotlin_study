package com.example.myapplication.Kotlin

//08. 제어흐름
//- When

fun main(args : Array<String>){
    val value: Int = 3

    when(value){
        1->{
            println("value is 1")
        }
        2->{
            println("value is 2")
        }
        3 -> println("value is 3")
        else -> println("I do not know")
        // 증괄호는 삭제 가능
    }

    if ( value ==1) println("value is 1")
    else if( value ==2 ) println("value is 2")
    else if( value ==3 )println("value is 3")
    else println("I do not know")
    // 위와 똑같은 기능으로 if 조건문이 많을땐 when을 사용하는 것이 좋음

    val value2 = when (value){
        1->10
        2->20
        3->30
        else->100
    }
    println(value2)


    val value3 : Boolean? = null

    when(value3){
        true-> println()
        false-> println()
        null-> println()
    }// when 구문은 조건으로 갖는 값의 모든 경우에 대응 해주는 것이 좋다.

    val value4 = when(value3){
        true->1
        false->2
        null->3
    }// 값을 리턴하는 when 구문의 경우 반드시 값을 리턴해야 한다.

    // when의 다양한 조건식 (1)
    val value5:Int =10
    when(value5){
        is Int -> { // is -> 타입을 물을 수 있는 연산자
            println(" is Int")
        }
        else -> {
            println(" is not Int")
        }
    }

    // when의 다양한 조건식 (2)
    val value6: Int = 87
    when(value6){
        in 60..70 ->{
            //60-70 사이에 있다.
        }
        in 70..80 ->{
            //70-80 사이에 있다.
        }
        in 80..90 ->{
            //80-90 사이에 있다.
        }
    }
}