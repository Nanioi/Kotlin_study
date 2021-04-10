package com.example.myapplication.Kotlin

//02.자료형
//정수형 -> Long > Int > Short > Byte
//실수형 -> Double > Float
//문자 -> Char
//문자열 -> String
//논리형(참 True / 거짓 False ) -> Boolean

// 변수 선언방법 (1)
// var/val 변수명 = 값

var number = 10
//-> 앞으로도 정수형만 선언가능

// 변수 선언방법 (2)
// var/val 변수 : 자료형 = 값

var num1: Int = 20
var hello1: String = "hello"
var point1: Double = 3.4

//Variable or Value ???
//  -1. 변하지 않는 값 : Value
//  -2. 모르겠다 : Value -> Variable

fun main(array: Array<String>) {
    number = 20
    // number = 20.5 불가능}
}