package com.project.application

import org.junit.Test
import java.beans.PropertyChangeListener
import java.math.BigDecimal

class BookClassOperator : BookClassOperatorFixture {

    @Test
    fun overloadingBinaryPlusOperation() {
        val p1 = BookClassOperatorFixture.Point(10, 20)
        val p2 = BookClassOperatorFixture.Point(30, 40)
        val result = p1 + p2
        println(result)
        assert(result == BookClassOperatorFixture.Point(40, 60))
    }

    @Test
    fun overloadingBinaryTimesOperation() {
        val p1 = BookClassOperatorFixture.Point(10, 20)
        val result = p1 * 1.5
        println(result)
        assert(result == BookClassOperatorFixture.Point(15, 30))
    }

    @Test
    fun overloadingBinaryStringTimesOperation() {
        val result = 'a'.times(3)
        println(result)
        assert(result == "aaa")
    }

    @Test
    fun operatorMultipleAttributions() {
        var point = BookClassOperatorFixture.Point(1, 2)
        point += BookClassOperatorFixture.Point(3, 4)
        println(point)
        assert(point == BookClassOperatorFixture.Point(4, 6))
    }

    @Test
    fun operatorMultipleAttributionsWithCollection() {
        val numbers = ArrayList<Int>()
        numbers += 42
        println(numbers[0])
        assert(numbers[0] == 42)
    }

    @Test
    fun operatorUnaryMinus() {
        val point = BookClassOperatorFixture.Point(10, 20)
        println(point.unaryMinus())
        assert(point.unaryMinus() == BookClassOperatorFixture.Point(-10, -20))
    }

    @Test
    fun operatorInc() {
        var bd = BigDecimal.ZERO
        println(bd++)
        assert(bd == BigDecimal.ONE)

        println(++bd)
        assert(bd == BigDecimal(2))
    }

    @Test
    fun operatorCompareTo() {
        val p1 = BookClassOperatorFixture.PersonC("Alice", "Smith")
        val p2 = BookClassOperatorFixture.PersonC("Bob", "Johnson")
        println(p1 < p2)
        assert(!(p1 < p2))

    }

    @Test
    fun operatorGet() {
        val p = BookClassOperatorFixture.Point(10, 20)
        println(p[1])
        assert(p[1] == 20)
    }

    @Test
    fun operatorSet() {
        val p = BookClassOperatorFixture.MutablePoint(10, 20)
        println(p)
        p[1] = 42
        println(p)
        assert(p == BookClassOperatorFixture.MutablePoint(10, 42))
    }

    @Test
    fun operatorIn() {
        val rect =
            BookClassOperatorFixture.Rectangle(
                BookClassOperatorFixture.Point(10, 20),
                BookClassOperatorFixture.Point(50, 50)
            )
        val a = BookClassOperatorFixture.Point(20, 30) in rect
        val b = BookClassOperatorFixture.Point(5, 5) in rect
        println(a)
        println(b)
        assert(a)
        assert(!b)
    }

    @Test
    fun destructuringDeclaration() {
        val p = BookClassOperatorFixture.Point(10, 20)
        val (x, y) = p
        println(x)
        println(y)
        assert(x == 10 && y == 20)
        val pM = BookClassOperatorFixture.PointManual(10, 20)
        val (c, d) = pM
        println(c)
        println(d)
        assert(c == 10 && d == 20)
        val (n, m) = "a.b.c".split('.')
        println(n)
        println(m)
        assert(n == "a" && m == "b")
    }

    @Test
    fun destructuringDeclarationMap() {
        val map = mapOf("Kotlin" to "Android", "Java" to "Android")
        printEntries(map)
        assert(map["Kotlin"] == "Android")
        assert(map["Java"] == "Android")
    }

    @Test
    fun propertyDelegate() {
        val component = BookClassOperatorFixture.Component("big", 2)
        component.addPropertyChangeListener(
            PropertyChangeListener { event ->
                println(
                    "Property ${event.propertyName} changed " +
                            "from ${event.oldValue} to ${event.newValue}"
                )
            }
        )
        component.weight = 3
    }
}