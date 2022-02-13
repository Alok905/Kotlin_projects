package alok.ranjan.basics
//
//data class F(val name: String, val price: Int)
//fun main() {
//    val array = arrayOf(4, "df", 78.9, 34, 9f, 's')
//    println(array.contentToString())
//    for (i in array.indices)
//        print("${array[i]} ")
//    println()
//    for (element in array)
//        print("$element ")
//    println()
//    println()
//    println()
//    var list = listOf(2, "String", 2.3f, 5.9, 'r')
//    println(list)
//    for (i in list.indices)
//        print("${list[i]} ")
//    println()
//    for (element in list)
//        print("$element ")
//    println()
////    list.add("jhdf")// can't do this because it's immutable by default
//    val mutlist = list.toMutableList()
//    /*
//    also we can do
//        val mutlist = mutableListOf(2, "String", 2.3f, 5.9, 'r')
//    */
//    println("Initial mutable list: $mutlist")
//    mutlist.add("str")
//    mutlist.add('s')
//    mutlist.add(34)
//    mutlist.add(56.98f)
//    mutlist.add(34.75)
//    println(mutlist)
//    mutlist.addAll(array)
//    println(mutlist)
//    mutlist.addAll(list)
//    println(mutlist)
//
//    println()
//    println()
//
//    var set = setOf("Apple", 4, 9.3f, 78.1256, 'c', 4, "Apple", F("Apple", 65))
//    println(set.size)
//    var mutset = set.toMutableSet()
//    mutset.add("String")
//    mutset.add(78.1256)
//    println(mutset.size)
//    mutset.addAll(array)
//    println(mutset)
//    mutset.addAll(list)
//    println(mutset)
//    val setF = setOf(F("Apple", 65), F("Orange", 50), 67)
//    mutset.addAll(setF)
//    println(mutset)
//
//    println()
//    println()
//
//    val map = mapOf(1 to "One", 2 to 't', "three" to 3, 40 to F("Apple", 40), "Fav" to F("Orange", 70))
//    println(map)
//    val mutmap = map.toMutableMap()
//    println(mutmap.containsValue(F("Apple", 40)))
//    println(mutmap.containsValue(2))
//    println(mutmap.containsValue("Fav"))
//    println(mutmap.getValue("Fav"))
//    println(mutmap.get(40))
////    println(mutmap.getOrDefault(4,))
//    for(i in mutmap.keys)
//        print("${map[i]} ")
//    println()
//    for(element in mutmap)
//        print("$element ")
//    println()
//    for(i in mutmap.asIterable())
//        print("$i ")
//
//
//    println()
//    println()
//
//    val arli = arrayListOf(4, 45.65f, 45,23594, 'c', "String", F("Apple", 65))
//    println(arli)
//    println(arli.size)
//    arli.add(F("Orange", 25))
//    arli.add(458)
//    println(arli)
//    println(arli.size)
//    arli.addAll(array)
//    println(array)
//    arli.addAll(mutlist)
//    println(arli)
//    arli.addAll(mutset)
//    println(arli)
//    println(arli.get(5))
//    val arlis = arrayListOf<String>()
//    println(arlis)
//    println(arlis.size)
//    arlis.add("First string")
//    arlis.add("Second string")
//    println(arlis)
//    println(arlis.size)
//    val lili = mutableListOf<String>()
//    println("$lili and ${lili.size}")
//    lili.add("String")
//    println("$lili and ${lili.size}")
//    println("lil")
//    val lil = arrayListOf<Any>(list)
//    println(list)
//    lil.add("List added")
//    lil.add("List again added")
//    println(lil)
//    val itr = lil.iterator()
//    while(itr.hasNext()) {
//        print("${itr.next()} ")
////        itr.next()
//    }
//    println()
//    lil.removeAt(0)
//    println(lil)
//    }
///*
// //Assignment
//fun main(){
//    val Alist = arrayListOf<Double>()
//    Alist.add(45.78544)
//    Alist.add(23.099884)
//    Alist.add(87.3433)
//    Alist.add(29.1384)
//    Alist.add(59.9474)
//    var sum: Double = 0.0
//    for(value in Alist)
//        sum += value
//    println("Average of $Alist = ${sum/Alist.size}")
//}
// */
//
class h{
    var x = 78
}
class i(var ix: Int){
    constructor(ix: Int, iy: Int): this(ix){
        this.ix = iy
    }

    init{
//        println(ix)
    }

}
fun main(){
    val ar = ArrayList<i>()
    var ob = i(3)
    ar.add(ob)
    ob = i(10)
    ar.add(ob)

    for(obj in ar){
        println(obj.ix)
    }

}
