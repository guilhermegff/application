package com.project.application.theory.solid

import java.math.BigDecimal

class SolidTheory

//region - Single Responsibility Principle
/*
*
* Classes should have only one reason to change. Stakeholders, and users, are reasons to change, they are the parties who
* can ask for something to change. If a class is responsible for fulfilling requirements from many stakeholders, or actors, then it has
* many responsibilities and changes to one of them can implicitly affect others.
* With this in mind, classes should have few responsibilities, decoupling unrelated responsibilities into different classes and
* encapsulating into one class only a single or cohesive responsibilities.
*
* An example can be found in "Clean Architecture" by Robert Martin:
* In it we have a system that calculates the salary, creates the hours report and saves data to the database.
* All this functionality is packed in one single class but different actors asked for it.
* The CFO uses the method that calculates the salary, the CTO decides how data is persisted and HR also uses the hours report. The methods
* calculatePay and reportHours share a dependency on the private regularHours method.
* In this example the CFO may ask for a change to the functionality so that the non-overtime hour is calculated in a different manner
* inside the regularHours private method. If the change is made it will fulfill the new requirement but will hamper the work of the HR sector
* that does not need the new way to calculate non-overtime hours, so there is a conflict of responsibilities in this class. It has more than
* one responsibility, more than one actor can ask for changes and be affected by them, it has more than one reason to change.
* The solution is to extract the multiple responsibilities into different classes so that each have only one reason to change. This
* way the changes that are required by the CFO won't bring unwanted changes to the HR team.
*
* According to Robert Martin, in "Clean Architecture", the SRP is about functions and classes but manifests itself on a different form
* at two more levels. It becomes the Common Closure Principle at the level of Components and the Axis of Change at the level of
* Architectural Boundaries.
*
* */

class Employee(string: String) {
    val data = string

    fun calculatePay() {
        //Used by the CFO
        regularHours(data)
    }

    private fun regularHours(data: String) {
        println(data)
    }

    fun reportHours() {
        //Used by the HR
        regularHours(data)
    }

    fun save() {
        //Used by the CTO
    }
}

/* Solution
*
* In this solution we separate the data from the functions. Three different classes
* share access to the data class. Each class holds only the code necessary for its particular function
* The three classes do not know about each other.
*
* */

data class EmployeeData(
    val data: String = "data",
    val salary: BigDecimal = BigDecimal.TEN,
    val tyoe: EmployeeType = EmployeeType.FULL_TIME,
)

enum class EmployeeType {
    FULL_TIME,
    CONTRACTOR
}

class PayCalculator(private val employeeData: EmployeeData) {
    fun calculatePay() {
        with(employeeData) {

        }
    }
}

class HourReporter(private val employeeData: EmployeeData) {
    fun reportHours() {
        with(employeeData) {

        }
    }
}

class EmployeeSaver(private val employeeData: EmployeeData) {
    fun saveEmployee() {
        with(employeeData) {

        }
    }
}

/*
* Other possible solution is to have the data inside the rules class and use this class as a facade
* to the functions of cohesive classes.
*
* */

class EmployeeFacade(employeeData: EmployeeData) {
    private val hourReporter = HourReporter(employeeData)
    private val employeeSaver = EmployeeSaver(employeeData)

    fun calculatePay() {

    }

    fun reportHours() = hourReporter.reportHours()
    fun save() = employeeSaver.saveEmployee()
}
//endregion

//region - Open Closed Principle
/*
*
* The term Open Closed Principle was coined by Bertrand Meyer in 1988 and it states that:
* A software artifact should be open for extension but closed for modification.
* The goal is to make the system easy to extend without incurring a high impact of change.
* This can be achieved by applying the Single Responsibility Principle and
* the Dependency Inversion Principle. By applying the SRP and DIP, we can protect components from changes
* while keeping them open to be extensible. In other words, we should depend on stable abstractions and modify
* system's behavior by providing different realizations for those abstractions.
*
* From the book "Agile Software Development by Robert Martin:
* How is it possible that the behavior of a module can be modified without changing its source code?
* Without changing the module, how can we change what a module does?
* The answer is abstraction. It is possible to create abstractions that are fixed and yet represent
* an unbounded group of possible behaviors. It is possible for a module to manipulate an abstraction.
* Such a module can be closed for modification, since it depends on an abstraction that is fixed.
* Yet the behavior of that module can be extended by creating new derivatives of the abstraction.
*
* By Vasiliy's definitions:
* A modern definition of OCP could be:
* Depend on stable abstractions and modify system's behavior by providing different realizations.
*
* OCP is the principle of polymorphism.
*
* Considerations:
* The fact that something can change doesn't imply that it will change, or that it will change
* according to your predictions.
*
* OCP Application Framework:
* 1- Is the anticipated change related to intrinsic instability of business requirements?
* 2- What kind of changes usually happen on projects like this one?
* 3- If the potential change doesn't correspond to 1 or 2, don't immediately apply OCP.
* 4- When requirements change, identify opportunities for extraction of meaningful abstractions
*    and then refactor accordingly.
* 5- The risk of over-engineering is ever present
* 6- Proper utilization of OCP allows you to provide additional business value quickly and safely
*
* */

