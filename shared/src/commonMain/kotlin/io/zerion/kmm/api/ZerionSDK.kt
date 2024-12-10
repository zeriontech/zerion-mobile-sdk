package io.zerion.kmm.api

import io.github.aakira.napier.Napier
import io.zerion.kmm.api.api.ZerionAPI
import io.zerion.kmm.api.api.ZerionAPIImpl
import io.zerion.kmm.api.httpclient.buildHttpClient
import io.zerion.kmm.api.repository.ZerionAPIRepository
import io.zerion.kmm.api.repository.ZerionAPIRepositoryImpl
import io.zerion.kmm.api.utils.Logging

object ZerionSDK {

    private lateinit var api: ZerionAPI
    private lateinit var zerionApiRepository: ZerionAPIRepository

    fun initialize(authorization: String): Boolean {
        return try {
            Logging.log("ZerionLibrary initialization started")

            if (authorization.isEmpty()) {
                throw IllegalArgumentException("Authorization cannot be empty")
            }

            val client = buildHttpClient(authorization)

            api = ZerionAPIImpl(client)
            zerionApiRepository = ZerionAPIRepositoryImpl(api)

            true
        } catch (e: Exception) {
            Napier.e("ZerionLibrary initialization failed")
            false
        }
    }

    fun getZerionApiRepository(): ZerionAPIRepository {
        if (!this::zerionApiRepository.isInitialized) {
            throw IllegalStateException("ZerionLibrary is not initialized. Call initialize() first.")
        }

        return zerionApiRepository
    }
}