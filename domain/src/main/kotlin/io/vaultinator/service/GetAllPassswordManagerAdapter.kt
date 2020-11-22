package io.vaultinator.service

import io.vaultinator.model.PasswordManager
import io.vaultinator.port.input.GetAllPasswordManagerUseCase
import io.vaultinator.port.output.repository.PasswordManagerRepository

class GetAllPassswordManagerAdapter(
        private val passwordManagerRepository: PasswordManagerRepository
) : GetAllPasswordManagerUseCase {

    override fun getAll(): List<PasswordManager> =
        passwordManagerRepository.getAll()

}