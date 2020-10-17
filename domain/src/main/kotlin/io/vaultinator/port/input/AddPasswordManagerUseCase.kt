package io.vaultinator.port.input

import io.vaultinator.model.PasswordManager

interface AddPasswordManagerUseCase {
    fun add(masterPassword: String, passwordManager: PasswordManager) : String
}