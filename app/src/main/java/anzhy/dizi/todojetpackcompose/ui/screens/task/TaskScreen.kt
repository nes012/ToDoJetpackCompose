package anzhy.dizi.todojetpackcompose.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import anzhy.dizi.todojetpackcompose.data.models.ToDoTask
import anzhy.dizi.todojetpackcompose.utils.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )

        },
        content = {

        }
    )
}