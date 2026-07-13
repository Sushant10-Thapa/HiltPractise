package com.hostel.hiltpractise.data.source.network

import com.hostel.hiltpractise.data.Task

interface NetworkDataSource {
    suspend fun loadTasks():List<NetworkTask>

    suspend fun saveTasks(tasks: List<NetworkTask>)
}