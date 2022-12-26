package com.project.application.core

interface BaseAction <T> {
    suspend operator fun invoke() : T
}