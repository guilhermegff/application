package com.project.application.theory.flow

class FlowTheory {
}

/*
*
* Cold Flows:
* - Become active on collection
* - Become inactive on cancellation of the collecting coroutine
* - Emit individual data streams to every collector
*
* Example: Flow class
*
* Hot Flows:
* - Are active regardless of whether there are collectors
* - Stay active even when there is no more collectors
* - Emissions are shared between all collectors
*
* Example: SharedFlow, StateFlow classes
*
* SharedFlow:
* - No need for initial value
* - Customizable replay cache
* - Has emissions of subsequent equal values
*
* StateFlow:
* - Has need for initial value
* - Replay cache with fixed size of 1
* - Has no emission of subsequent equal values
* */