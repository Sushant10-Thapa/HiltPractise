package com.hostel.hiltpractise.data.source.local

import androidx.room3.Entity
import androidx.room3.PrimaryKey


@Entity(tableName = "task")
data class LocalTask(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean
)
