package io.zerion.kmm.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

typealias ChainSlug = String

@Serializable
data class PortfolioResponse(
    @SerialName("links") val links: Links? = null,
    @SerialName("data") val data: PortfolioData? = null
)

@Serializable
data class Links(
    @SerialName("self")  val self: String
)

@Serializable
data class PortfolioData(
    @SerialName("type") val type: String,
    @SerialName("id") val id: String,
    @SerialName("attributes") val attributes: PortfolioAttributes
)

@Serializable
data class PortfolioAttributes(
    @SerialName("positions_distribution_by_type") val positions_distribution_by_type: PositionsDistributionByType,
    @SerialName("positions_distribution_by_chain") val positions_distribution_by_chain: Map<ChainSlug, Double>,
    @SerialName("total") val total: Total,
    @SerialName("changes") val changes: Changes
)

@Serializable
data class PositionsDistributionByType(
    @SerialName("wallet") val wallet: Double,
    @SerialName("deposited") val deposited: Double,
    @SerialName("borrowed") val borrowed: Double,
    @SerialName("locked") val locked: Double,
    @SerialName("staked") val staked: Double
)

@Serializable
data class Total(
    @SerialName("positions") val positions: Double
)

@Serializable
data class Changes(
    @SerialName("absolute_1d") val absolute_1d: Double,
    @SerialName("percent_1d")  val percent_1d: Double
)
