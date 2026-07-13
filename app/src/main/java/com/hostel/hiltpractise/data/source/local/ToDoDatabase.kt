package com.hostel.hiltpractise.data.source.local


import androidx.room3.Database
import androidx.room3.RoomDatabase

/**
 * The Room Database that contains the Task table.
 *
 * Note that exportSchema should be true in production databases.
 */
@Database(entities = [LocalTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}