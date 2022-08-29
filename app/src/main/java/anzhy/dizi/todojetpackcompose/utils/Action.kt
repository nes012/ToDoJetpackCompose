package anzhy.dizi.todojetpackcompose.utils

//we will use this class to pass the action from composable to list screen
enum class Action {
    ADD,
    UPDATE,
    DELETE,
    DELETE_ALL,
    UNDO,
    NO_ACTION
}

//convert string to action
fun String?.toAction(): Action {
    return if (this.isNullOrEmpty()) Action.NO_ACTION else Action.valueOf(this)
}