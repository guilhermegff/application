package com.project.application.theory.kotlininaction

//Class to practice with code from the book "Kotlin In Action"
class BookClassDelegateBy

/*
* Decorator pattern with all members implemented
* */
private class DelegateCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>()
    override val size: Int = innerList.size
    override fun contains(element: T): Boolean = innerList.contains(element)
    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)
    override fun isEmpty(): Boolean = innerList.isEmpty()
    override fun iterator(): Iterator<T> = innerList.iterator()
}

/*
* Kotlin has first class support for delegating.
* The use of by reserved word indicates the delegation of interface implementation
* so all member methods are generated automatically by the compiler
* */
private class DelegatingCollection<T>(
    innerList: Collection<T> = ArrayList<T>()
) : Collection<T> by innerList

/*
* Specific methods can be overriden while others
* are delegated to the interface implementation
* */
private class CountingSet<T>(
    val innerSet : MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {
    var objectsAdded = 0
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}