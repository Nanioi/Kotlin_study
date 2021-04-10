package com.example.myapplication.Kotlin

// - 인터페이스도 구현이 있는 함수를 만들수 있음
// - 인터페이스에 구현이 있는 함수는 그 인터페이스를 구현하는 클래스에서 그 함수를 구현할 필요가 없다.
// - 인터페이스에 구현이 없는 함수는 그 인터페이스를 구현하는 클래스에서 그 함수를 반듯이 구현해야 한다.
fun main(args :Array<String>){
    val student_:Student_ = Student_()
    student_.eat()
    student_.sleep()
}

interface Person__{
    fun eat(){
        println("먹는다.")
    }
    fun sleep(){
        println("잔다.")
    }
    abstract fun study() // abstract를 붙이면 구현하는 클래스에서 반드시 구현해야 함
}
class Student__ :Person__{
    override fun study() {
        TODO("Not yet implemented")
    }
}
class SoccerPlayer_ : Person__{
    override fun study() {

    }
}