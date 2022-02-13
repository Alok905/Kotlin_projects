//package alok.ranjan.basics
//
//abstract class abs(str: String){
//    constructor(str: String, m: Int): this(str){
//        println("str = $str and m = $m")
//    }
//    init{
//        println("init of abstract class")
//        println("argument passed through primary constructor\n")
//    }
//    var x: Int = 56
//    abstract var y: Int
//    fun show(){
//        println("show function of abstract class")
//    }
//    abstract fun printx()
//}
//class A: abs("xxx", 7){
//    override var y: Int = 29
//    override fun printx(){
//        println("printx function is overridden by class A")
//    }
//}
//fun main(){
//    var x = A()
//    println(x.x)
//    println(x.y)
//    x.show()
//    x.printx()
//}