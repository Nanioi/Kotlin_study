package com.example.myapplication.Kotlin
//사칙연산

fun main(array:Array<String>){
    val calculator=Calculator()

    println(calculator.plus(1,2,3,4,5))
    println(calculator.minus(10,1,2,3))
    println(calculator.multiply(1,2,3,4))
    println(calculator.divide(10,2,3))

    println()

    val calculator2=Calculator2(3)
    calculator2.plus(5).minus(5)
    // -> Chaining(체이닝)
}
class Calculator(){
    fun plus(vararg numbers :Int):Int{
        var result:Int=0
        numbers.forEach {
            result+=it
        }
        return result
    }
    fun minus(vararg numbers :Int):Int{
        var result:Int=numbers[0]
        for(i in 1 until numbers.size){
            result-=numbers[i]
        }
        return result
    }
    fun multiply(vararg numbers :Int):Int{
        var result:Int=1
        numbers.forEach {
            if(it!=0) {
                result *= it
            }
        }
        return result
    }
    fun divide(vararg numbers :Int):Int{
        var result:Int=numbers[0]
        numbers.forEachIndexed() {index,value->
            if(index!=0 && value!=0){
                result/=value
            }
        }
        return result
    }
}

class Calculator2(val initialValue:Int){
    fun  plus(number:Int):Calculator2{
        val result = this.initialValue + number
        return Calculator2(result)
    }
    fun  minus(number:Int):Calculator2{
        val result = this.initialValue - number
        return Calculator2(result)
    }
    fun  multiply(number:Int):Calculator2{
        val result = this.initialValue * number
        return Calculator2(result)
    }
    fun  divide(number:Int):Calculator2{
        val result = this.initialValue / number
        return Calculator2(result)
    }
}