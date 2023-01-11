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
                PersonC::lastName, PersonC::firstName
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
        private val observer = {
            prop: KProperty<*>, oldValue: Int, newValue: Int ->
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
