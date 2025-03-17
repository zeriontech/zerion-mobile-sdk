package io.zerion.kmm.api.models

enum class TrashFilter(val apiValue: String) {
    ONLY_TRASH("only_trash"),
    ONLY_NON_TRASH("only_non_trash"),
    NO_FILTER("no_filter")
}