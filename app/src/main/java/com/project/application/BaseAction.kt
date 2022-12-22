package com.project.application

interface BaseAction <T> {
    suspend operator fun invoke() : T
}