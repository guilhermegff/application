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
* On a Infix Call the name of the method is inserted right after the name of the target object and the parameter, with no
* extra separators
* 1.to("one")
* 1 to "one"
* Both calls are equivalent.
* Infix Call can be used with usual methods as well with extension functions that have one required parameter.
* To allow a function to be called like this it is necessary to mark it with the "Infix" modifier.
* infix fun Any.to(other: Any) = Pair(this, other)
* We can initialize two variables directly with the content of a pair.
* val(number, name) = 1 to "one"
* This feature is called "Destructuring Declaration".
*
* Kotlin Interfaces can contain Property Declarations, Abstract Methods as well as non abstract methods implementations.
* Methods on interfaces require only a definition of a body to be default with no need for special reserved word.
*
* Nested classes are not internal as a standard: they do not have an implicit reference to its external class.
*
* Kotlin classes, methods and properties are final. The word "open" makes them open to being overriden.
* Overriden functions and properties are still open by default, they can be made closed to changes with the word "final".
*
* Kotlin nested classes do not have a reference to the outer class by default. To have the reference you need to
* use the "inner" word.
*
*Kotlin interfaces can contain properties with getters and setters as long as it does not reference a backing field.
*
* On classes, backing fields are accessible by using the reserved word "Field". It must be used inside the method block body.
*
* The kotlin compiler will generate the backing field when it is explicitly referenced or if the default access method is used.
* If custom implementation of access methods do not reference "Field" then the backing field won't be present.
*
* The default visibility for access methods is the same as the property. It can be changed by placing the modifier before
* the word "get" or "set".
*
* Equality can be Structural (content) or Referential (memory point).
* In Kotlin the "==" operator will check for referential equality as default. To check for structural equality then it is
* necessary to override "equals()".
* The operator "===" will always check for referential equality.
* Hashcode method should always be defined together with equals method
*
* The Kotlin compiler can generate the overriden "equals", "hashcode" and "toString" automatically if modifier "data" is used:
* data class
* The implementation for equals and hashcode will take into consideration all properties declared on the primary constructor.
* Equals will verify if each property has the same value for both objects.
* Properties that are not defined in the primary constructor are taken into consideration for the "equals" and "hashcode" methods.
* The "data" modifier also makes the Kotlin compiler generate a "copy" method that can be used to return a new instance but with
* the possibility of changing any of the properties values.
*
* Kotlin has first class support for delegation as a language feature.
* Whenever an interface is being implemented you can say that its implementation is being delegated to another object with the use of
* the word "by".
* If any method should be overriden then it can be while all the others continue to be delegated and with the unchanged methods
* automatically generated by the Kotlin compiler.
*
* A Lambda can be used as an alternative to anonymous objects with a single method.
* If the Lambda delegates to a function or a property then it can be replaced by a member reference Class::member.
* The function must be a high level function and not a function that is member of a class.
*
* A Lambda can use variables from its containing function, those external variables that are acceseed by the Lambda are called
* captured variables.
*
* A reference to the constructor can store or postpone the creation of an instance ::Class
*
* Extension functions can also be referenced with ::
*
* Interfaces with a single abstract method SAM are called functional interfaces. Java methods that hava a functional interface
* as a parameter can be called in Kotlin by passing Lambdas.
* The same effect can be reached by using an anonymous object, the difference being that if a lambda is used and it has no reference to external
* variables then the same instance of the anonymous class will be used.
* */