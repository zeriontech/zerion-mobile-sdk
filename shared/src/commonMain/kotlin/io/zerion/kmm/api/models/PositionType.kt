package io.zerion.kmm.api.models

enum class PositionType(val apiValue: String) {
    WALLET("wallet"),
    DEPOSIT("deposit"),
    LOAN("loan"),
    LOCKED("locked"),
    STAKED("staked"),
    REWARD("reward"),
    AIRDROP("airdrop"),
    MARGIN("margin")
} 