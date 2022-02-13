package alok.ranjan.basics

class person(fname: String = "Alok", lname: String = "Joshi")
{
    var age: Int? = null
    var hobby: String = "to watch netflix"

    //member function
    fun statehubby()
    {
        println("my hubby is $hobby")
    }
}

fun main()
{
    var x = person()
    x.statehubby()
}