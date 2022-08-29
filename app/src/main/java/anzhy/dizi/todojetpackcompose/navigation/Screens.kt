package anzhy.dizi.todojetpackcompose.navigation

import androidx.navigation.NavHostController
import anzhy.dizi.todojetpackcompose.utils.Action
import anzhy.dizi.todojetpackcompose.utils.Constants.LIST_SCREEN

// this class handle navigation of app
class Screens(navController: NavHostController) {
    val list: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId") {
        }
    }

    //whenever we navigate we don't need to pass whole task object instead we will pass id of that selected task. Then we will request this task object from db by id.
    val task: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
}