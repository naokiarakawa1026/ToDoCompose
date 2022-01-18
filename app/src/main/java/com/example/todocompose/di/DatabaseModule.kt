package com.example.todocompose.di

import android.content.Context
import androidx.room.Room
import com.example.todocompose.data.ToDoDatabase
import com.example.todocompose.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Singleton::classではなくて、SingletonComponent::classに変更する
@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
     fun provideDatabase(
        @ApplicationContext context: Context
     ) = Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        DATABASE_NAME
     ).build()

    @Provides
    @Singleton
    fun provideDao(database: ToDoDatabase) = database.toDoDao()
}