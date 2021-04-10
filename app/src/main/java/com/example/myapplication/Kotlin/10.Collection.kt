package com.example.myapplication.Kotlin

//10. Collection
// -> list, set, map

// List
fun main(args : Array<String>){

    ////////////Immutable Collections (변경불가) //////////
    //List -> 중복 허용
    val numList = listOf<Int>(1,2,3,3,3)
    println(numList)
    println(numList.get(0))
    println(numList[0])

    //set 집합 -> 중복 허용 X
    val numSet = setOf<Int>(1,2,3,3,3)
    println()
    println(numSet)
    // numSet.get X -> index가 없음
    numSet.forEach{
        println(it)
    }

    //Map -> Key,Value 방식으로 관리
    val numMap = mapOf<String,Int>("one" to 1 , "two" to 2)
    println()
    println(numMap.get("one"))


    /////////////Mutable collections (변경가능) ///////////////
    //List
    val mNumList=mutableListOf<Int>(1,2,3)
    mNumList.add(3,4)
    mNumList.add(0,100) // 1->100 (X) 100,1,2,3으로 한칸씩 밀
    mNumList.set(0,200)// 100 ->200
    mNumList.removeAt(1) // 1 (인덱스 1)이 사라짐
    println()
    println(mNumList)

    //Set
    val mNumSet= mutableSetOf<Int>(1,2,3,4,4,4)
    mNumSet.add(10) // 인덱스 없음
    mNumSet.remove(2)// 2가 사라짐
    mNumSet.remove(100)// 에러발생 안함, 그냥 변동 X
    println()
    println(mNumSet)


    //Map
    val mNumMap= mutableMapOf<String,Int>("one" to 1)
    mNumMap.put("two" ,2)
    //mNumMap.replace("one",3)
    println()
    println(mNumMap)
    println(mNumMap.keys)
    println(mNumMap.values)
    mNumMap.clear() // 전부 삭제

}