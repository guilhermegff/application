package com.project.application.theory.kotlininaction

import android.content.Context
import android.util.AttributeSet
import android.view.View

//Class to practice with code from the book "Kotlin In Action"
class BookClassConstructors

/*
* In some cases there is a need to declare secondary constructors. The example here shows the need for the
* extra constructors when implementing a class from a framework that provides many constructors, each with
* different class initialization
* */

//No () on class declaration indicates there is no primary constructor for it
class MyButton : View {
    //Delegates to superclass constructor by using the super reserved word.
    constructor(context: Context): super(context) {
        //class initialization
    }
    //Delegates to superclass constructor by using the super reserved word.
    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        //class initialization
    }
}

/*
* It is also possible to have one of the class constructors to
* delegate to another constructor from the same class
* */
private val attr: AttributeSet? = null

abstract class MyButton2 : View {
    //Delegates to same class constructor by using the this reserved word.
    constructor(context: Context) : this(context, attr!!) {
        //class initialization
    }
    //Delegates to superclass constructor by using the super reserved word.
    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        //class initialization
    }
}
