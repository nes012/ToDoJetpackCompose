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