package alok.ranjan.basics

import java.lang.IllegalArgumentException

/*
class person(fname: String, lname: String)
{
    var age: Int? = 5
    var hobby: String = "to watch netflix"
    var firstname:String = fname

    //member function
    fun statehobby()
    {
        println("\n$firstname's hobby is $hobby\n")
    }
    //secondary constructor
    constructor(fn: String, ln: String , ag: Int ) : this(fn,ln) {
        age = ag
        println("\nsecondary constructor is callled \n$fn $ln,  $age\n")
    }
    init {
        println("INIT block is called")
        println("$fname $lname .... $age")
    }
}

fun main()
{
//    var Alok = person()
//    Alok.statehobby()
//    Alok.hobby = "to play bgmi"
//    Alok.statehobby()

//    var Ram = person("Ram", "Charan", 26)

    var x = person("Alok", "Ranjan", 26)
    x.age = 89
    println(x.age)
    x.statehobby()
//    x.hobby = "to play bgmi"
//    x.age = 32
//    x.statehobby()

}
 */

/*
//lateinit
//Getter and Setter
class Car
{
    var color: String = ""
        get() = field + "-mno"

        set(value){
            field = value + "-xyz"
        }
    var batch_no:Int = -1
        get() = field
        set(value){
            field = if(value > 0) value else throw IllegalArgumentException("Batch no. can't be negative")
        }
    var brand: String = "BMW"
    get() = field.toLowerCase()
    private set

    fun setBrand(brand: String){
        this.brand = brand
    }
}

class Plane
{
    var color:String = "Navy"
        get() = field + " ->get<-"
        set(value)
        {
            field = value + "->set<-"
        }
    var size:Int = 200
        get() = field
        set(value)
        {
            field = if(value >= 50) value else throw IllegalArgumentException("can't be less than 50")
        }
    var windows:Int = 20
        get() = field
        private set

    fun set_windows(x:Int)
    {
        windows = x
    }
}

class Person(fname:String, lname:String)
{
    var age:Int = -1
    init{
        println("\ninit block called")
        println("$fname $lname $age\n")
    }
    constructor(fn:String = "sec", ln:String = "ond", age:Int = 24):this("this", "part"){
        this.age = age
        println("\nSecondary constructor called\n")
    }
}

fun main()
{
    var p = Person()
    println(p.age)

//    var plane = Plane()
//    plane.color = "Blue"
////    plane.size = 20
//    plane.size = 80
////    plane.windows = 60
//    plane.set_windows(90)
//    println("${plane.windows}    ${plane.size}    ${plane.color}")

//    var car = Car()
//    car.color = "Navy"
//    car.batch_no = 586
//    car.setBrand("Audi")
//    println("${car.color}    ${car.brand}    ${car.batch_no}")
}
 */
/*
//data class
data class User(val id: Long, var name: String)

fun main()
{
    var u1 = User(34, "Alok")
    var u2 = u1
    var u3 = u1.copy(id = 89)
    println("u1->   $u1")
    println("u2->   $u2")
    println("u3->   $u3")
    u2.name = "Ranjan"
    println("u2->   $u2")
    println("\nu1 ->  ${u1.component1()}   ${u1.component2()}")
}
 */

/*
class MobilePhone(osName: String, brand: String, model: String){
    private var battery:Int = 30
    init{
        println("The phone $model from $brand uses $osName as its Operating System")
    }
    fun chargeBattery(charged:Int)
    {
        println("Battery before = $battery")
        battery += charged
        println("Battery now = $battery")
    }
}
fun main()
{
    var x = MobilePhone("Android", "Samesung", "Samesung Galaxy FE 5g")
    x.chargeBattery(29)
}
 */
/*
open class Car(name: String, brand: String){
    var range: Double = 0.0

    fun extendRange(amount: Double)
    {
        range+=amount
    }

    fun drive(km: Int)
    {
        println("Run for $km kilometers")
    }
}
class ElectricCar(brnd: String, battery: Int):Car("A3", brnd){

}

fun main()
{
    var ecar = ElectricCar("Audi", 5000)
    ecar.drive(300)
}
 */
/*
open class bird{
    open var color:String = "Black"
    open fun fly(){
        println("Bird is flying..")
    }
}
//interface duck{
//    var color: String = "Maroon"
//    fun fly1(){
//        println("Duck is flying")
//    }
//}
class parrot:bird(){
    override var color = "Green"
    override fun fly(){
        super.fly()
        println("Parrot is flying...")
    }
    fun fly(name:String){
        println("$name is flying")
    }
}
fun main()
{
    var p = parrot()
    p.fly()
}

 */
/*
open class A(fname: String, lname: String){
    init{
        println("Inititlizer of class A is called...")
        println("A class:  $fname and $lname\n")
    }
    var m: Int = 4
    open fun show(){
        println("\nThis is class A")
        println("m = $m\n")
    }
}
class B(fn: String, ln: String, age: Int): A("xxx", "yyy"){
//    override var m = 12
    override fun show(){
        println("\nThis is B class")
        println("m = $m\n")
        m = 12
        println("m = $m\n")
    }
}
fun main(){
    var x = B("Alok", "Ranjan", 19)
    println(x.m)
//    x.m = 12
//    println(x.m)
    x.show()
}
*/
/*
//Inheritance
open class A(fname: String, lname: String){
    init{
        println("init of A class is called")
        println("$fname $lname")
    }
    open var age = 5
    open fun show(){
        println("Show function of class A")
        println("age = $age")
    }
}
class B(fn: String, ln: String, ag: Int): A("xxx", "yyy"){
    override var age = 15
    override fun show(){
        super.show()
        println("It's overridden")
        println("Overriden show function of B class")
        println("Overridden age = $age")
    }
}

fun main(){
    var x = B("Alok", "Ranjan", 19)
    println()
    println(x.age)
    println()
    x.show()
  }
 */
/*
// Interface
interface Drivable{
    val maxSpeed: Double
//    val age: Int
    fun drive(): String
    fun brake(){
        println("Drivable is braking")
    }
}
open class Car(val name: String, val brand: String): Drivable{
    init{
        println("init of class Car")
        println("$name  $brand")
    }
    override val maxSpeed: Double = 456.67
//    override val age: Int = 46
    override fun drive(): String = "Drivable is driving with class A"
//    override fun drive(){
//        println("Drivable is driving")
//    }
//    fun drive(km: Int){
//        println("Driving without returning $km")
//    }
//    override fun brake(){
//        println("Brake function is overridden")
//    }
}
class B(nm: String, brnd: String, bat: Double): Car("name", "brand"), Drivable{
    override fun drive(): String = "class B is driving"
    override fun brake(){
        super<Car>.brake()
        println("Brake function is overridden in B")
    }
}
fun main(){
    var w =Car("tesla", "hdieh")
    var x = B("Audi", "A3", 1500.567)
    x.brake()
    w.brake()
}

 */
