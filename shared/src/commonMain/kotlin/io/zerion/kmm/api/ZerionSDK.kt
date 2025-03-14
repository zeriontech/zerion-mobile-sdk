package io.zerion.kmm.api

import io.zerion.kmm.api.api.ZerionAPI
import io.zerion.kmm.api.api.ZerionAPIImpl
import io.zerion.kmm.api.api.ZerionApiConstants.DEFAULT_API_URL
import io.zerion.kmm.api.api.ZerionApiConstants.DefaultValues
import io.zerion.kmm.api.exceptions.ZerionApiException
import io.zerion.kmm.api.httpclient.buildHttpClient
import io.zerion.kmm.api.models.ChainId
import io.zerion.kmm.api.models.PortfolioResponse
import io.zerion.kmm.api.models.PositionFilter
import io.zerion.kmm.api.models.PositionsResponse
import io.zerion.kmm.api.models.SortType
import io.zerion.kmm.api.models.TransactionsResponse
import io.zerion.kmm.api.models.TrashFilter
import io.zerion.kmm.api.utils.Logging

object ZerionSDK {

    private lateinit var api: ZerionAPI

    fun initialize(
        authorization: String,
        apiUrl: String = DEFAULT_API_URL,
        isWithLogging: Boolean = false
    ): Boolean {
        return try {
            Logging.isEnabled = isWithLogging
            Logging.info("ZerionLibrary initialization started")

            if (authorization.isEmpty()) {
                throw ZerionApiException.ZerionAuthorizationException("Authorization cannot be empty")
            }

            val client = buildHttpClient(authorization, apiUrl)

            api = ZerionAPIImpl(client)

            Logging.info("ZerionLibrary initialization completed successfully")
            true
        } catch (e: ZerionApiException) {
            Logging.error("ZerionLibrary initialization failed", e)
            false
        } catch (e: Exception) {
            Logging.error("ZerionLibrary initialization failed", e)
            throw ZerionApiException.ZerionInitializationException("Unexpected error during initialization", e)
        }
    }

    suspend fun getWalletPortfolio(address: String): PortfolioResponse {
        requireInitialize()

        return api.getWalletPortfolio(address)
    }

    suspend fun getWalletPositions(
        address: String,
        positionsFilter: String = PositionFilter.ONLY_SIMPLE.apiValue,
        currency: String = DefaultValues.CURRENCY_USD,
        positionTypes: List<String>? = null,
        chainIds: List<ChainId>? = null,
        fungibleIds: List<String>? = null,
        dappIds: List<String>? = null,
        trash: String = TrashFilter.ONLY_NON_TRASH.apiValue,
        sort: String = SortType.VALUE_ASCENDING.apiValue
    ): PositionsResponse {
        requireInitialize()

        return api.getWalletPositions(
            address = address,
            positionsFilter = positionsFilter,
            currency = currency,
            positionTypes = positionTypes,
            chainIds = chainIds,
            fungibleIds = fungibleIds,
            dappIds = dappIds,
            trash = trash,
            sort = sort
        )
    }

    suspend fun getWalletTransactions(
        address: String,
        currency: String = DefaultValues.CURRENCY_USD,
        pageSize: Int = DefaultValues.DEFAULT_PAGE_SIZE,
        pageAfter: String? = null,
        searchQuery: String? = null,
        operationTypes: List<String>? = null,
        assetTypes: List<String>? = null,
        chainIds: List<ChainId>? = null,
        minMinedAt: Long? = null,
        maxMinedAt: Long? = null,
        trash: String = TrashFilter.ONLY_NON_TRASH.apiValue,
        fungibleImplementations: List<String>? = null
    ): TransactionsResponse {
        requireInitialize()

        return api.getWalletTransactions(
            address = address,
            currency = currency,
            pageSize = pageSize,
            pageAfter = pageAfter,
            searchQuery = searchQuery,
            operationTypes = operationTypes,
            assetTypes = assetTypes,
            chainIds = chainIds,
            minMinedAt = minMinedAt,
            maxMinedAt = maxMinedAt,
            trash = trash,
            fungibleImplementations = fungibleImplementations
        )
    }

    private fun requireInitialize() {
        if (!this::api.isInitialized) {
            throw ZerionApiException.ZerionInitializationException("ZerionLibrary is not initialized. Call initialize() first.")
        }
    }
}