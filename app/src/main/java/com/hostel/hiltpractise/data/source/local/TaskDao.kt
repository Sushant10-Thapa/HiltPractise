package com.hostel.hiltpractise.data.source.local

import androidx.room3.Dao
import androidx.room3.Query
import androidx.room3.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun observeAll(): Flow<List<LocalTask>>

    @Query("SELECT * FROM task WHERE id = :taskId")
    fun observeById(taskId: String): Flow<LocalTask>

    @Query("SELECT ALL FROM task")
    suspend fun getAll(): List<LocalTask>

    @Query("SELECT ALL FROM task WHERE id = :taskId")
    suspend fun getById(taskId: String): LocalTask?

    @Upsert
    suspend fun upsert(task: LocalTask)

    @Upsert
    suspend fun upsertAll(tasks: List<LocalTask>)

    @Query("UPDATE task SET completed = :completed WHERE id = :taskId")
    suspend fun updateCompleted(taskId: String, completed: Boolean)

    @Query("DELETE FROM task WHERE id = :taskId")
    suspend fun deleteById(taskId: String): Int

    @Query("DELETE FROM task")
    suspend fun deleteAll()

    @Query("DELETE FROM task WHERE isCompleted = :isCompleted")
    suspend fun deleteCompleted(isCompleted: Boolean):Int

}