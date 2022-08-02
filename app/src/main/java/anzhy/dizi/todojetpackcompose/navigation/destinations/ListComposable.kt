package anzhy.dizi.todojetpackcompose.navigation.destinations

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import anzhy.dizi.todojetpackcompose.ui.screens.list.ListScreen
import anzhy.dizi.todojetpackcompose.ui.viewmodels.SharedViewModel
import anzhy.dizi.todojetpackcompose.utils.Constants.LIST_ARGUMENT_KEY
import anzhy.dizi.todojetpackcompose.utils.Constants.LIST_SCREEN

@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}