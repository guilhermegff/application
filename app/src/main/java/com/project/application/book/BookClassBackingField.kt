package com.project.application.book

//Class to practice with code from the book "Kotlin In Action"
class BookClassBackingField

/*
* Use the field reserved word to reference the backing field for the property
* The backing field can be accessed from getters and setters.
* Compiler creates the backing field whenever it is referenced explicitly
* and also when default setter and getter implementation is used
* */
private class Profile(val name: String) {
    var address: String = "unspecified"
    set(value) {
        println("""
                Address was changed for $name:
                "$field" -> "$value"."""".trimIndent()
            )
        field = value
    }
}

/*
* Accessor method visibility can be changed. It has the same
* visibility as its property by default
* */
private class LengthCounter {
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