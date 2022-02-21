package com.example.kotlincoroutines

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext

/*
    Scope                    : Provide lifecycle methods for coroutines allow us to start and stop coroutines

    GlobalScope.launch {..}  : The scope of the coroutine is the lifecycle of the entire application



    runBlocking              : Create a scope and runs a coroutine in a blocking way

    *...................................................................................*
    // line 1
    runBlocking {
        // line 2
        launch(coroutineDispatcher) {
            // line 3
        }
        // line 4
    }
        // line 5
        someFunction()
    *...................................................................................*

    In case of using runBlocking lines of code will be executed in the next order:
    line 1
    line 2
    line 4
    line 3
    line 5 // this line will be executed after coroutine is finished

    coroutineScope {..}      : Creates a new scope. Does not complete until all children coroutines complete

*.....................................................................................*
    println("Before run-blocking") //1
    runBlocking {

        GlobalScope.launch {
            println("runBlocking -> GlobalScope-1") //2
        }

        launch {
            GlobalScope.launch {
                println("runblocking -> launch -> GlobalScope-1") //4
            }

            println("runblocking -> launch") //5

            GlobalScope.launch {
                println("runblocking -> launch -> GlobalScope-2") //6
            }
        }

        GlobalScope.launch {
            println("runBlocking -> GlobalScope-2") //3
        }
    }

    println("After run-blocking") //6
*.....................................................................................*
*/





/*
                                    ***NOTES TO REMEMBER***

    >>  runBlocking make partition between the outer members... like if runBlocking is declared inside main
        then the members of main() function will be divided before and after of runBlocking.

    >>  but inside the runBlocking, all things are executed like thread.

    >>  if GlobalScope is declared before coroutineScope then -> different thread
    >>  if GlobalScope is declared after coroutineScope then -> same thread
*/


/*
                        Context:
    >> A context is a set of data that relates to the coroutine
    >> All coroutine have associated context
    >> Important elements of context:
        i)  Dispatcher: Which thread the coroutine is run on
        ii) Job       : Handle on the coroutine lifecycle
*/

fun main(){

    // Scope
//    println("Before run-blocking") //1
//    runBlocking {
//        launch {
//            delay(7000)
//            println("launch")
//        }
//        coroutineScope {
//            delay(2000)
//            println("coroutineScope")
//        }
//        GlobalScope.launch {
//            delay(4000)
//            println("Global Scope")
//        }
//    }
//    println("After run-blocking") //7

    //Context
//    runBlocking {
//        launch(CoroutineName("myCoroutine")) {
//            println("${coroutineContext[CoroutineName.Key]}")
//        }
//        GlobalScope.launch {
//
//        }
//        coroutineScope {
//
//        }
//    }

    ViewModel

}