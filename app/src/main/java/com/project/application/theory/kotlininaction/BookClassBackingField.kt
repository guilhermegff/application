package com.project.application.theory.kotlininaction

//Class to practice with code from the book "Kotlin In Action"
class BookClassBackingField

/*
* Use the field reserved word to reference the backing field for the property
* The backing field can be accessed from getters and setters.
* Compiler creates the backing field whenever it is referenced explicitly
* and also when default setter and getter implementation is used
* */
internal class Profile(val name: String) {
    var address: String = "unspecified"
    set(value) {
        println("""
                Address was changed for $name:
                "$field" -> "$value"."""".trimIndent()
            )
        field = value
    }

    override fun equals(other: Any?): Boolean {
        if(other is Profile) {
            return this.name == other.name
        }
        return false
    }

    override fun hashCode(): Int {
        return name.length * 2
    }
}

/*
* Accessor method visibility can be changed. It has the same
* visibility as its property by default
* */
internal class LengthCounter() {
    constructor(a: Int) : this()
    constructor(b: String) : this()

    var counter : Int = 0
        private set
    fun addWord(word: String) {
        counter += word.length
    }
}

private fun lengthCount() {
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("a")
    lengthCounter.counter
}