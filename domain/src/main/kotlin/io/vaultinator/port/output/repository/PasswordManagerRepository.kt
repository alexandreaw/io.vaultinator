package io.vaultinator.port.output.repository

import io.vaultinator.model.PasswordManager

interface PasswordManagerRepository {
    abstract fun add(passwordManager: PasswordManager) : String

}
