package com.project.application.book

class BookTheory {

}

//region Chapter 2
/*
* In Kotlin, "if" is an expression with a return value. In Java, all control structures are instructions.
* An instruction is always a high level element inside it's containing block and does not have a value
*
* Just like "if", "when" is an expression that returns a value.
* The argument for a "when" expression can by any type of object.
* If no argument is specified then the branch condition will be any boolean expression.
* On "when", only the corresponding branch will be executed. Different values can be combined on the same branch with ,.
*
* Keyword "Try" is an expression like "if" and "when", can return value.
*
* For, Do and Do While control structures are not expressions even in Kotlin.
*/
val expressionThatHasValue = if (true) 0 else 1

val sameThingWithWhen = when (true) {
    true -> 1
    false -> 0
}

val sameThingWithTry = try {
    0
} catch (e: java.lang.Exception) {
    1
}

/*
* Variables can be declared as val (Immutable) or var (Mutable).
* Vals cannot receive a new value after being initialized, they are like a Final variable in Java.
* Vars can receive a new value after being initialized.
* The Kotlin compiler infers the variable type only after first initialization.
* The Kotlin compiler can analyze an expression and use it's type as the return type when it is not explicitly specified,
* this is known as "Type Inference"
*
* Types can be omitted on val initialization expressions, the compiler will use the "Type Inference" to know that type the val is.
* If the val is not being initialized then the Type must be explicitly specified on it's declaration.
*/
var b = 1

val c = 0

fun withTypeSpecification() {
    val d: Int
}

fun cannotInferAgain() {
    //b = 0F Type Inference happens only once, on initialization
    //c = 1  Val cannot be reassigned
}

fun returnInt() = 1 //Return Type Inference

/*
* If you write a Function with a { } body then this function has a "Block Body".
* If the Function returns an expression directly then it is called "Expression Body"
*
* Non specified return types can only be used on Functions with "Expression Body".
* Functions with "Block Body" must always specify the return type and use the return instruction explicitly.
*/
fun withExpressionBody() = if (true) 0 else 1

fun withBlockBody(): Int {
    return if (true) 0 else 1
}

/*
* String template: Use $ to reference local variables on string literals.
* It is also possible to use expressions: "Hello ${list[0]}".
*/
val listOfStrings = listOf("Hello", "Hi")

const val string = "World"

fun printTheList() {
    println("${listOfStrings[0]} $string!")
}

/*
* Classes that contain only data and no code are often known as "Value Objects".
*/
class ValueObject(val value1: Int, val value2: String)

/*
* Smart Cast is a type verification and a cast on a single operation.
* The word "is" checks if a variable is of a type.
* The word "as" makes an explicit cast to a type.
*/
fun withSmartCast(number: Number) {
    if (number is Int) {
        number.plus(1)
    }
}

/*
* Kotlin's default access modifier is "Final" and "Public"
*
* In Java, the combination of a Field and it's access methods is usually called "Property"
* In Kotlin, "Properties" is a first class resource and substitutes fields and access methods.
* Val and Var are properties, val is ready only (Generates only a field and a getter)
* and var is read-write (Generates a field, getter and setter). Access methods can be customized.
*
* Access methods can be customized
* */
class Geometry(
    private val height: Int,
    private val length: Int
) {
    val size: Int
        get() = height * length
    var color: String = "Transparent"
        set(value) {
            field = "$value + Color"
        }
}

/*
* Kotlin makes no distinction between importing classes or functions and allows you to import any declaration by using
* the reserved word "import". Higher level function can aslo be imported by its name.
*
* If you use the "*" after after the package name then all declarations defined on that package are imported. It will also
* make all higher level functions and variables on that package visible.
*
* Enum classes can have declarations of properties and methods. They use the same constructor and property declaration syntax as
* regular classes.
*/
enum class IntEnum(int: Int) {
    ONE(1),
    TWO(2),
    THREE(3); //Must use ; to separate the constants list from methods definitions.
    fun enumMethod() {

    }
}

