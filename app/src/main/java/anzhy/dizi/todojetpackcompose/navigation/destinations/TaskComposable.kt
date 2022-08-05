package anzhy.dizi.todojetpackcompose.navigation.destinations

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import anzhy.dizi.todojetpackcompose.ui.screens.task.TaskScreen
import anzhy.dizi.todojetpackcompose.utils.Action
import anzhy.dizi.todojetpackcompose.utils.Constants.TASK_ARGUMENT_KEY
import anzhy.dizi.todojetpackcompose.utils.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        Log.d("TaskComposable", taskId.toString())

        TaskScreen(
            navigateToListScreen = navigateToListScreen
        )
    }
}