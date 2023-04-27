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
* A classic example can be found in "Clean Architecture" from Robert Martin:
* In it we have a system that calculates the salary, creates the hours report and saves data to the database.
* All this functionality is packed in one single class but different actors asked for it.
* The CFO uses the method that calculates the salary, the CTO decides how data is persisted and HR also uses the hours report.
* In this example the CFO may ask for a change to the functionality so that the overtime hour is calculated in a different manner
* inside the hours report method. If the change is made it will fulfill the new requirement but will hamper the work of the HR sector
* that does not need the new way to calculate overtime hours, so there is a conflict of responsibilities in this class. It has more than
* one responsibility, more than one actor can ask for changes and be affected by them, it has more than one reason to change.
* The solution is to extract the multiple responsibilities into different classes so that each have only one reason to change. This
* way the changes that are required by the CFO won't bring unwanted changes to the HR team.
*
* */

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