/*
* 
*
*
* Keyword operator "in" translates to: c in 'a'..'z' = a <= c && c <= z
*
*
*
*/
//endregion

//region Chapter 3
/*
The "@JvmOverloads" annotation makes the compiler generate overloads for the annotated method.
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
* */
//endregion

//region Chapter 4
/*
 Kotlin Interfaces can contain Property Declarations, Abstract Methods as well as non abstract methods implementations.
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
* Kotlin interfaces can contain properties with getters and setters as long as it does not reference a backing field.
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
* */
//endregion

//region Chapter 5
/*
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
//endregion

//region Chapter 6
/*
* What is a type? "A type is a classification that determines the possible values of thies type and the operations that can be performed on value of
* this type.
* Safe call operator ?.
* Elvis operator ?: If left side is null then the right side expression is executed.
* Safe-cast operator as? It will try to cast one value to the specified type and returns null if the value does not have the appropriate type.
* After the safe cast the compiler will make a smart cast to the next operations with the value.
*
* Non null assertion !! converts a nullable argument to a non nullable argument. If the value ends up being null
* then a NullPointerException will be thrown.
* Let function transforms the objects on which it is called into a lambda parameter. If used with the safe call operator "?.let"
* then it will convert the nullable type to a non null type. The let call happens only if the value is not null after the safe call check.
*
* Late Init properties are marked with the "lateinit" modifier and it has to be a var so it value can be changed.
*
* By default all function type parameters are nullable. T if inferred as Any?, so T can store null even though it has no ? on it.
* To make the type parameter not null we need to specify a non null superior limit to it. This way all nullable values are reject as arguments.
* <T: Any>, null arguments are not accepted now. The limit is non null Any. This is the only exception to the rule of ? usage to denote nullable values.
*
* If Java code has values annotated with "@Nullable" then it will be seen as Tyoe? in Kotlin and "@NotNull" as a non null Type value in Kotlin.
* If no annotation is present in the Java side declaration the Kotlin will se those values as "Platform type". It means Kotlin has no information
* about the nullability of that value and it can be treated as both nullable or not null. The compiler will allow all operations on it.
* The Kotlin compiler represents the "Platform type" with "String!" the ! emphasizes that the information about it being nullable or not is unknown.
*
* Kotlin makes no difference between primitive types and wrappers.
* In most cases, for variables, properties, parameters and return types, Int type in Kotlin is compiled to the primitive type int from Java.
* If a primitive type is used as type argument for a generic class then it is compiled to the correspondent wrapper type from Java.
*
* Primitive types in Java, if used in Kotlin, become no null types and not Platform types because they cannot store null values just like in Java.
* This happens because null values can only be stored on Reference Types in Java and not in Primitive Types.
*
* Kotlin does not convert numbers automatically from one type to another. Conversions functions are present to help with these operations.
* The equals method checks the wrapper type and not only the stored value. Types must be explicitly converted so only values of the same type
* are compared.
*
* If a primitive type value is attributed to a type Any variable then an automatic boxing will occur because Any is a Reference Type.
* Kotlin functions that use Any are compiled to Object on Java bytecode.
*
* Unit has the same function as void in Java, it means the function doesn't return anything in special.
* Unit is different from Java void as it is a complete type and can be used as a Type Argument.
* It is not needed to add the expression "return Unit" because when the Unit type is the return type then the compiler adds it automatically.
* Kotlin has a special return type called Nothing, it indicates the function will never normally terminate.
* It is not possible to store a value in Nothing type.
*
* Kotlin separates its collection interfaces into mutable and immutable collections.
* MutableCollection extends Collection and adds methods that can modify the content of the collection.
*
* Read only collection are not necessarily immutable. It can be referenced somewhere as a mutable collection also.
* Read only collections are not always thread-safe.
* All Kotlin collections are instances of its corresponding Java collection interface.
* All of the Java collections interfaces have two representations in Kotlin: one mutable and one immutable.
* As Java makes no kind of similar distinction, if you pass a Collection or MutableCollection, both will be seen as
* Collection in Java and be subject to read-write access.
*
* Spread operator * is used to pass an array when a vararg parameter is expected.
* Array will always box the primitive types. If primitive types are wanted then specific arrays must be used: IntArray
* */
//endregion

