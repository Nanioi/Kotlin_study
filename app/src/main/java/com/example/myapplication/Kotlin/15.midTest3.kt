package com.example.myapplication.Kotlin

// TV 클래스
// - on/off 기능
// - 채널 돌리는 기능
// - 초기 채널은 (S사, M사 , K사 3개)

fun main(array:Array<String>){

    val tv=TV(listOf<String>("K","M","S"))
    tv.switch()
    println(tv.onOrOff)
    tv.switch()
    println(tv.onOrOff)

    tv.channelUP()
    println(tv.checkCurrentChannel())
    tv.channelDOWN()
    println(tv.checkCurrentChannel())


}
class TV(val channels:List<String>){
    var onOrOff:Boolean=false
    var currentChannelNumber=0
        set(value){
            field=value
            //currentChannelNumber=value (x) -> 무한루프, 할당할때마다 호출되어 무한루프를 돌게됨
            if(field>2)
                field=0
            if(field<0)
                field=2
            println(value)
        }
        get(){
            println("호출되었습니다. ")
            return field
        }
    //값의 할당

    fun switch(){
        onOrOff = !onOrOff
    }
    fun checkCurrentChannel():String{
        return channels[currentChannelNumber]
    }
    fun channelUP(){
        currentChannelNumber=currentChannelNumber+1
//        channels.forEachIndexed{ index,value ->
//            if(currentChannelNumber==index){
//                currentChannelNumber=currentChannelNumber+1
//                return
//            }
//        }
    }
    fun channelDOWN(){
        currentChannelNumber=currentChannelNumber-1
//        channels.forEachIndexed{ index,value ->
//            if(currentChannelNumber==index){
//                currentChannelNumber=currentChannelNumber-1
//                return
//            }
//        }
    }
}