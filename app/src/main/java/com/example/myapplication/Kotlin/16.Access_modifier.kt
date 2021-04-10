package com.example.myapplication.Kotlin

//16. 접근 제어자
// -> private

fun main(array:Array<String>) {
    val testAccess: TestAccess = TestAccess("아무개")
//    testAccess.test()
//    println(testAccess.name)
}

class TestAccess{
    private var name : String = "홍길동" // ->외부에서 접근 불가, 클래스 외부에서 값 변경 불가

    constructor(name :String){
        this.name=name
    }
    private fun test(){
        println("테스트")
    }// 외부에서 함수 사용 불가
}