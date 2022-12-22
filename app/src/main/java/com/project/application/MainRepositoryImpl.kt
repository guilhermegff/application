package com.project.application

import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainService: MainService,
):  MainRepository{
    override suspend fun getUserDetail(): UserDetail {
        return mainService.user()
    }
}