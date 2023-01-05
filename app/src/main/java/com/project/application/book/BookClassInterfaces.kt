package com.project.application.book

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