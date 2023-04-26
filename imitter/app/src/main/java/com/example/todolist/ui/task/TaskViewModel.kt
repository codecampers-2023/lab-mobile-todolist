package com.example.todolist.ui.task

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.data.TaskRepository
import com.example.todolist.data.local.TaskEntry
import kotlinx.coroutines.launch
import javax.inject.Inject

class TaskViewModel @Inject constructor (private val repository: TaskRepository) : ViewModel() {
    val getAllTasks = repository.getAllTasks()
    val getAllPriorityTasks = repository.getAllPriorityTasks()

    fun insert(taskEntry: TaskEntry) = viewModelScope.launch {
        repository.insert(taskEntry)
    }

    fun delete(taskEntry: TaskEntry) = viewModelScope.launch{
        repository.deleteItem(taskEntry)
    }

    fun update(taskEntry: TaskEntry) = viewModelScope.launch{
        repository.updateData(taskEntry)
    }

    fun deleteAll() = viewModelScope.launch{
        repository.deleteAll()
    }

    fun searchDatabase(searchQuery: String): LiveData<List<TaskEntry>> {
        return repository.searchDatabase(searchQuery)
    }
}