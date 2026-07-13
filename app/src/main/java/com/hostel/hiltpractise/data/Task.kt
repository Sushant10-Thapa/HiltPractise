package com.hostel.hiltpractise.data

import com.hostel.hiltpractise.data.source.local.LocalTask

data class Task(
    val title: String ="",
    val description: String="",
    val isCompleted: Boolean = false,
    val id :String=""
){


    val titleForList: String
        get() = if (title.isNotEmpty()) title else description

    val isActive: Boolean
        get() = !isCompleted

    val isEmpty
    get() = title.isEmpty() || description.isEmpty()
}
