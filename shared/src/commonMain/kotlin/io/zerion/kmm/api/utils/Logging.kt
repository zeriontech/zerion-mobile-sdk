package io.zerion.kmm.api.utils

import io.github.aakira.napier.Napier

object Logging {
    var isEnabled: Boolean = false

    fun info(message: String) {
        if (isEnabled) {
            Napier.i(message)
        }
    }

    fun error(message: String, throwable: Throwable? = null) {
        if (isEnabled) {
            Napier.e(message, throwable)
        }
    }

    fun debug(message: String) {
        if (isEnabled) {
            Napier.d(message)
        }
    }
}