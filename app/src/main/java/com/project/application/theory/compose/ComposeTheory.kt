package com.project.application.theory.compose

import androidx.compose.runtime.Composable

@Composable
fun ComposeTheory() {
}

/*
*
* Compose:
* Compose is a declarative UI framework. It recreates the entire screen from the scratch and then
* applies the necessary changes. This approach avoids the complexity of manually updating a stateful
* view hierarchy.
* Many imperative object-oriented UI toolkits initialize the UI by instantiating a tree of widgets,
* often done by inflating a XML file. Each widget maintains its own internal state and exposes
* getter and setter methods that allow the app logic to interact with the widget.
* In Compose's declarative approach, widgets are relatively stateless and do not expose setter or
* getter functions. Widgets are not exposed as objects.
* The UI is updated by calling the same composable function with different arguments.
* - The app logic provides data to the top-level composable function. That function uses the data
* to describe the UI by calling other composables, and passes the appropriate data to those
* composables, and on down the hierarchy.
* - User interaction with the UI can raise events that should notify the app logic, which can then
* change the app state.
* - Recomposition:
*  - When the state changes, the composable functions are called again with the new data and this
*    causes the UI elements to be redrawn.
* When compose recomposes based on new inputs, it only calls the functions or lambdas that might have
* changed and skips the rest.
* By skipping all functions and lambdas that don't have changed parameters, compose can recompose
* efficiently.
* - Never depend on side-effects from executing composable functions:
*  - Writing to a property of a shared object
*  - Updating an observable in viewmodel
*  - Updating shared preferences
* - Composable functions might be re-executed as often as every frame
* - Composable functions can execute in any order
* - Composable functions can execute in parallel
* - Recomposition skips as many composable functions and lambdas as possible
* - Recomposition is optimistic and may be canceled
*
* Compose Lifecycle:
* A composition describes the UI and is produced by running composables.
* It is a tree-structure of the composables that describe the UI.
* When the composables run for the first time, during the initial composition, it will keep track of
* the composables that are called.
* A composition can only be produced by an initial composition and updated by recomposition
* - Composable lifecycle:
*  - Enters the composition
*  - Recomposes 0 or more times
*  - Leaves the composition
*
* */