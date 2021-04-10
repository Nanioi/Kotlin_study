package com.example.myapplication.Kotlin

var a = 1+2+3+4+5 // 연산의 결과값을 변수에 넣어줄 수 있다.
var b = "1"
var c = b.toInt()
var d = b.toFloat()

var e = "John"
var f = "My name is $e Nice to meet you"
var g = a+3

// Null
// - 존재 X
//var abc : Int = null error발생
var abc1 : Int? = null // 자료형에 ? 를 붙이면 null을 가질 수 있는 type이 된다.
var abc2 : Double? = null // 문자열 "null" X

fun main(array: Array<String>){
    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
    println(f)
    println(g)

    println(abc1)
    println(abc2)
}