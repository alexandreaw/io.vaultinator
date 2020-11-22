package io.vaultinator.repository

import io.vaultinator.mapper.toDomain
import io.vaultinator.mapper.toEntity
import io.vaultinator.model.PasswordManager
import io.vaultinator.port.output.repository.PasswordManagerRepository
import org.springframework.stereotype.Repository

@Repository
class PasswordManagerRepositoryImpl(
        private val jpa: PasswordManagerRepositoryJpa
) : PasswordManagerRepository {

    override fun add(passwordManager: PasswordManager) =
        jpa.save(passwordManager.toEntity())
                .toDomain()
                .id

    override fun getAll(): List<PasswordManager> =
        jpa.findAll().map { it.toDomain() }
}