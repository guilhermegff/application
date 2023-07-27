package com.example.datasource_api

import com.example.datasource_api.location.LocationDatabaseContractFactory
import com.example.datasource_api.user.UserDataBaseContractFactory

interface AppDatabaseContractFactory : UserDataBaseContractFactory, LocationDatabaseContractFactory