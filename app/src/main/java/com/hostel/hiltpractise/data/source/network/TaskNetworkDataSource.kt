package com.hostel.hiltpractise.data.source.network

import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

class TaskNetworkDataSource @Inject constructor() : NetworkDataSource {

    private val accessMutex = Mutex()
    private var tasks = listOf(
        NetworkTask(
            id = "PISA",
            title = "Build tower in Pisa",
            shortDescription = "Ground looks good, no foundation work required."
        ),
        NetworkTask(
            id = "TACOMA",
            title = "Finish bridge in Tacoma",
            shortDescription = "Found awesome girders at half the cost!"
        )
    )

    override suspend fun loadTasks(): List<NetworkTask>  = accessMutex.withLock {
        delay(SERVICE_LATENCY_IN_MILLIS.milliseconds)
        tasks
    }

    override suspend fun saveTasks(newTasks : List<NetworkTask>) = accessMutex.withLock {
        delay(SERVICE_LATENCY_IN_MILLIS.milliseconds)
        tasks = newTasks
    }
}

private const val SERVICE_LATENCY_IN_MILLIS = 2000L