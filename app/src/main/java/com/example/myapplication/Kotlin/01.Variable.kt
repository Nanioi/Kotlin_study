package com.example.myapplication.Kotlin

// 변수
// -> 상자
//      - 내 맘대로 원하는 것 넣을 수 있음 -> var
//      - 한번 넣으면 수정 불가 -> val
// var/val 변수명(상자 ) =값( 넣고싶은 것 )
// Variable / Value

var num = 10
var hello = "hello"
var point = 3.4

val fix = 20

fun main(args:Array<String>){
    println(num)
    println(hello)
    println(point)
    println(fix)

    num=100
    hello="Good bye"
    point=10.4
    //fix=500 -> 값변경 불가

    println(num)
    println(hello)
    println(point)
    println(fix)
}