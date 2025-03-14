package io.zerion.kmm.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TransactionsResponse(
    @SerialName("links") val links: TransactionLinks? = null,
    @SerialName("data") val data: List<TransactionData>? = null
)

@Serializable
data class TransactionLinks(
    @SerialName("self") val self: String,
    @SerialName("next") val next: String? = null
)

@Serializable
data class TransactionData(
    @SerialName("type") val type: String,
    @SerialName("id") val id: String,
    @SerialName("attributes") val attributes: TransactionAttributes,
    @SerialName("relationships") val relationships: TransactionRelationships
)

@Serializable
data class TransactionAttributes(
    @SerialName("operation_type") val operationType: String,
    @SerialName("hash") val hash: String,
    @SerialName("mined_at_block") val minedAtBlock: Long,
    @SerialName("mined_at") val minedAt: String,
    @SerialName("sent_from") val sentFrom: String,
    @SerialName("sent_to") val sentTo: String,
    @SerialName("status") val status: String,
    @SerialName("nonce") val nonce: Long,
    @SerialName("fee") val fee: TransactionFee? = null,
    @SerialName("transfers") val transfers: List<Transfer>? = emptyList(),
    @SerialName("approvals") val approvals: List<Approval>? = emptyList(),
    @SerialName("application_metadata") val applicationMetadata: ApplicationMetadata? = null,
    @SerialName("flags") val flags: TransactionFlags
)

@Serializable
data class Approval(
    @SerialName("fungible_info") val fungibleInfo: FungibleInfo,
    @SerialName("quantity") val quantity: Quantity? = null,
    @SerialName("sender") val sender: String? = null,
    @SerialName("recipient") val recipient: String? = null
)

@Serializable
data class TransactionFee(
    @SerialName("fungible_info") val fungibleInfo: FungibleInfo,
    @SerialName("quantity") val quantity: Quantity,
    @SerialName("price") val price: Double? = null,
    @SerialName("value") val value: Double? = null
)

@Serializable
data class Transfer(
    @SerialName("fungible_info") val fungibleInfo: FungibleInfo? = null,
    @SerialName("nft_info") val nftInfo: NftInfo? = null,
    @SerialName("direction") val direction: String,
    @SerialName("quantity") val quantity: Quantity,
    @SerialName("value") val value: Double? = null,
    @SerialName("price") val price: Double? = null,
    @SerialName("sender") val sender: String,
    @SerialName("recipient") val recipient: String
)

@Serializable
data class NftInfo(
    @SerialName("contract_address") val contractAddress: String,
    @SerialName("token_id") val tokenId: String,
    @SerialName("name") val name: String,
    @SerialName("interface") val interface_: String,
    @SerialName("content") val content: NftContent? = null,
    @SerialName("flags") val flags: NftFlags? = null
)

@Serializable
data class NftContent(
    @SerialName("preview") val preview: NftImage? = null,
    @SerialName("detail") val detail: NftImage? = null
)

@Serializable
data class NftImage(
    @SerialName("url") val url: String
)

@Serializable
data class NftFlags(
    @SerialName("is_spam") val isSpam: Boolean
)

@Serializable
data class ApplicationMetadata(
    @SerialName("name") val name: String? = null,
    @SerialName("icon") val icon: Icon? = null,
    @SerialName("contract_address") val contractAddress: String,
    @SerialName("method") val method: Method? = null
)

@Serializable
data class Method(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String
)

@Serializable
data class TransactionFlags(
    @SerialName("is_trash") val isTrash: Boolean
)

@Serializable
data class TransactionRelationships(
    @SerialName("chain") val chain: RelationshipData,
    @SerialName("dapp") val dapp: DappData? = null
)

@Serializable
data class DappData(
    @SerialName("data") val data: DappInfo
)

@Serializable
data class DappInfo(
    @SerialName("type") val type: String,
    @SerialName("id") val id: String
)