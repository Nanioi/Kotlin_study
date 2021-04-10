package com.example.myapplication.Kotlin

// 17. 상속
// 부모로부터 설명서를 물려받는다!

// 두번까지는 봐줌, 두번이상이 넘어가면 리팩토링!

//fun main(args:Array<String>){
//    val superCar100 : SuperCar100 = SuperCar100()
//    superCar100.drive()
//    superCar100.stop()
//
//    val bus100 : Bus100 = Bus100()
//    //bus100.drive() (x)
//}

//부모 : Car100
//자식 : SuperCar100
open class Car100(){
    open fun drive() : String{
        return "달린다"
    }
    fun stop(){

    }
}
// 없는 경우 private이 기본으로 설정됨
// 외부에서 상속을 받으려면 open을 앞에 써줘야

class SuperCar100():Car100(){
    override fun drive():String {
        val run = super.drive()
        return " 빨리 $run"
    }
}
class Bus100(){

}


//과제
// Night, Monster(부모)
// SuperNight , SuperMonster(자식)

fun main(args:Array<String>){
    val monster=SuperMonster(100,10)
    val night=SuperNight(130,8)
    monster.attack(night)
    monster.bite(night)

}

// 상속이 만들어낸 특징
// - 자식 클래스는 부모 클래스의 타입이다.
// - 부모 클래스는 자식 클래스의 타입이 아니다!

open class Charactor(var hp : Int, val power:Int){
    fun attack(charactor: Charactor,power:Int=this.power){ // 인자 없을 시 기본값 설정
        charactor.defense(power)
    }
    open fun defense(damage:Int){
        hp-=damage
        if(hp>0)println("${javaClass.simpleName}의 남은 체력 $hp 입니다.")
        else println("사망했습니다.")

    }
}


// 자식 클래스가 인스턴스화(생성) 되기 위해서 부모 클래스가 선행되서 인스턴스화 되어야한다.
class SuperMonster(hp : Int, power:Int ):Charactor(hp,power){ // 부모에서 사용하는 변수에는 var,val을 적으면 안됨 사용안한변수 추가 시 var,val써야함
    fun bite(charactor: Charactor){
        super.attack(charactor,power+2)
    }
}
class SuperNight(hp : Int, power:Int):Charactor(hp,power){
    val defensePower = 2
    override fun defense(damage:Int){
        super.defense(damage-defensePower)
    }

}