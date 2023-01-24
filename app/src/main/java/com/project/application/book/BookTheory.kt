package com.project.application.book

class BookTheory {
}

/*
* Initial Concepts - Functions, Variables and Classes
*
* Smart Cast is a type verification and a cast on a single operation
*
* Kotlin has lots of wrappers around standard Java libraries functions
*
* In Kotlin, "if" is an expression with a return value. In Java, all control structures are instructions.
* An instruction is always a high level element inside it's containing block and does not have a value
*
* For, Do and Do While control structures are not expressions even in Kotlin.
*
* If you write a Function with a { } body then this function has a "Block Body".
* If the Function returns an expression directly then it is called "Expression Body"
*
* The Kotlin compiler can analyze an expression and use it's type as the return type when it is not explicitly specified,
* this is known as "Type Inference"
*
* Non specified return types can only be used on Functions with "Expression Body".
* Functions with "Block Body" must always specify the return type and use the return instruction explicitly.
*
* Types can be omitted on val initialization expressions, the compiler will use the "Type Inference" to know that type the val is.
* If the val is not being initialized then the Type must be explicitly specified on it's declaration.
*
* Variables can be declared as val (Immutable) or var (Mutable).
* Vals cannot receive a new value after being initialized, they are like a Final variable in Java.
* Vars can receive a new value after being initialized.
* The Kotlin compiler infers the variable type only after first initialization.
*
* String template: Use $ to reference local variables on string literals.
* It is also possible to use expressions: "Hello ${list[0]}"
*
* Classes that contain only data and no code are often known as "Value Objects"
*
* Kotlin's default access modifier is "Final" and "Public"
*
* In Java, the combination of a Field and it's access methods is usually called "Property"
* In Kotlin, "Properties" is a first class resource and substitutes fields and access methods.
* Val and Var are properties, val is ready only (Generates only a field and a getter)
* and var is read-write (Generates a field, getter and setter). Access methods can be customized.
*
*  Look for: What is a field, what is an accessor method?
*
* Just like "if", "when" is an expression that returns a value.
* The argument for a "when" expression can by any type of object.
*
* Keyword operator "in" translates to: c in 'a'..'z' = a <= c && c <= z
*
* Keyword "Try" is an expression like "if" and "when", can return value.
*
* The "@JvmOverloads" annotation makes the compiler generate overloads for the annotated method.
* Each overload omits one of the function parameter and uses the default value.
*
* High level functions are accessible through a class that is named after the containing file eg: "Ext.kt -> ExtKt class"
* All functions contained on that file are accessible as static methods through this class on the JVM.
*
* To customize the name of the generated class, the "@file:JvmName("CustomName")" annotation can be placed right before the package name.
*
* Properties can also be placed on the higher level of a file.
* They are exposed to Java as access methods (getter/setter)
* To expose a high level property as a public static final field to Java, use the "const" modifier.
* The "const" modifier can be used only on primitive types and String.
*
* An extension function is a function that can be called as if it was a member of a class but is defined outside of said class.
* The name of the class is the "Receptor Type" and the value on which the function is called is the "Receptor object""
*
* Extension functions do not have access to private or protected class members.
*
* Internally, an extension function is a static method that accepts the receptor object as it's first argument.
* It is also possible to have "Property Extensions" where the getter must always be defined since there is no backing field.
*
* Infix call
* mapOf(1 to "one")
* The "to" word is not a built-in feature from Kotlin but a call to a special kind of method called "Infix Call".
* On a Infix Call the name o the method is inserted right after the name of the target object and the parameter, with no
* extra separators
* 1.to("one")
* 1 to "one"
* Both calls are equivalent.
* Infix Call can be used with usual method as well with extension functions that have one required parameter.
* To allow a function to be called like this it is necessary to mark it with the "Infix" modifier.
* infix fun Any.to(other: Any) = Pair(this, other)
* We can initialize two variables directly with the content of a pair.
* val(number, name) = 1 to "one"
* This feature is called "Destructuring Declaration".
*
* */