//region Chapter 7
/*
* Kotlin allows us to add new functionality without modifying the original class with extension functions.
* Some functions have specific names that can be used as "conventions". For instance if a class defines a method called
* "plus", then, by convention, it will be possible to use the "+" operator on instances of this class.
* All functions that overload operations must use the reserved word "operator", it indicates that the implementation wants to use the convention
* and that the naming was not accidental.
* When the "+" is used, a call to "plus" will be called internally. a + b -> a.plus(b)
* The definition of an operator can be done on class members or extension functions.
* Kotlin has a limited number os operators that can be overloaded and each has its own name that should be used on the corresponding function.
*
* a * b -> times
* a / b -> div
* a % b -> mod
* a + b -> plus
* a - b -> minus
*
* Mathematical precedence of operators is maintained even when overloaded.
* The overload can be done multiple times just like on normal functions.
* Operators like += or -= and so on are called "Composite Attribution Operators"
* If "plus" and "plusAssign" operators are overload the compiler will inform an error.
* a += b -> a = a.plus(b) or a.plusAssign(b)? Compiler does not know.
* For collection, operators "+" and "-" always return a new collection while "+=" and "-=" modify the collection in place (if its immutable) or return
* a new collection if it is a mutable collection
* Not only binary operators can be overloaded, unary operators work the same way around.
* Functions that overload unary operators do not accept arguments.
* +a -> unaryPlus
* -a -> unaryMinus
* !a -> not
* ++a, a++ -> inc / ++a Increments and then execute - a++ Executes and then increment
* --a, a-- -> dec
*
* Comparison Operators can also be overloaded.
* In Kotlin, "==" is translated to a equals call.
* Differently from the other operators, "==" and "!=" can be used on nullable operands since they check for null equality internally.
* a == b -> a?.equals(b) ?: (b == null)
* The operator "===" called "Equality With Identity" verifies if two arguments are referencing the same object or if they have the same value when they
* are a Primitive Type.
* The "===" operator cannot be overloaded.
*
* If a base class has an "operator" fun and it is extended or overriden the "operator" word is not required again.
* Observe that "equals" cannot be implemented as an extension function because the implementation that is inherited from "Any" will always have precedence
* over the extension function.
*
* Kotlin can use the comparison operators "<, >, <=, >=" on Comparable Interfaces as a convention, different from Java that accepts the operators
* only for Primitive Types.
* The use of those operators are translated to "compareTo" calls
* a >= b -> a.compareTo(b) >= 0
*
* Operations with indexes on collection can use the "Index Operator" "a[]"
* The operator "in" can be used to check if a value is inside a collection or a interval and also to iterate over a collection.
*
* The "Index Operator" is translated to a "operator method get" and if it is used to set a value then the call is translated to
* "operator method set".
*
* To use the "Operator Index" on custom classes it is needed to have the overloaded "operator get" or "operator set" methods.
* x[a, b] -> x.get(a, b)
* x[a, b] = c -> x.set(a, b, c)
*
* Operator "in"
* a in c -> c.contains(a)
* for(x in list) -> list.iterator()
*
* Operator ".."
* start..end -> start.rangeTo(end)
*
* Destructuring Declarations allows the un-packaging of a single composite value to initialize multiple separated variables.
* val p = Point(10, 20)
* val(x, y) = p -> x = 10, y = 20
*
* val(x, y) = p -> val x = p.component1() val y = p.component2()
* For data classes the compiler will add the methods to up to 5 properties contained on the primary constructor.
* If the class is not a data class it is possible to manually add the methods.
* class Point(val x: Int, val y: Int) {
* operator fun component1() = x
* operator fun component2() = y
* }
*
* Map entries have extension functions component1 and component2 that return the key and its value respectively.
* for(entry in map.entries) {
* val key = entry.component1()
* val value = entry.component2()
* }
*
* Delegated Properties is a resource that also depends on conventions. This resource allows properties that are more complex than just having a backing field
* to be easily implemented, without duplicating the logic on each access method.
*
* The base of this resource is "Delegation", a design pattern on which an object, instead of executing some task, delegates it to an auxiliary object called
* delegate.
* class Foo {
*  var p: Type by Delegate()
* }
* The compiler creates a hidden property that is initialized with the instance of the delegate object to which the initial property p delegates to.
*
* By convention, the delegate class must have "getValue" and "setValue" methods. These methods can be members or extensions.
* When we call Foo, the methods that are called internally are the ones from the auxiliary property of type Delegate.
*
* Delegated properties can replace the "Backing Property" strategy where one property will store the value and the other one will provide read access to it.
* By lazy
* class Person(val name: String) {
*  val emails by lazy { loadEmails(this) }
*
* The "function" returns an object that has a method called "getValue"so it can be used with the "by" convention to create a delegated property.
*
* The argument for the lazy function is a lambda that is called to initialize the value.
* The expression to the right of the "by" convention does not need to be the creation of a new instance. It can also be a function call, another property or any
* other expression as long as the value of this expression is an object on which the compiler may call getValue or setValue with the correct parameters.
*
* class Foo {
*  private val delegate = Delegate()
* var c: Type
*  get() = delegate.getValue(c, property)
*  set(value: Type) = delegate.setValue(c, property, value)
*
* This way, on every access method to the property the compiler generates calls to the corresponding getValue and setValue methods.
* val x = c.prop -> val x = delegate.getValue(c, property)
* c.prop = x -> delegate.setValue(c, property, x)
* */
//endregion

