package com.project.application.theory.kotlininaction

//Class to practice with code from the book "Kotlin In Action"
class BookClassInterfaces

/*
* Interfaces can have declarations of abstract properties
* */
internal interface User {
    val nickName: String
}

//High level fun
internal fun getUserFrom(accountId: Int) : String = "user"

/*
* Class property implements abstract interface property and is declared on primary constructor,
* override reserved word is required
* */
private class PrivateUser(override val nickName: String) : User

/*
* Class property implements the abstract property by providing
* a getter that computes its return value on each call
* */
private class SubscribingUser(val email: String) : User {
    override val nickName: String
        get() = email.substringBefore('@' )
}

/*
* Class property implements the abstract property by setting
* a backing field that is computed from a call to another function.
* This value is stored on the property after class initialization
* */
private class FacebookUser(val accountId: Int) : User {
    override val nickName: String = getUserFrom(accountId)
}

internal interface Clickable {
    fun click()
    fun showOff() = println("Click")
}

internal interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if(b) "got" else "lost"} focus.")
    fun showOff() = println("Focus")
}

internal class Button1 : Clickable, Focusable {
    override fun click() {
        TODO("Not yet implemented")
    }

    override fun showOff() {
        super<Clickable>.showOff()
        //super<Focusable>.showOff()
    }
}

internal abstract class Abstraction {
    abstract fun tryFirst()
    open fun trySecond() {

    }
    fun tryThird() {

    }
}

internal class Concrete : Abstraction() {
    override fun tryFirst() {
        TODO("Not yet implemented")
    }
}

sealed interface ClassSealed {
    class SealedA : ClassSealed
    object SealedB : ClassSealed
    data class SealedC(val a : Int) : ClassSealed
}

class SealedD : ClassSealed {

}

data class SealedE(val a: Int) : ClassSealed







