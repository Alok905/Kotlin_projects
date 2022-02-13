package alok.ranjan.basics

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main(){
    val maps = mutableMapOf(1 to "one", 't' to "two", "th" to "three", "four" to 4)
//    for(value in maps)
//        println(value)
//    println(maps)
//    for(keys in maps.keys)
//        println("$keys and ${maps[keys]}")
//    println(maps.containsValue("two"))
//    println(maps.getOrDefault('c',"Ram"))
//    println(maps.getValue(1))
//    maps.remove("th")
//    println(maps)
    val sets = mutableSetOf('c',"Alok",12,"Nonsense", 12)
    println(sets.size)
    println(sets)
    sets.add("Joshi")
    sets.add("Alok")
    println(sets)
    val lists = listOf("Mno", "Alok", "Kanha", 12, "Ranjan")
    sets.addAll(lists)
    println(sets)
}