/*
* This class is not protected from changes on how the tax is calculated or changes that modify the
* set of employee types.
* We know that the set of employee types can change.
* */
class SalaryCalculator() {
    fun calculateSalary(employeeData: EmployeeData) {
        val taxDeduction: BigDecimal = calculateTax(employeeData)
    }

    private fun calculateTax(employeeData: EmployeeData): BigDecimal {
        return when (employeeData.tyoe) {
            EmployeeType.FULL_TIME -> BigDecimal.TEN * 0.2.toBigDecimal()
            EmployeeType.CONTRACTOR -> BigDecimal.TEN * 0.1.toBigDecimal()
        }
    }
}

/*
* We apply the SRP towards an abstraction that encapsulates the desired behavior
* */
interface TaxCalculator {
    fun calculateTax(employeeData: EmployeeData): BigDecimal
}

/*
* Then we implement different realizations for the abstraction by utilizing the Strategy Pattern
* */
class TaxCalculatorFullTime() : TaxCalculator {
    override fun calculateTax(employeeData: EmployeeData): BigDecimal {
        return BigDecimal.TEN * 0.2.toBigDecimal()
    }
}

class TaxCalculatorContractor() : TaxCalculator {
    override fun calculateTax(employeeData: EmployeeData): BigDecimal {
        return BigDecimal.TEN * 0.1.toBigDecimal()
    }
}

/*
* We delegate the decision to which realization should be used to a Factory Pattern
* */
class TaxCalculatorFactory() {
    fun newTaxCalculator(employeeData: EmployeeData): TaxCalculator {
        return when (employeeData.tyoe) {
            EmployeeType.FULL_TIME -> TaxCalculatorFullTime()
            EmployeeType.CONTRACTOR -> TaxCalculatorContractor()
        }
    }
}

/*
* Now the SalaryCalculator class can be refactored and conform to the OCP
* */
class SalaryCalculatorRefactored() {
    private val taxCalculatorFactory = TaxCalculatorFactory()

    fun calculateSalary(employeeData: EmployeeData): BigDecimal {
        val taxCalculator = taxCalculatorFactory.newTaxCalculator(employeeData)
        val taxDeduction = taxCalculator.calculateTax(employeeData)
        return employeeData.salary - taxDeduction
    }
}

/*
* With this refactored implementation and the use of OCP, we protect the SalaryCalculator class
* from changes. The calculation is specialized on each realization of the abstraction.
* Changes are to occur on the TaxCalculator factory when we add or remove new employee types.
* Changes can also occur on the implementations that calculate the tax.
* */
//endregion

//region - Liskov Substitution Principle
/*
*
* The Liskov Substitution Principle is named after Barbara Liskov, the author of scientific papers
* on data abstractions and hierarchy.
* A class that derives from other becomes a subclass but not necessarily a subtype.
* Liskov's definition of a subtype:
* "What is wanted here is something like the following substitution property:
* if for each object o1 of type S there is an object o2 of type T such that for all programs P
* defined in terms of T, the behavior of P is unchanged when o1 is substituted for o2 then S is a
* subtype of T."
* To achieve this definition, some guiding rules have been defined:
* Methods Signature Rules
* - Contravariance of Arguments
*  If a subclass implements a method from its superclass, then the number of arguments should be the same
*  Argument types on methods overriden in the subclass must be equal to those on the methods from the superclass,
*  this is enforced by Java and Kotlin compiler.
*/

/*
* The objects of the subtype ought to behave the same as those of the supertype as far as anyone or any
* program using supertype objects can tell.
*
* Calls of methods made in the program that assume the object belongs to a supertype must have the same
* behavior when the object actually belongs to a subtype.
*
* It is possible to have a mutable subtype of an immutable supertype, provided the mutations are invisible
* for users of the supertype.
* Mutations of a subtype that would be visible through the methods of an immutable supertype are ruled out.
* */
interface InterfaceX {
    fun fromX() {
        println(x)
    }
    val x : String get() = "X"
}

interface InterfaceY : InterfaceX {
    fun fromY() {
        println("Y")
    }
}

open class  ClassX() {
    open fun method(string: String, int: Int, interfaceY: InterfaceY) {
        interfaceY.fromX()
        interfaceY.fromY()
    }
    open fun method2(string: String, int: Int, interfaceX: InterfaceX): InterfaceX {
        interfaceX.fromX()
        return object : InterfaceX {}
    }
}

class ClassY : ClassX() {
    override fun method(string: String, int: Int, interfaceY: InterfaceY) {
        super.method(string, int, interfaceY)
    }

    override fun method2(string: String, int: Int, interfaceX: InterfaceX): InterfaceX {
        super.method2(string, int, interfaceX)
        return object : InterfaceX {}
    }
}

