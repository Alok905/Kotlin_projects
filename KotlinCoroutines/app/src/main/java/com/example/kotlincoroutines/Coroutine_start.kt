package com.example.kotlincoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
    Scope                : Create and run coroutines, provides lifecycle events
    Context              : The scope provides a context in which the coroutine runs
    Suspending Functions : Functions that can be run in a coroutine (can be suspended)
    Jobs                 : A handle on a coroutine
    Deferred             : A future result of a coroutine
    Dispatcher           : Manages which thread(s) the coroutine runs on

    >> Error handling
 */
/*
    Suspend functions can only be called inside any other suspend function or
    any coroutine. For example:
            delay() -> It's a suspend function so it can only be called inside any other
            suspend function or any coroutine.
*/

fun main() {
/*
    GlobalScope.launch {
        delay(1000)
        println("World")
    }
    println("Hello")
    Thread.sleep(1000)
    println("hiii")


    here first "Hello" is printed. if Thread.sleep(1000) was not written then it will stop the execution.
    Till the last statement of main function execution, the program continues and after that it stops.

    The main function execution must remain more than the time required to execute the implementations inside the GlobalScope.launch {..}
    to execute the code inside the GlobalScope.launch {..}
*/
    GlobalScope.launch {
        delay(2000)
        println("World")
    }
    println("Hello")
    Thread.sleep(5000)

}