package alok.ranjan.basics

fun add(a:Int, b:Int)=a+b
val add1 = {a:Int, b:Int -> a+b}
val add2:(Int, Int)->Int = {a, b -> a+b}
val add3 = {a:Int,b:Int->println(a+b)}
open class M{
    protected var x:Int = 20
}
class B: M(){
    fun show(){
        println("x is $x")
    }
}
fun main(){
//    println(add(3,4))
//    println(add1(3,4))
//    println(add2(3,4))
//    add3(3,4)
    var m = M()
    var b = B()
    b.show()
//    println(M.x)
//    println(b.n)
}