package com.example.myapplication.Kotlin

//은행계좌 만들기
// - 계좌 생성기능( 이름, 생년월일, 초기금액)
// - 잔고를 확인하는 기능
// - 출금기능
// - 예금기능

fun main (array: Array<String>){

    val account=Account("곽나연","1998/08/02",1000)

    println(account.checkBalance())
    account.save(1000)
    println(account.withdraw(2000))
    println(account.checkBalance())

    println()
    val account2=Account2("곽나연","1998/08/02")
    println(account2.checkBalance())

}
class Account{

    val name:String
    val birth:String
    var balance:Int

    constructor(name:String,birth:String, balance:Int){
        this.name=name
        this.birth=birth
        if(balance>=0){
            this.balance=balance
        }else
            this.balance=0
    }
    fun checkBalance():Int{
        return balance
    }
    fun  withdraw(amount:Int) : Boolean{
        if(balance >= amount) {
            balance-=amount
            return true
        }else {
            return false
        }
    }
    fun save(amount: Int){
        balance += amount
    }

}
class Account2(val name:String,val birth:String, var balance:Int=1000){
    fun checkBalance():Int{
        return balance
    }
    fun  withdraw(amount:Int) : Boolean{
        if(balance >= amount) {
            balance-=amount
            return true
        }else {
            return false
        }
    }
    fun save(amount: Int){
        balance += amount
    }
}
class Account3(initialBalance:Int){
    val balance:Int=if(initialBalance >=0)initialBalance else 0

    fun checkBalance():Int{
        return balance
    }
}