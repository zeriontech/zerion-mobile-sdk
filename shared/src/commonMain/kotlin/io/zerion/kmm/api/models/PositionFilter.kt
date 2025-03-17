package io.zerion.kmm.api.models

enum class PositionFilter(val apiValue: String) {
    ONLY_SIMPLE("only_simple"),
    ONLY_COMPLEX("only_complex"),
    NO_FILTER("no_filter")
} 