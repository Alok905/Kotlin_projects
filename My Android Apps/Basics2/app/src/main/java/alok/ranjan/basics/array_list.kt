package alok.ranjan.basics

data class Fruit(val name:String, val price:Int){}
fun main(){
    val F = arrayOf(Fruit("Apple", 76), Fruit("Orange", 45))
//    print(F.contentToString())
    val M = arrayOf(Fruit("Apple", 45),5,8.9f,43,8,784343434,3432)
    M[3]=89
//    print(M[3])
//    for(value in M)
//        println(value)
    val months = listOf("Jan", "Feb", "March")
    val nmonths = months.toMutableList()

    val arrmonth = arrayOf("April", "May", "June")
    val int = arrayOf(1,2,3,4,5)
    nmonths.addAll(arrmonth)
    println(nmonths)
    val limonths = listOf("July", "August","Sept")
    nmonths.addAll(limonths)
    println(nmonths)
    nmonths.removeAll(limonths)
    println(nmonths)
}