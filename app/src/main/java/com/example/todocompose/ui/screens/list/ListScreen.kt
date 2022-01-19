package com.example.todocompose.ui.screens.list

import android.util.Log
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.todocompose.R
import com.example.todocompose.ui.theme.fabBackgroundColor
import com.example.todocompose.ui.viewModels.SharedViewModel
import com.example.todocompose.util.SearchAppBarState

@ExperimentalMaterialApi
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    LaunchedEffect(key1 = true) {
//        Log.d("ListScreen", "LaunchedEffect Triggered")
        sharedViewModel.getAllTasks()
    }

    val allTasks by sharedViewModel.allTasks.collectAsState()

//    for (task in allTasks.value) {
//        Log.d("ListScreen", task.title)
//    }

    val searchAppBarState: SearchAppBarState
            by sharedViewModel.searchAppBarsState
    val searchTextState: String by sharedViewModel.searchTextState

    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppbarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = {
            ListContent(
                tasks = allTasks,
                navigateToTaskScreen = navigateToTaskScreen
            )
        },
        floatingActionButton = {
            ListFab(navigateToTaskScreen = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFab(
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            navigateToTaskScreen(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button),
            tint = Color.White
        )
    }
}

//@Composable
//@Preview
//private fun ListScreenPreview() {
//    ListScreen(
//        navigateToTaskScreen = {},
//        sharedViewModel = sharedViewModel
//    )
//}
