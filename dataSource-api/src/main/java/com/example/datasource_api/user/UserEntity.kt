package com.example.datasource_api.user

interface UserEntity {
    val id: Int
    val name: String
    val email: String?
    val gender: String?
    val status: String
}