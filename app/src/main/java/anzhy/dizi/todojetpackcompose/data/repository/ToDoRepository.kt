package anzhy.dizi.todojetpackcompose.data.repository

import anzhy.dizi.todojetpackcompose.data.ToDoDao
import anzhy.dizi.todojetpackcompose.data.models.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//this annotation tells that instance of our repository will be alive as long as shared vm
@ViewModelScoped
class ToDoRepository @Inject constructor(
    private val toDoDao: ToDoDao
) {

    val getAllTasks: Flow<List<ToDoTask>> = toDoDao.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = toDoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTask>> = toDoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<ToDoTask> {
        return toDoDao.getSelectedTask(taskId = taskId)
    }

    suspend fun addTask(toDoTask: ToDoTask) {
        toDoDao.addTask(toDoTask = toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask) {
        toDoDao.updateTask(toDoTask = toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask) {
        toDoDao.deleteTask(toDoTask = toDoTask)
    }

    suspend fun deleteAllTask() {
        toDoDao.deleteAllTasks()
    }

    fun searchDatabase(searchQuery: String) {
        toDoDao.searchDatabase(searchQuery)
    }

}