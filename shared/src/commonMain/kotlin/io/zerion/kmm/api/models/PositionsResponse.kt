package io.zerion.kmm.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PositionsResponse(
    @SerialName("links") val links: Links? = null,
    @SerialName("data") val data: List<PositionData>
)

@Serializable
data class PositionData(
    @SerialName("type") val type: String,
    @SerialName("id") val id: String,
    @SerialName("attributes") val attributes: PositionAttributes,
    @SerialName("relationships") val relationships: PositionRelationships
)

@Serializable
data class PositionAttributes(
    @SerialName("parent") val parent: String? = null,
    @SerialName("protocol") val protocol: String? = null,
    @SerialName("name") val name: String,
    @SerialName("position_type") val positionType: String,
    @SerialName("quantity") val quantity: Quantity,
    @SerialName("value") val value: Double? = null,
    @SerialName("price") val price: Double? = null,
    @SerialName("changes") val changes: Changes? = null,
    @SerialName("fungible_info") val fungibleInfo: FungibleInfo,
    @SerialName("flags") val flags: Flags,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("updated_at_block") val updatedAtBlock: Long? = null
)

@Serializable
data class Quantity(
    @SerialName("int") val int: String,
    @SerialName("decimals") val decimals: Int,
    @SerialName("float") val float: Double,
    @SerialName("numeric") val numeric: String
)

@Serializable
data class Flags(
    @SerialName("displayable") val displayable: Boolean,
    @SerialName("is_trash") val isTrash: Boolean
)

@Serializable
data class PositionRelationships(
    @SerialName("chain") val chain: RelationshipData,
    @SerialName("fungible") val fungible: RelationshipData
)

@Serializable
data class RelationshipData(
    @SerialName("links") val links: RelationshipLinks,
    @SerialName("data") val data: RelationshipDataInfo
)

@Serializable
data class RelationshipLinks(
    @SerialName("related") val related: String
)

@Serializable
data class RelationshipDataInfo(
    @SerialName("type") val type: String,
    @SerialName("id") val id: String
) 