package io.zerion.kmm.api.utils

import io.github.aakira.napier.Napier


object Logging {
    internal const val TAG = "ZerionAPI"

    fun log(message: String) {
        Napier.d(tag = TAG, message = message)
    }
}