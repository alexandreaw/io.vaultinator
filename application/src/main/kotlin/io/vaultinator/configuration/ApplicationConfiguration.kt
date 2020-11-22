package io.vaultinator.configuration

import io.vaultinator.port.output.EncryptService
import io.vaultinator.port.output.repository.PasswordManagerRepository
import io.vaultinator.service.AddPasswordManagerAdapter
import io.vaultinator.service.GetAllPassswordManagerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {

    @Bean
    fun add(passwordManagerRepository: PasswordManagerRepository, encryptService: EncryptService) =
        AddPasswordManagerAdapter(passwordManagerRepository, encryptService)

    @Bean
    fun getAllPasswordManagerUseCase(passwordManagerRepository: PasswordManagerRepository) =
            GetAllPassswordManagerAdapter(passwordManagerRepository)
}