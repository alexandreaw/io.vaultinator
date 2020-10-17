package io.vaultinator.service

import io.vaultinator.model.PasswordManager
import io.vaultinator.port.input.AddPasswordManagerUseCase
import io.vaultinator.port.output.EncryptService
import io.vaultinator.port.output.repository.PasswordManagerRepository

class AddPasswordManagerAdapter(
        private val passwordManagerRepository: PasswordManagerRepository,
        private val encryptService: EncryptService
) : AddPasswordManagerUseCase {

    override fun add(masterPassword: String, passwordManager: PasswordManager): String {
        val encryptedPasswordManager = encryptService.encrypt(masterPassword, passwordManager)

        return passwordManagerRepository.add(encryptedPasswordManager)
    }

}