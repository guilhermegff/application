package com.project.application.theory.kotlininaction

//Class to practice with code from the book "Kotlin In Action"
class BookClassLambda

data class Container(val name: String, val age: Int)

class ExampleClass(val v: Int) {
    fun oneFun(a: Int) {

    }
}

val action = { a: Int ->
    singleFun(a)
}

val nextAction = ::singleFun

fun singleFun(a: Int){

}

val list = listOf<Container>(Container("A", 1), Container("B", 2))

val list2 = listOf<ExampleClass>(ExampleClass(1))

/*
* If the lambda delegates to a property or a function
* then it can be replaced by a member reference
* */
fun findOldest() {
    /*withReferences.maxByOrNull() { c: Container -> c.age }
    withReferences.maxByOrNull { c: Container -> c.age }
    withReferences.maxByOrNull { c -> c.age }
    withReferences.maxByOrNull { it.age }
    withReferences.maxByOrNull(Container::age)
    nextAction(1)
    val exampleClass = ExampleClass(1)
    val a = ExampleClass::oneFun
    a(exampleClass, 1)
    val c = exampleClass::oneFun
    c(1)
    withReferences.filter { it.age > 3 }
    withReferences.all { it.age > 3 }
    val b = listOf("a", "ab", "b")
    b.groupBy(String::first)
    withReferences.asSequence().map { it }.filter { it.age > 1 }.toList()*/
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
    /*val getAge = { c: Container -> c.age }
    withReferences.maxByOrNull(getAge)*/
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