//region Chapter 8
/*
* A "Higher Order Function" is a function that accepts other function as an argument or that returns a function.
* Any function that can receive a function or a function reference as an argument or that returns a function or both things, is a Higher Order Function.
*
* The "Function Type" = () -> Unit or (int: Int) -> Boolean, etc.
* "Function Type" needs to always explicitly specify the return type.
* The return can be nullable or the "Function Type" variable can also be nullable.
* () -> Int? or (() -> Int)?
*
* The "Function Type" are declared as a regular interface internally. A variable of a "Function Type" is an implementation of an interface FunctionN.
* Each interface defines one single invoke method e its call makes the function execute. The variable of a "Function Type" is an instance of a class that
* implements the FunctionN interface with the invoke method having the lambda body.
*
* Lambdas are usually compiled to anonymous classes, so each time a lambda expression is used an extra class may be created and if the lambda captures any
* variables then a new object will be instantiated on each call.
*
* The "inline" modifier eliminates that overhead and makes no extra function call, instead replacing all call to the function with the code that it actually
* implements.
* The function must accept a Lambda as an argument.
* inline fun inlinedFun() {}
*
* Non Local Returns
* If the reserved word "return" is used inside a lambda then the return will be from the function that call the lambda and not from the lambda itself.
* The return from the most external functions is only possible if the function that accepts the lambda is marked an inline function.
*
* Local returns can be used with the help of labels.
* it.foreach label@ {
*  if() return @label
*
* The same scope rules apply to "this" expressions.
*
* Anonymous functions have local returns by default.
*
* The "return" word returns from the function that is closest and was declared with "fun" word. Lambdas do not use the "fun" word so they return from external
* function.
* Anonymous function are just a different syntax for lambdas.
* }
* */
//endregion

