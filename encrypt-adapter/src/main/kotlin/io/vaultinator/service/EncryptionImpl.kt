package io.vaultinator.service

import io.vaultinator.model.PasswordManager
import io.vaultinator.port.output.EncryptService
import org.springframework.stereotype.Service

@Service
class EncryptionImpl: EncryptService {
    override fun encrypt(masterPassword: String, passwordManager: PasswordManager): PasswordManager {
        return passwordManager
    }
}