package com.example.myapplication.Kotlin

// 04.Function
// - 함수
//      -  어떤 input을 넣어주면 어떤 output이 나오는 것
//      - y = x + 2

// 함수 선언 방법
// fun 함수명 ( 변수명: 타임, 변수명: 타입  ...... ) : 반환형 {
//    함수 내용
//    return 반환값
// }

fun plus (first : Int, second: Int):Int {
    val result:Int = first+second
    return result
}

// 디폴드 값을 갖는 함수 만들기
fun plusFive(first:Int, second: Int=5): Int{
    val result : Int = first + second
    return result
}

// 반환값이 없는 함수 만들기
fun printPlus(first:Int, second:Int):Unit{ // Unit은 생략가능
    val result: Int = first + second
    println(result)
}
fun printPlus2(first:Int, second:Int){
    val result: Int = first + second
    println(result)
}

// 간단하게 함수 선언방법
fun plusShort(first:Int,second:Int) = first + second

// 가변인자 갖는 함수 선언 방법
fun plusMany(vararg numbers:Int){
    for(number in numbers){
        println(number)
    }
}// n개의 인수를 받을 수 있음

fun main(array : Array<String>){

    // 함수 호출 방
    val result = plus(1,12)
    println(result)

    println(plus(5,10))

    // 인수를 명시적으로 전달
    val result1 = plus(first = 5, second = 10)
    println(result1)

    val result2 = plus ( second= 100, first = 10)
    println(result2)// 순서가 바뀌어도 인자로 지정된 값이 넘어간다. first =10 ,second = 100

    // 디폴트 값을 갖는 함수 호출
    println()
    val result3=plusFive(10,20)
    println(result3)

    val result4=plusFive(10)
    println(result4) // second의 기본값이 5로 출력은 15

    // 반환값 없는 함수 출력
    println()
    printPlus(5,10)
    printPlus2(10,20)

    //간단한 함수 생
    println()
    val result5 = plusShort(10,12)
    println(result5)

    println()
    plusMany(1,2,3,4)
}