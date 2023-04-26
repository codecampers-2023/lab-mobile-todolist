package com.example.todolist.di

import android.content.Context
import androidx.room.Room
import com.example.todolist.data.local.TaskDatabase
import com.example.todolist.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTaskDao(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            Constants.TASK_DATABASE
        ).build().taskDao()
}