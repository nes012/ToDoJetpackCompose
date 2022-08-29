package anzhy.dizi.todojetpackcompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import anzhy.dizi.todojetpackcompose.navigation.destinations.listComposable
import anzhy.dizi.todojetpackcompose.navigation.destinations.taskComposable
import anzhy.dizi.todojetpackcompose.ui.viewmodels.SharedViewModel
import anzhy.dizi.todojetpackcompose.utils.Constants.LIST_SCREEN
import com.google.accompanist.navigation.animation.AnimatedNavHost

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    //we want to pass this nav controller to same screens. so we need to remember it
    val screen = remember(navController) {
        //this way we will safe our backstack
        Screens(navController = navController)
    }

    //NavHost for animation transaction
    AnimatedNavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateToTaskScreen = screen.list,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = screen.task,
            sharedViewModel = sharedViewModel
        )
    }
}