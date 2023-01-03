package com.project.application.core

import java.util.concurrent.Executor

suspend operator fun <T> Executor.invoke(function: suspend () -> T) = function.invoke()