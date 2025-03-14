package io.zerion.kmm.api.repository

import io.zerion.kmm.api.api.ZerionAPI
import io.zerion.kmm.api.api.ZerionApiConstants.DefaultValues
import io.zerion.kmm.api.models.PortfolioResponse
import io.zerion.kmm.api.models.PositionsResponse
import io.zerion.kmm.api.models.TransactionsResponse

interface ZerionApiInteractor {
    suspend fun getWalletPortfolio(address: String): PortfolioResponse

    suspend fun getWalletPositions(
        address: String,
        positionsFilter: String = DefaultValues.POSITIONS_FILTER_SIMPLE,
        currency: String = DefaultValues.CURRENCY_USD,
        positionTypes: List<String>? = null,
        chainIds: List<String>? = null,
        fungibleIds: List<String>? = null,
        dappIds: List<String>? = null,
        trash: String = DefaultValues.TRASH_NON_TRASH,
        sort: String = DefaultValues.SORT_VALUE
    ): PositionsResponse

    suspend fun getWalletTransactions(
        address: String,
        currency: String = DefaultValues.CURRENCY_USD,
        pageSize: Int = DefaultValues.DEFAULT_PAGE_SIZE,
        pageAfter: String? = null,
        searchQuery: String? = null,
        operationTypes: List<String>? = null,
        assetTypes: List<String>? = null,
        chainIds: List<String>? = null,
        minMinedAt: Long? = null,
        maxMinedAt: Long? = null,
        trash: String = DefaultValues.TRASH_NO_FILTER,
        fungibleImplementations: List<String>? = null
    ): TransactionsResponse
}

internal class ZerionApiInteractorImpl(private val api: ZerionAPI): ZerionApiInteractor {

    override suspend fun getWalletPortfolio(address: String): PortfolioResponse {
        return api.getWalletPortfolio(address)
    }

    override suspend fun getWalletPositions(
        address: String,
        positionsFilter: String,
        currency: String,
        positionTypes: List<String>?,
        chainIds: List<String>?,
        fungibleIds: List<String>?,
        dappIds: List<String>?,
        trash: String,
        sort: String
    ): PositionsResponse {
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

    override suspend fun getWalletTransactions(
        address: String,
        currency: String,
        pageSize: Int,
        pageAfter: String?,
        searchQuery: String?,
        operationTypes: List<String>?,
        assetTypes: List<String>?,
        chainIds: List<String>?,
        minMinedAt: Long?,
        maxMinedAt: Long?,
        trash: String,
        fungibleImplementations: List<String>?
    ): TransactionsResponse {
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
}