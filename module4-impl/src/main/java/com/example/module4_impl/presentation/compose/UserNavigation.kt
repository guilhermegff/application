package com.example.module4_impl.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.module4_impl.presentation.userDetail.UserDetailScreen
import com.example.module4_impl.presentation.userDetail.UserDetailViewModel
import com.example.module4_impl.presentation.userList.UserListScreen
import com.example.module4_impl.presentation.userList.UserListViewModel

@Composable
internal fun UserNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Navigation.userList) {
        composable(
            route = Navigation.userList,
        ) {
            val viewModel = hiltViewModel<UserListViewModel>()
            val viewState = viewModel.state.collectAsState().value
            UserListScreen(viewState = viewState,
                action = { viewModel.errorAction() },
                onClick = { id ->
                    navController.navigate(
                        Navigation.userDetail.replace(Navigation.idHolder, id)
                    )
                })
        }

        composable(
            route = Navigation.userDetail,
        ) { backStackEntry ->
            val viewModel = hiltViewModel<UserDetailViewModel>()
            val viewState = viewModel.state.collectAsState().value
            UserDetailScreen(viewState = viewState, action = {
                viewModel.getDetail(backStackEntry.arguments?.getString("id") ?: "2")
            }, onClick = {}) {

            }
        }
    }
}

object Navigation {
    const val idHolder = "id"
    const val userDetail = "userDetail/{$idHolder}"
    const val userList = "userList"
}