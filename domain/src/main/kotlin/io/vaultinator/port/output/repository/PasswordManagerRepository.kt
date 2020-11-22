package io.vaultinator.port.output.repository

import io.vaultinator.model.PasswordManager

interface PasswordManagerRepository {
    fun add(passwordManager: PasswordManager) : String
    fun getAll() : List<PasswordManager>

}
