package anzhy.dizi.todojetpackcompose.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import anzhy.dizi.todojetpackcompose.utils.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit
) {
    Scaffold(
        topBar = {
            TaskAppBar(
                navigateToListScreen = navigateToListScreen
            )

        },
        content = {}
    )
}