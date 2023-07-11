package com.project.application.theory.bytecode

//To see the difference
//inline
fun firstFun(action: () -> Unit) {
    val a = 0
    action.invoke()
}

fun secondFun() {
    firstFun {
        fun innerFun() {
            println("Second Fun")
        }
        innerFun()
    }
}

fun thirdFun() {
    firstFun {
        val string = "Third Fun"
        run {
            println(string)
        }
    }
}

fun fourthFun() {
    firstFun {
        println("Fourth Fun")
    }
}

fun fifthFun() {
    firstFun {
        b.invoke()
    }
}

fun sixthFun() {
    firstFun {
        c.invoke()
    }
}

fun seventhFun() {
    firstFun {
        d().invoke()
    }
}

fun eighthFun() {
    firstFun {
        e().invoke()
    }
}

val a: (b: Int) -> Unit = { int: Int -> int + 1 }

val b: () -> Unit = { println("Fifth Fun") }

val c: () -> Unit = fun() = println("Sixth Fun")

fun d() = fun() = println("Seventh Fun")

fun e() = fun() {
    println("Eighth Fun")
}

fun main() {
    secondFun()
    thirdFun()
    fourthFun()
    fifthFun()
    sixthFun()
    seventhFun()
    eighthFun()
}