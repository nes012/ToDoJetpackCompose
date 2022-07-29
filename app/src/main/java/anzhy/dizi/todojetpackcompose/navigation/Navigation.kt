package anzhy.dizi.todojetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import anzhy.dizi.todojetpackcompose.navigation.destinations.listComposable
import anzhy.dizi.todojetpackcompose.navigation.destinations.taskComposable
import anzhy.dizi.todojetpackcompose.utils.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController
) {
    //we want to pass this nav controller to same screens. so we need to remember it
    val screen = remember(navController) {
        //this way we will safe our backstack
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateToTaskScreen = screen.list
        )
        taskComposable(
            navigateToListScreen = screen.task
        )
    }
}