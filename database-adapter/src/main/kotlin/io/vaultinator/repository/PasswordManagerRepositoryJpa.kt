package io.vaultinator.repository

import io.vaultinator.model.PasswordManagerEntity
import org.springframework.data.repository.CrudRepository
import java.util.*


interface PasswordManagerRepositoryJpa : CrudRepository<PasswordManagerEntity, UUID> {
}
