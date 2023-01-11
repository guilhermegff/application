package com.project.application.book

//Class to practice with code from the book "Kotlin In Action"
class BookClassLambda

data class Container(val name: String, val age: Int)

val list = listOf<Container>(Container("A", 1), Container("B", 2))

/*
* If the lambda delegates to a property or a function
* then it can be replaced by a member reference
* */
fun findOldest() {
    list.maxByOrNull() { c: Container -> c.age }
    list.maxByOrNull { c: Container -> c.age }
    list.maxByOrNull { c -> c.age }
    list.maxByOrNull { it.age }
    list.maxByOrNull(Container::age)
    list.filter { it.age > 3 }
    list.all { it.age > 3 }
    val b = listOf("a", "ab", "b")
    b.groupBy(String::first)
}

/*
* Example of a high level member reference
* */
fun useMemberReference() {
    val action = { container: Container ->
        sendEmail(container)
    }
    val nextAction = ::sendEmail
}

fun sendEmail(container: Container) {}

/*
* Example of a constructor reference
* */
fun useConstructorReference() {
    val createContainer = ::Container
    val container = createContainer("A", 1)
    val verify = Container::isNew
    val a = container::age
}

fun Container.isNew() = this.age < 2

/*
* When a lambda is stored in a variable then
* the parameters types must be specified
* */
fun storeLambda() {
    val getAge = { c: Container -> c.age }
    list.maxByOrNull(getAge)
}

/*
* It is possible to use function parameters and properties in lambdas
* inside the function
* */
fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    var count = 0
    messages.forEach {
        println("$prefix $it")
        count++
    }
}