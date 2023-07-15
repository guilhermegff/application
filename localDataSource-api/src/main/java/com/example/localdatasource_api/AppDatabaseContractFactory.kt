package com.example.localdatasource_api

import com.example.localdatasource_api.location.LocationDatabaseContractFactory
import com.example.localdatasource_api.user.UserDataBaseContractFactory

interface AppDatabaseContractFactory : UserDataBaseContractFactory, LocationDatabaseContractFactory