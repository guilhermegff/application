package com.project.application.theory.coroutines

class CoroutinesTheory {
}

/*
*
* A Coroutine Scope wraps a Coroutine Context. The context has a Job object.
* The job object can be a regular Job class object or a SupervisorJob class object.
* The difference is that the SupervisorJob, when facing an exception, won't cancel all the children
* or itself. The regular Job class, when faced with an exception, will cancel its children and then
* its own scope.
*
* Structured Concurrency:
* - Every coroutine needs to be started in a logical scope with a limited life-time
* - Coroutines started in the same scope form a hierarchy (Job hierarchy)
* - A parent job won't complete until all of its children have completed
* - Cancelling a parent will cancel all children. Cancelling a child won't cancel the parent or the
*   siblings
* - If a child coroutine fails, the exception is propagated upwards and depending on the job type
*   either all siblings are cancelled or not
*
* Unstructured Concurrency:
* - Threads are started globally. Developers need to keep track of its lifetime
* - No hierarchy, threads run in isolation without any relationship between each other
* - All threads run completely independent from each other
* - No automatic cancellation mechanism
* - No automatic exception handling and mechanism
* */