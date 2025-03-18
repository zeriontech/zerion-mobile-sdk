package io.zerion.kmm.api

import io.zerion.kmm.api.models.PositionFilter
import kotlin.test.BeforeTest
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

    private val testWalletAddress = "0x67c0fc4b0490ab7e76c08c2bbd30fac0059bbc7a"

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
                
                .getWalletPositions(
                    address = testWalletAddress,
                    positionsFilter = PositionFilter.ONLY_COMPLEX.apiValue,
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
                .getWalletPositions(
                    address = testWalletAddress,
                    positionsFilter = PositionFilter.ONLY_COMPLEX.apiValue,
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