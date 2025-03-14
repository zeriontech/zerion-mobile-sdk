package io.zerion.kmm.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FungibleInfo(
    @SerialName("name") val name: String,
    @SerialName("symbol") val symbol: String,
    @SerialName("icon") val icon: Icon? = null,
    @SerialName("flags") val flags: FungibleFlags,
    @SerialName("implementations") val implementations: List<Implementation>
)

@Serializable
data class Icon(
    @SerialName("url") val url: String
)

@Serializable
data class FungibleFlags(
    @SerialName("verified") val verified: Boolean
)

@Serializable
data class Implementation(
    @SerialName("chain_id") val chainId: String,
    @SerialName("address") val address: String? = null,
    @SerialName("decimals") val decimals: Int
)
