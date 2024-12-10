package io.zerion.kmm.api.repository

import io.zerion.kmm.api.api.ZerionAPI
import io.zerion.kmm.api.models.PortfolioResponse

interface ZerionAPIRepository {
    suspend fun getWalletPortfolio(address: String): PortfolioResponse
}

internal class ZerionAPIRepositoryImpl(private val api: ZerionAPI): ZerionAPIRepository {

    override suspend fun getWalletPortfolio(address: String): PortfolioResponse {
        return api.getWalletPortfolio(address)
    }
}