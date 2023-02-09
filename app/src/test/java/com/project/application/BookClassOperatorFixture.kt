package com.project.application

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import java.math.BigDecimal
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

interface BookClassOperatorFixture {
    data class Point(val x: Int, val y: Int) {
        operator fun plus(other: Point): Point {
            return Point(x + other.x, y + other.y)
        }
    }

    class PointManual(val x: Int, val y: Int) {
        operator fun component1() = x
        operator fun component2() = y
    }

    data class MutablePoint(var x: Int, var y: Int)

    data class Rectangle(val upperLeft: Point, val lowerRight: Point)

    class PersonC(
        private val firstName: String,
        private val lastName: String
    ) : Comparable<PersonC> {
        override fun compareTo(other: PersonC): Int {
            return compareValuesBy(
                this, other,
                PersonC::firstName, PersonC::lastName
            )
        }
    }

    open class PropertyChangeAware {
        protected val changeSupport = PropertyChangeSupport(this)
        fun addPropertyChangeListener(listener: PropertyChangeListener) {
            changeSupport.addPropertyChangeListener(listener)
        }

        fun removePropertyChangeListener(listener: PropertyChangeListener) {
            changeSupport.removePropertyChangeListener(listener)
        }
    }

    class Component(size: String, weight: Int) : PropertyChangeAware() {
        var size: String = size
            set(newValue) {
                val oldValue = field
                field = newValue
                changeSupport.firePropertyChange(
                    "size", oldValue, newValue
                )
            }
        var weight: Int = weight
            set(newValue) {
                val oldValue = field
                field = newValue
                changeSupport.firePropertyChange(
                    "weight", oldValue, newValue
                )
            }
    }

    class ObservableProperty(
        val propName: String, var propValue: Int,
        val changeSupport: PropertyChangeSupport,
    ) {
        fun getValue(): Int = propValue
        fun setValue(newValue: Int) {
            val oldValue = propValue
            propValue = newValue
            changeSupport.firePropertyChange(propName, oldValue, newValue)
        }
    }

    class NewComponent(
        val name: String, age: Int, salary: Int
    ) : PropertyChangeAware() {
        private val _age = ObservableProperty("age", age, changeSupport)
        var age: Int
            get() = _age.getValue()
            set(value) {
                _age.setValue(value)
            }
        private val _salary = ObservableProperty("salary", salary, changeSupport)
        var salary: Int
            get() = _salary.getValue()
            set(value) {
                _salary.setValue(value)
            }
    }

    class NewObservableProperty(
        var propValue: Int, val changeSupport: PropertyChangeSupport
    ) {
        operator fun getValue(p: OtherComponent, prop: KProperty<*>): Int = propValue
        operator fun setValue(p: OtherComponent, prop: KProperty<*>, newValue: Int) {
            val oldValue = propValue
            propValue = newValue
            changeSupport.firePropertyChange(prop.name, oldValue, newValue)
        }
    }

    class OtherComponent(
        val name: String, age: Int, salary: Int,
    ) : PropertyChangeAware() {
        var age: Int by NewObservableProperty(age, changeSupport)
        var salary: Int by NewObservableProperty(salary, changeSupport)
    }

    class MoreComponent(
        val name: String, age: Int, salary: Int,
    ) : PropertyChangeAware() {
        private val observer = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
            changeSupport.firePropertyChange(prop.name, oldValue, newValue)
        }
        var age: Int by Delegates.observable(age, observer)
        var salary: Int by Delegates.observable(salary, observer)
    }
}

operator fun BookClassOperatorFixture.Point.plus(other: BookClassOperatorFixture.Point): BookClassOperatorFixture.Point {
    return BookClassOperatorFixture.Point(x + other.x, y + other.y)
}

operator fun BookClassOperatorFixture.Point.times(scale: Double): BookClassOperatorFixture.Point {
    return BookClassOperatorFixture.Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

operator fun BookClassOperatorFixture.Point.unaryMinus(): BookClassOperatorFixture.Point {
    return BookClassOperatorFixture.Point(-x, -y)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE

operator fun BookClassOperatorFixture.Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else ->
            throw java.lang.IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

operator fun BookClassOperatorFixture.MutablePoint.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else ->
            throw java.lang.IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

operator fun BookClassOperatorFixture.Rectangle.contains(p: BookClassOperatorFixture.Point): Boolean {
    return p.x in upperLeft.x until (lowerRight.x) &&
            p.y in upperLeft.y until (lowerRight.y)
}

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}

inline fun inlinedFun(action: (int: Int) -> Int): Int {
    var a = 0
    (a..10).forEach label@{
        if (it == 2) {
            a = action.invoke(it)
            return@label
        }
    }
    return a
}

interface Animal {
    fun animalFun() {
        println("Animal Fun")
    }
}

class Cat : Animal {
    fun catFun() {
        println("Cat Fun")
    }
}

class Dog : Animal {
    fun dogFun() {
        println("Dog Fun")
    }
}

class Herd<out T : Animal>(
    private val list: List<T> = ArrayList()
) : List<T> by list {
}

class Recipe<T : Food>(
    val ingredients: Collection<T> = ArrayList()
) {
    fun addIngredient(ingredient: T) {
        (ingredients as ArrayList).add(ingredient)
    }
}

fun startRecipe(recipe: Recipe<Food>) {
    recipe.ingredients.forEach {
        it.food()
    }
}

fun Animal.getIndex(): Int = if (isA<Dog>(this)) 0 else 1

fun enumerateCats(action: (Cat) -> Number) {
    println(action.invoke(Cat()))
}

fun tryEnumerate() {
    enumerateCats(Animal::getIndex)
}

/*fun feedAll(animal: List<Animal>) {
    animal.forEach {
        it.animalFun()
    }
}*/

fun feedAll(animals: Herd<Animal>) {
    animals.forEach {
        it.animalFun()
    }
}

/*fun feedEachCat(cats: List<Cat>) {
    cats.forEach {
        it.catFun()
        feedAll(cats)
    }
}*/

fun feedEachCat(cats: Herd<Cat>) {
    cats.forEach {
        it.catFun()
        feedAll(cats)
    }
}

fun <T : Animal> List<T>.feed() {
    forEach {
        it.animalFun()
    }

    forEach(fun(it: T) {
        it.animalFun()
    })
}

inline fun <reified T : Animal> isA(value: Animal) = value is T

/*fun List<Cat>.feedCat() {
    feedAll(this)
}*/

interface Food {
    fun giveFood(): Food
    fun food() {
        println("Food")
    }
}

class Rice : Food {
    override fun giveFood(): Food {
        return Rice()
    }

    fun rice() {
        println("Rice")
    }
}

class Bean : Food {
    override fun giveFood(): Food {
        return Bean()
    }

    fun bean() {
        println("Bean")
    }
}