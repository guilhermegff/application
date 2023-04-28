package com.project.application.theory.solid

class SolidTheory

/* Single Responsibility Principle
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
* According to Robert Martin in "Clean Architecture", the SRP is about functions and classes but manifests itself on a different form
* at two more levels.It becomes the Common Closure Principle at the level of components and the Axis of Change at the level of
* Architectural Boundaries.
*
* */

class Employee() {
    val data = "data"

    fun calculatePay() {
        //Used by the CFO
        regularHours(data)
    }

    private fun regularHours(data: String) {

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
* In this solution we separate de data from the functions. Three different classes
* share access to the data class. Each class holds only the code necessary for its particular function
* The three classes do not know about each other.
*
* */

data class EmployeeData(val data: String = "data")

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

/* Open Closed Principle
*
* 
*
* */

/* Liskov Substitution Principle
*
*
* */

/* Interface Segregation Principle
*
*
* */

/* Dependency Inversion Principle
*
*
* */