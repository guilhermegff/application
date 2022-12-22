package com.project.application

interface MainRepository {
    suspend fun getUserDetail(): UserDetail
}