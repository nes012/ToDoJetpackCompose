package anzhy.dizi.todojetpackcompose.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import anzhy.dizi.todojetpackcompose.data.models.ToDoTask
import anzhy.dizi.todojetpackcompose.data.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {

    private val _allTasks =
        MutableStateFlow<List<ToDoTask>>(emptyList())

    val allTasks: StateFlow<List<ToDoTask>> = _allTasks

    fun getAllTasks() {
        viewModelScope.launch {
            repository.getAllTasks.collect {
                _allTasks.value = it
            }
        }
    }
}