package com.example.core

import kotlinx.coroutines.*
import kotlin.jvm.Throws

abstract class BaseUseCase <Response, in Request> {
    private var job = Job()
    private var uiScope = CoroutineScope(Dispatchers.Main + job)

    @Throws(Exception::class)
    abstract suspend fun run(params: Request? = null): Response

    open fun invoke(params: Request? = null, onResult: (Response) -> Unit, onFailure: (Exception) -> Unit) {
        uiScope.launch {
            try {
                val result = withContext(Dispatchers.IO) { run(params) }
                onResult(result)
            } catch (e: Exception) {
                onFailure(e)
            }
        }
    }

    open fun dispose() {
        job.cancel()
    }
}

abstract class SingleBaseUseCase <Response> {
    private var job = Job()
    private var uiScope = CoroutineScope(Dispatchers.Main + job)

    @Throws(Exception::class)
    abstract suspend fun run(): Response

    open fun invoke(onResult: (Response) -> Unit, onFailure: (Exception) -> Unit) {
        uiScope.launch {
            try {
                val result = withContext(Dispatchers.IO) { run() }
                onResult(result)
            } catch (e: Exception) {
                onFailure(e)
            }
        }
    }

    open fun dispose() {
        job.cancel()
    }
}