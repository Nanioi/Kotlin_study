package com.example.myapplication.Kotlin

// 18. 인터페이스
// - 인터페이스는 약속! -> 너가 이것을 구현한다면 너도 이( 인터페이스 ) 타입이다!
// - 생성자가 없음 -> 인스턴스화(생성) 시킬 수 없다 -> 설명서가 아님
// - 지침서 -> 니가 이것을 구현하고 싶다면 !반드시! 아래 기능을 구현하여라!

fun main(args :Array<String>){
    val student_:Student_ = Student_()
    student_.eat()
    student_.sleep()
}

//인터페이스
// 구현하는 아이들이 많이 달라도 eat, sleep의 기능 있으면 인터페이스 사용만
interface Person_{
    fun eat()
    fun sleep()
}
class Student_ :Person_{
    override fun eat() {
        TODO("Not yet implemented")
    }
    override fun sleep() {
        TODO("Not yet implemented")
    }
}
class SoccerPlayer : Person_{
    override fun eat() {
        TODO("Not yet implemented")
    }
    override fun sleep() {
        TODO("Not yet implemented")
    }
}

// 상속과 다른점
// - 상속은 조상을 찾아가는 느낌
// - 인터페이스는 종의 특징

//상속
// 자식클래스들이 공통으로 가지고 있는 경우 부모클래스에 메서드 추출
// 자식클래스들이 부모클래스와 비슷한 경우
open class Person(){
    open fun eat(){

    }
    fun sleep(){

    }
}
class Student():Person(){
    override fun eat(){
        super.eat()
    }
}
class Teacher():Person(){

}