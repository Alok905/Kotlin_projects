//package alok.ranjan.basics
//
//interface If{
//    var str: String
//    var m: Int
//    fun show(){
//        println("show function of If")
//    }
//    fun printx()
//}
//open class A(fname: String, lname: String, override var m: Int): If{
//    init{
//        println("init of class A")
//        println("fname = $fname and lname = $lname")
//    }
//    override  var str: String = "str initialised in class A"
//    override fun printx(){
//        println("printx is overridden in class A")
//    }
//    override fun show(){
//        println("show function is overridden in A")
//    }
//}
//class B(fn: String, ln: String, age: Int): A("xxx", "yyy", 20){
//    override fun show(){
//        println("show function is overridden in class B")
//    }
//}
//fun main(){
//    var x = B("Alok", "Ranjan", 19)
//    println(x.str)
//    x.show()
//    x.printx()
//}