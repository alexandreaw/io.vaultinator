package io.vaultinator.mapper

import io.vaultinator.model.PasswordManager
import io.vaultinator.model.PasswordManagerEntity
import java.util.*


fun PasswordManager.toEntity() = PasswordManagerEntity(
        id = UUID.fromString(id),
        name = name,
        username = username,
        password = password,
        url = url
)

fun PasswordManagerEntity.toDomain() = PasswordManager(
        id = id.toString(),
        name = name,
        username = username,
        password = password,
        url = url
)
