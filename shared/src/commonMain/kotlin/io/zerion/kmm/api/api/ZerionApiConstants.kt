package io.zerion.kmm.api.api

internal object ZerionApiConstants {
    const val DEFAULT_API_URL = "https://api.zerion.io/v1/"

    object Params {
        const val POSITIONS_FILTER = "filter[positions]"
        const val CURRENCY = "currency"
        const val POSITION_TYPES = "filter[position_types]"
        const val CHAIN_IDS = "filter[chain_ids]"
        const val FUNGIBLE_IDS = "filter[fungible_ids]"
        const val DAPP_IDS = "filter[dapp_ids]"
        const val TRASH = "filter[trash]"
        const val SORT = "sort"

        const val PAGE_SIZE = "page[size]"
        const val PAGE_AFTER = "page[after]"
        const val SEARCH_QUERY = "filter[search_query]"
        const val OPERATION_TYPES = "filter[operation_types]"
        const val ASSET_TYPES = "filter[asset_types]"
        const val MIN_MINED_AT = "filter[min_mined_at]"
        const val MAX_MINED_AT = "filter[max_mined_at]"
        const val FUNGIBLE_IMPLEMENTATIONS = "filter[fungible_implementations]"
    }

    object DefaultValues {
        const val DEFAULT_PAGE_SIZE = 20
        const val CURRENCY_USD = "usd"
    }
} 