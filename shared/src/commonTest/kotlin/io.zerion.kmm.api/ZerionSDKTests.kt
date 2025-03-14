package io.zerion.kmm.api

import io.zerion.kmm.api.api.ZerionApiConstants.DefaultValues.POSITIONS_FILTER_COMPLEX
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlinx.coroutines.runBlocking

private object AssetTypes {
    const val FUNGIBLE = "fungible"
    const val NFT = "nft"
}

private  object OperationTypes {
    const val APPROVE = "approve"
    const val DEPLOY = "deploy"
    const val EXECUTE = "execute"
    const val RECEIVE = "receive"
    const val SEND = "send"
}

class ZerionSDKTests {

    private val testWalletAddress = "0x42b9dF65B219B3dD36FF330A4dD8f327A6Ada990"

    @Test
    fun shouldInitializeLibrary() {
        val isInitialized =
            ZerionSDK.initialize("emtfZGV2XzcxMDI1ODBkMTU1YjRjMDI4OTExOTRiMWFkNTUzYjM0Og==")
        assertEquals(true, isInitialized)
    }

    @Test
    fun shouldFailInitializingLibrary() {
        val isInitialized = ZerionSDK.initialize("")
        assertEquals(false, isInitialized)
    }

    // Positions Tests
    @Test
    fun testGetWalletPositionsBasic() {
        runBlocking {
            // Initialize SDK
            ZerionSDK.initialize("emtfZGV2XzcxMDI1ODBkMTU1YjRjMDI4OTExOTRiMWFkNTUzYjM0Og==")

            // Basic request with minimal parameters
            val response = ZerionSDK
                .getZerionApiInteractor()
                .getWalletPositions(
                    address = testWalletAddress
                )

            println("Positions response: $response")

            assertNotNull(response)
            assertNotNull(response.data)
        }
    }

    @Test
    fun testGetWalletPositionsWithFilters() {
        runBlocking {
            // Initialize SDK
            ZerionSDK.initialize("emtfZGV2XzcxMDI1ODBkMTU1YjRjMDI4OTExOTRiMWFkNTUzYjM0Og==")

            // Request with multiple filters
            val response = ZerionSDK
                .getZerionApiInteractor()
                .getWalletPositions(
                    address = testWalletAddress,
                    positionsFilter = POSITIONS_FILTER_COMPLEX,
                    chainIds = listOf("ethereum"),
                    positionTypes = listOf("wallet", "deposit")
                )

            assertNotNull(response)
            assertNotNull(response.data)
        }
    }

    @Test
    fun testGetWalletPositionsWithDappFilters() {
        runBlocking {
            // Initialize SDK
            ZerionSDK.initialize("emtfZGV2XzcxMDI1ODBkMTU1YjRjMDI4OTExOTRiMWFkNTUzYjM0Og==")

            // Request positions filtered by specific DApps
            val response = ZerionSDK
                .getZerionApiInteractor()
                .getWalletPositions(
                    address = testWalletAddress,
                    positionsFilter = POSITIONS_FILTER_COMPLEX,
                    dappIds = listOf("aave-v3", "uniswap-v3")
                )

            assertNotNull(response)
            assertNotNull(response.data)
        }
    }

    // Transactions Tests
    @Test
    fun testGetWalletTransactionsBasic() {
        runBlocking {
            // Initialize SDK
            ZerionSDK.initialize("emtfZGV2XzcxMDI1ODBkMTU1YjRjMDI4OTExOTRiMWFkNTUzYjM0Og==")

            // First page
            val firstPage = ZerionSDK
                .getZerionApiInteractor()
                .getWalletTransactions(
                    address = testWalletAddress,
                    pageSize = 50
                )

            println("First page response: $firstPage")

            assertNotNull(firstPage)
            assertNotNull(firstPage.data)
        }
    }

    @Test
    fun testGetWalletTransactionsWithFilters() {
        runBlocking {
            // Initialize SDK
            ZerionSDK.initialize("emtfZGV2XzcxMDI1ODBkMTU1YjRjMDI4OTExOTRiMWFkNTUzYjM0Og==")

            // Request with multiple filters
            val response = ZerionSDK
                .getZerionApiInteractor()
                .getWalletTransactions(
                    address = testWalletAddress,
                    pageSize = 20,
                    operationTypes = listOf(OperationTypes.SEND, OperationTypes.RECEIVE),
                    assetTypes = listOf(AssetTypes.FUNGIBLE),
                    chainIds = listOf("ethereum") // Ethereum mainnet
                )

            assertNotNull(response)
            assertNotNull(response.data)
        }
    }

    @Test
    fun testGetWalletTransactionsWithSearchAndNFTs() {
        runBlocking {
            // Initialize SDK
            ZerionSDK.initialize("emtfZGV2XzcxMDI1ODBkMTU1YjRjMDI4OTExOTRiMWFkNTUzYjM0Og==")

            // Request NFT transactions with search
            val response = ZerionSDK
                .getZerionApiInteractor()
                .getWalletTransactions(
                    address = testWalletAddress,
                    pageSize = 15,
                    assetTypes = listOf(AssetTypes.NFT),
                    searchQuery = "NFT"
                )

            assertNotNull(response)
            assertNotNull(response.data)
        }
    }
}