package io.vaultinator.model

data class PasswordManager(
        val id: String,
        val name: String,
        val url: String,
        val username: String,
        val password: String
)