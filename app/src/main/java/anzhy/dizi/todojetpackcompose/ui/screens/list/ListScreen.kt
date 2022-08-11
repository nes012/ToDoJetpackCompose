package anzhy.dizi.todojetpackcompose.ui.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import anzhy.dizi.todojetpackcompose.R
import anzhy.dizi.todojetpackcompose.ui.theme.fabBackgroundColor
import anzhy.dizi.todojetpackcompose.ui.viewmodels.SharedViewModel
import anzhy.dizi.todojetpackcompose.utils.Action
import anzhy.dizi.todojetpackcompose.utils.SearchAppBarState
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    //it will launch block into composition coroutineContext
    LaunchedEffect(key1 = true) {
        //this will trigger our repository
        sharedViewModel.getAllTasks()
    }

    //observing an action
    val action by sharedViewModel.action

    //collectAsState - collect values from state flow. It will update allTasks whenever there is changes in DB.
    //here we are basically observe our DB
    // use by instead = . This will immediately transfer state in simple list to do task
    val allTasks by sharedViewModel.allTasks.collectAsState()

    //this way we will observe state from VM
    val searchAppBarState: SearchAppBarState
            by sharedViewModel.searchAppBarState
    val searchTextState: String
            by sharedViewModel.searchTextState

    val scaffoldState = rememberScaffoldState()

    DisplaySnackBar(
        scaffoldState = scaffoldState,
        handleDatabaseAction = { sharedViewModel.handleDatabaseAction(action = action) },
        taskTitle = sharedViewModel.title,
        action = action
    )
    
    Scaffold(
        //scaffoldState provide an opportunity to display snackBar and use other fun
        scaffoldState = scaffoldState,
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = {
            //list content file
            //1. we need to create 1 row composable
            ListContent(
                tasks = allTasks,
                navigateToTaskScreen = navigateToTaskScreen
            )
        },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFab(
    onFabClicked: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            //navigate from list screen to task composable.
            //we are not selecting new task, we want create new one.
            //-1 mean we aren't selecting any task.
            onFabClicked(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_button),
            tint = Color.White
        )
    }
}

@Composable
fun DisplaySnackBar(
    scaffoldState: ScaffoldState,
    handleDatabaseAction: () -> Unit,
    taskTitle: String,
    action: Action
){
    handleDatabaseAction()

    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = action){
        if (action != Action.NO_ACTION){
            scope.launch {
                val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = "${action.name}: $taskTitle",
                    actionLabel = "Ok"
                )
            }
        }
    }
}

/*
@Composable
@Preview
private fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {

    })
}
*/
