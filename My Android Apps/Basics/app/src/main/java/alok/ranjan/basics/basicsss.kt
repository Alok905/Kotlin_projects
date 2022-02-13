package alok.ranjan.basics

class Person(fname:String = "Alok", lname:String = "Joshi")
{
    init{
        println("$fname and $lname")
    }
}
class MobilePhone(osName:String = "Android", brand:String = "Samesung", model:String = "Galaxy S20 Ultra")
{
//    fun show()
//    {
//        println("$osName, $brand, $model")
//    }
    init{
        println("$osName, $brand, $model")
    }
}
//fun temp(a:Int,b:Int)
//{
//    a=3
//    b=8
//    println("$a $b")
//    var a=6
//    var b=9
//    println("$a $b")
//}

class A(a:Int, b:Int){
    var m = a


    //    init{
//        println("$a  $b")
    fun show(){
//        a = 9
//        b = 3
//        println("$m  $n")
    }
}
fun main()
{
    var x = A(4, 5)
    x.show()
//    println("${x.m}  ${x.n}")
//    x.a=5
//    x.b=2
//    println("${x.a}  ")
//    temp(5,8)
//    var A = MobilePhone()


//    var q = MobilePhone()
//    var w = MobilePhone(osName = "Mac")
//    var e = MobilePhone(brand = "Apple")
//
//
//    var r = MobilePhone(model = "A14 bionic")
//    var a = Person()
//    var b = Person(fname = "Ranjan")
//    var c = Person(lname = "Patra")
//    var d = Person("Chandi", "Gelii")
//    println("Hello World")
//    var x:Byte=27
//    var x1:Int = 343
//    var x2:Short = 4344
//    var x3:Long = 223442424
//    x1=x.toInt()
//    println(x1)
//
//    var str:String? = "Alok"
//    var len = str?.length
//    str=null
//    var st = str?:"default"
//    println(st)
//    var s = str!!.toLowerCase()
//    println(s)

}