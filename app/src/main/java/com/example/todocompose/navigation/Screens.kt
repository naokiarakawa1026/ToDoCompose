package com.example.todocompose.navigation

import androidx.navigation.NavHostController
import com.example.todocompose.util.Action
import com.example.todocompose.util.Constants.LIST_SCREEN

class Screens(navController : NavHostController) {

    // この変数で1つの画面を表している
    // 以下のActionは、enumクラスと紐づいており、それぞれどのようなアクションをするのかという情報を渡している
    val list : (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {

            // 今回はlistComposableに遷移したい
            // inclusive = trueにすることで、バックスタックから除外できる
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    // この変数で1つの画面を表している
    val task : (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }
}