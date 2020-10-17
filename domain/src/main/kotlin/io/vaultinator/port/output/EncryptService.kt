package io.vaultinator.port.output

import io.vaultinator.model.PasswordManager

interface EncryptService {
    fun encrypt(masterPassword: String, passwordManager: PasswordManager): PasswordManager
}