fun main() {
    tryIt1()
}

fun tryIt1() {
    val classY = ClassY()
    val impl = object : InterfaceY {}

    classY.method("string", 1, impl)
    classY.method2("string", 2, impl)
}

/*
*
* Type Hierarchies
* Extension Subtypes and Constrained Subtypes, both relationships can appear in the same type family
* Extension Subtypes add methods and or state to the object
* Constrained Subtypes restrict the nondeterministic definitions of the supertype by reducing
* variation. Variability should show up on the supertype invariant and constraint and specification
* of each method
* */

/*
* - Covariance of Result
*  Either both superclass' and subclass' methods return result, or neither does
*  If there is a result, then the type of the result in the subclass is a subtype of the type of the result
*  in the superclass
* - Exception Rule
*  Exceptions thrown by a method in the subclass should be contained in the set of exceptions thrown by the
*  respective method in the superclass
* Methods Pre and Post conditions Rules
* - Pre-Condition
*  An assertion about the state of the system before the method is called
*  Pre-conditions required by the methods of a subclass must not be stronger than those required
*  by methods of superclass (A subclass should be able to operate in all states that a superclass
*  can operate in)
* - Post-Condition
*  An assertion about the state of the system after method execution completes
*  Post-conditions guaranteed by methods of a subclass must not be weaker than post-conditions
*  guaranteed by methods of a superclass
* Class Property Rules
* - Invariant Rule
*  Invariant = A property of an object which remains unchanged after operations or transformations
*  are applied to the object
*  Invariants guaranteed by a subclass must include all invariants guaranteed by a superclass
* - Constraint Rule
*  Constraint = A condition that solutions must satisfy
*  Constraints enforced by a subclass must include all constraints enforced by a superclass
*  (Constraint is an assertion about how class property evolves over time)
*
*
*/
//endregion

//region - Interface Segregation Principle
/*
*
* Interface Segregation Principle has the general goal of avoiding having dependencies on more than
* what is needed. In statically typed languages it is also a way to minimize the need for clients
* to recompile after changes.
* One high-level benefit of ISP is that a clearer communication of the object's api is presented to
* the client.
*
* */
class UserOf1SeesAll(val usesAll: UsesAll)
class UserOf2SeesAll(val usesAll: UsesAll)
class UserOf3SeesAll(val usesAll: UsesAll)

class UserOf1Sees1(val uses1: Uses1)
class UserOf2Sees2(val uses2: Uses2)
class UserOf3Sees3(val uses3: Uses3)

class UsesAll() : Uses1, Uses2, Uses3 {
    override fun op1() {}
    override fun op2() {}
    override fun op3() {}
}

interface Uses1 {
    fun op1()
}

interface Uses2 {
    fun op2()
}

interface Uses3 {
    fun op3()
}

fun tryIsp() {
    val usesAll = UsesAll()
    val userOf1Sees1 = UserOf1Sees1(usesAll)
    userOf1Sees1.uses1.op1()
    val userOf1SeesAll = UserOf1SeesAll(usesAll)
    userOf1SeesAll.usesAll.op1()
    userOf1SeesAll.usesAll.op2()
    userOf1SeesAll.usesAll.op3()
}
//endregion

//region - Dependency Inversion Principle
/*
*
* The dependency inversion principle tells us that the most flexible systems are those in which source
* code dependencies refer only to abstractions, not to concretions.
* The stable background of operating systems and platform facilities tend to be ignored when it comes
* to DIP. We tolerate those concrete dependencies because we know we can rely on them not to change.
* It is the volatile concrete elements of our system that we want to avoid depending on.
* Stable software architectures are those that avoid depending on volatile concretions, and that
* favor the use of stable abstract interfaces.
* Don't refer to volatile concrete classes. Refer to abstract interfaces instead. This puts constraints
* on the creation of objects and generally enforces the use of abstract factories.
* Don't derive from volatile concrete classes
* Don't override concrete functions.
* Abstract factories can be used to manage concrete dependencies.
* Source code dependencies should point to abstractions.
* The abstract components contains all the high-level business rules of the application.
* The concrete components contains all the implementation details those rules manipulate.
* The flow of control crosses the line in the opposite direction of the source code dependencies.
* The source code dependencies are inverted against the flow of control, which is why we refer to
* this principle as Dependency Inversion.
* DIP violations cannot be entirely removed, but they can be gathered in a small number of concrete
* components and kept separated from the rest of the system.
*
* */

interface ServiceFactory {
    fun makeService() : AbstractService
}

interface AbstractService

class ConcreteService : AbstractService

class ServiceFactoryImpl : ServiceFactory {
    override fun makeService(): AbstractService = ConcreteService()
}

lateinit var factory: ServiceFactory

/*
*
* Main component that knows the concretions, DIP violations cannot be entirely removed.
* */
fun main2() {
    factory = ServiceFactoryImpl()
}

/*
*
* The Application component knows only about abstractions on compile time
* */
class Application {
    val service = factory.makeService()
}
//endregion