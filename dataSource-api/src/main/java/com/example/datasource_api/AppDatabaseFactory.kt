package com.example.datasource_api

import com.example.datasource_api.location.LocationDatabaseFactory
import com.example.datasource_api.user.UserDataBaseFactory

interface AppDatabaseFactory : UserDataBaseFactory, LocationDatabaseFactory