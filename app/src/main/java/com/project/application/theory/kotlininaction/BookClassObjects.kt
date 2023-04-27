package com.project.application.theory.kotlininaction

import java.io.File

//Class to practice with code from the book "Kotlin In Action"
class BookClassObjects

/*
* The use of the object reserved word is Kotlin's first class support for
* the Singleton pattern, it declares a class and one single instance of this class
*  */
internal object Payroll {
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary() {
        for (person in allEmployees) {
            val sal = 1
        }
    }
}

internal data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person?, o2: Person?): Int =
            o1!!.name.compareTo(o2!!.name)
    }
}

/*
* Object declarations can also inherit from classes and interfaces
* */
internal object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File?, o2: File?): Int {
        return o1!!.path.compareTo(o2!!.path, ignoreCase = true)
    }
}

fun useObject() {
    Payroll.allEmployees.add(Person("alice"))
    Person.NameComparator
    Payroll.calculateSalary()
    CaseInsensitiveFileComparator
}

/*
* This shows NewUser instances being created by different constructors
* */
class OtherUser {
    private val nickName: String

    constructor(email: String) {
        nickName = email.substringBefore("@")
    }

    constructor(accountId: Int) {
        nickName = getUserFrom(accountId)
    }
}

/*
* This shows NewUser instances being created by a Factory
* instead of being created from different constructors
* */
class NewUser private constructor(
    override val nickName: String
) : User {
    companion object {
        fun newSubscribingUser(email: String) =
            NewUser(email.substringBefore("@"))

        fun newFacebookUser(accountId: Int) =
            NewUser(getUserFrom(accountId))
    }
}

/*
* A companion object is just a regular object declared inside a class,
* it can have properties, methods and extensions
* */
class NewPerson(val name: String) {
    companion object Loader {
        fun fromJSON(jsonText: String): NewPerson =
            NewPerson(
                name = "name"
            )
    }
}

/*
* Implementing an interface in the companion object
* */
interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class OtherPerson(val name: String) {
    companion object : JSONFactory<OtherPerson> {
        override fun fromJSON(jsonText: String): OtherPerson =
            OtherPerson(
                name = jsonText,
            )
    }
}

fun <T> loadFromJSON(factory: JSONFactory<T>): T {
    return factory.fromJSON("")
}

/*
* We can use the name of the class that contains the Companion Object
* as an instance of an object that implements the interface
* */
private fun useTheExample() {
    loadFromJSON(OtherPerson)
    OtherPerson.Companion.fromJSON("")
}

/*
* You can have the definition of a Companion Object extension function
* in a decoupled manner
* */
class Profiler() {
    companion object
}

fun Profiler.Companion.execute() {
    val a = 1
}

fun useExtExample() {
    Profiler.execute()
    Profiler.Companion.execute()
}

/*
* The object reserved word is also used to declare anonymous objects
* Every time the code is called a new instance of the object is created, it is not a singleton.
* */
fun useAnonObject() {
    var a = 0
    loadFromJSON(object : JSONFactory<OtherPerson> {
        override fun fromJSON(jsonText: String): OtherPerson {
            a++
            return OtherPerson(
                name = jsonText
            )
        }
    })
}