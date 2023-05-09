package com.project.application.theory.gradle

class GradleTheory {
}

/*
*
* Gradle Terms:
* - Project
*   A container for the entire build
* - Build Script
*   Describes what the build does
* - Tasks
*   Individual unit of work added to the build script
* - Plugins
*   Pre-packaged components of useful build functionality
*
* Gradle Wrapper:
* The gradle wrapper is a script used to run tasks and interact with gradle projects
* - gradle-wrapper.jar
*   contains the code required for downloading the correct gradle version. The distribution is
*   stored in the user home directory
* - gradle-wrapper.properties
*   is the configuration file, it contains the distribution URL for the required gradle version
* - gradlew
*   is a shell script for executing a gradle build using the wrapper on linux or mac
* - gradlew.bat
*   is the script for executing a gradle build on windows
* Files and Directories:
* - build.gradle
*   contains the gradle build script definition
* - settings.gradle
*   contains the project name, and names of other projects in a multi project.
* - gradle wrapper related files
*   gradle-wrapper.jar
*   gradle-wrapper.properties
*   gradlew
*   gradlew.bat
* - build directory
*   is the default directory into which gradle generates project artifacts
*   compiled classes
*   jar files
*   anything else that gets created when running the gradle build
* - gradle directory
*   is a project specific cache generated and managed by gradle. It is used by gradle internally
* - optional buildSrc directory
*   is used to encapsulate build logic in a central place, outside of the build.gradle file
* - optional gradle.properties file
*   is a list of properties specific to a project. It can contain either built-in gradle properties
*   or custom properties
*
* The .gradle and build directories are transitive directories that get created as a result of
* running a build and shouldn't be committed
*
* Gradle Build Lifecycle:
* It consists of three phases
* - Initialization
* - Configuration
* - Execution
*
* Initialization Phase:
*   gradle executes the settings.gradle file and defines all the projects involved in the build along
*   with their names.
* Configuration Phase:
*   gradle executes all build.gradle files of all projects involved in the build. Gradle builds the
*   in-memory model of the project and gets ready to execute tasks
* Execution Phase:
*   gradle executes the tasks
*
* Library:
* When you build a library you are effectively on the producer side: you are producing artifacts
* which are going to be consumed by someone else, the consumer.
* - A project that depends on another project is a consumer
* - A task that depends on an artifact is a finer grained consumer
* In order for a producer to compile a library, it needs all its implementation dependencies on the
* compile classpath.
* A dependency which is assigned to the implementation configuration of a library does not end up
* on the compile classpath of the consumer. On the other hand, a dependency which is assigned to
* the api configuration of a library would end up on the compile classpath of the consumer.
* At runtime, however, all dependencies are required.
* If a dependency is added to the project it becomes a transitive dependency of your consumers.
* */