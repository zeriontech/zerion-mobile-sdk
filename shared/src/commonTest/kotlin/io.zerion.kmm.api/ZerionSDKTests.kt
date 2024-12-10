package io.zerion.kmm.api

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ZerionSDKTests {

    @Test
    fun shouldInitializeLibrary() {
        val isInitialized = ZerionSDK.initialize("emtfZGV2XzcxMDI1ODBkMTU1YjRjMDI4OTExOTRiMWFkNTUzYjM0Og==")

        assertEquals(true, isInitialized)
    }

    @Test
    fun shouldFailInitializingLibrary() {
        val isInitialized = ZerionSDK.initialize("")

        assertEquals(false, isInitialized)
    }
}