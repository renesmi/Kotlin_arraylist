package com.example.camera

fun main(){
    //map 역할 - key value pair(짝)
    //{"키":"값"}
    var map1 = mapOf(Pair("name","sumin"))
    var map2 = mutableMapOf<String,String>()
    map2.put("age","25")
    map2.put("name","sumin")
    println(map2.keys)
    for(map in map2){
        println(map.value)
    //keys


    }

}