//region Chapter 9
/*
* fun <T> List<T>.slice(indices: IntRange) : List<T>
* "Type Parameter" declaration: fun <T>, the "Type Parameter"is used on receptor and return types.
*
* "Reified Parameter Types" makes possible to reference the specific types used as type arguments on inline function call on run time.
* This is not possible on regular classes or functions because the type arguments are erased on runtime.
*
* "On site variance"
* "On use variance"
*
* Generics allows to define type that have type parameters. When the instance of this type is created, the type parameters are replaced
* by specific types that are called "Type Arguments".
* Map<K, V> Map<String, Person>

* "Types Arguments" can be inferred by the Kotlin Compiler. The compiler will always require that "Type Arguments" are always explicitly
* defined or inferred.
*
* "Type Parameters" can be declared on methods from classes and interface, higher order functions and extension functions.
*
* "Upper Bound Constraint" <T: Number> the type must be of the specified type or its subtypes. It can have more than one constraint.
* An unconstrained type has Any? as the upper limit.
*
* Generic on the JVM are usually implemented with "type erasure" which means that the type arguments of an instance of a generic class are not
* preserved during runtime.
*
* In Kotlin the word "inline" can be used to indicate the type erasure should not happen, they should be "reified"
* Kotlin has a special construct that allows the specific type arguments to be used on the body of a function, but this is possible only on inline fun.
* With a reified fun, the arguments types can be referenced on runtime.
* "Reified" declares that the modified type parameter won't be erased during runtime.
* Functions can be made inline to improve the performance when dealing with lambdas or to keep parameter types reified during runtime.
*
* Variance
* The variance concept describes how types that have the same base type and different type arguments are related.
* The type of a variable specifies the possible values this variable can have. When using a non generic class, the name of the class can be used
* directly as a type var x: String or x: String? all Kotlin classes can be used to create at least two types.
* All generic classes can generate a potential infinite number of types.
* A type B will be a subtype to type A if type B value can always be used when type A value is required.
* The term "supertype" is the opposite of "subtype", if type A is a subtype of type B, then B is a supertype to A. The compiler will always check
* when a value is attributed to a variable or when an argument is passed to a function.
*
* "Invariance"
* MutableList is invariant on type parameter if, for any two distinct A and B types, MutableList<A> is not a subtype or supertype to MutableList<B>.
* If A is a subtype to B then List<A> will be a subtype to List<B>, classes and interface that work like this are called covariants.
*
* The subtyping is preserved.
* To declare a class as covariant on any given type parameter just add the reserved word "out" before the name of the type parameter
* interface Producer<out T> {
*   fun produce(): T
* }
* Covariant parameter makes it possible to pass values from this class as function arguments and return values when type arguments don't exactly
* coincide with those on the function definition.
* This modification requires that the covariant type can be used only on out positions, meaning that it can be returned but not consumed.
*
* Contravariance
* interface Comparator<in T> {
*   fun compare(e1: T, e2: T): Int {}
* }
*
* The method only consumes T so it can be marked with "in" to enforce this.
* A class that is contravariant on the type parameter is a generic class to which the following affirmation is true:
* Consumer<A> will be a subtype to Consumer<B> if B is a subtype of A.
* The use of the word "in" indicates that values of the corresponding type will be passed to the methods of this class e be consumed by them.
* It means that the subtyping is inverted and T can be used only on in positions.
*
* The specification of variance modifiers on class declaration means that it is applied wherever the class is ued. This is called
* Declaration Site Variance.
*
* When the specification happens when the parameters are being used then it is called
* Use Site Variance.
*
* Type Projection is when the variance modifier is specified on a local variable, return type etc.
* Type Projection can limit the usable methods on a type.
*
* Star Projection <*> means that there is no information about the generic argument. It is different from <Any> because Any means it can be of any
* subtype of Any while the projection means it is of a specific type but it is unknown.
* It can be used when informations about type is not important.
* */
//endregion
