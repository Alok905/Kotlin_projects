//package alok.ranjan.basics
//
//class X{
//    var x:Int = 45
//
//    fun show(){
//        println("Show function of class X")
//        println("x = $x")
////        y = 8
//    }
//    class Y{
//        var y:Int = 4
//        fun show1(){
//            println("show1 function of class Y")
//            println("y = $y")
//
////            println("x = $x")
//            x = 9
//        }
//    }
//}
//fun main(){
//    var m = X.Y()
////    m.Y.y
////    print
////    ln(m.x)
////    println(m.Y().y)
////    X.Y().y
////    println(m.x)
////    m.show()
////    println(X.Y().y)
//}

class A(var a: Int = 4, var b: Int = 8){
    init{
        println("$a and $b")
    }
    fun funtion(){
        B(this, 5, 6)
    }
}
class B(a: A, b: Int, c: Int){
    init{
        println("${a.a}   ${a.b}    $b     $c")
    }
}
fun main(){
//    A(5, 6)
    A().funtion()
}