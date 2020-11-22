package io.vaultinator.port.input

import io.vaultinator.model.PasswordManager

interface GetAllPasswordManagerUseCase {
    fun getAll(): List<PasswordManager>
}