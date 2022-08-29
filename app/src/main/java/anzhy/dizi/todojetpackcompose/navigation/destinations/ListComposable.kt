package anzhy.dizi.todojetpackcompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navArgument
import anzhy.dizi.todojetpackcompose.ui.screens.list.ListScreen
import anzhy.dizi.todojetpackcompose.ui.viewmodels.SharedViewModel
import anzhy.dizi.todojetpackcompose.utils.Constants.LIST_ARGUMENT_KEY
import anzhy.dizi.todojetpackcompose.utils.Constants.LIST_SCREEN
import anzhy.dizi.todojetpackcompose.utils.toAction

@ExperimentalAnimationApi
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
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        LaunchedEffect(key1 = action) {
            sharedViewModel.action.value = action
        }

        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}

