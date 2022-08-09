package anzhy.dizi.todojetpackcompose.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import anzhy.dizi.todojetpackcompose.data.models.Priority
import anzhy.dizi.todojetpackcompose.data.models.ToDoTask
import anzhy.dizi.todojetpackcompose.ui.viewmodels.SharedViewModel
import anzhy.dizi.todojetpackcompose.utils.Action

@Composable
fun TaskScreen(
    sharedViewModel: SharedViewModel,
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {

    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = {
                    sharedViewModel.title.value = it
                },
                description = description,
                onDescriptionChange = {
                    sharedViewModel.description.value = it
                },
                priority = priority,
                onPrioritySelected = {
                    sharedViewModel.priority.value = it
                }
            )
        }
    )
}