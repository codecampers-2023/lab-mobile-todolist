package com.example.todolist.ui.task

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.data.TaskRepository
import com.example.todolist.data.local.TaskDatabase
import com.example.todolist.data.local.TaskEntry
import kotlinx.coroutines.launch

class TaskViewModel(context: Context?) : ViewModel() {

    private val taskDao = context?.let { TaskDatabase.getDatabase(it).taskDao() }
    private val repository : TaskRepository


    val getAllTasks: LiveData<List<TaskEntry>>
    val getAllPriorityTasks: LiveData<List<TaskEntry>>


    init {

        repository = TaskRepository(taskDao)
        getAllTasks = repository.getAllTasks()
        getAllPriorityTasks = repository.getAllPriorityTasks()
    }


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