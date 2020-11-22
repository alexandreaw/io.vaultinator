package io.vaultinator.service

import com.nhaarman.expect.expect
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.vaultinator.model.PasswordManager
import io.vaultinator.port.output.EncryptService
import io.vaultinator.port.output.repository.PasswordManagerRepository
import org.junit.jupiter.api.Test


class AddPasswordManagerAdapterTest {

    @Test
    fun `should add password manager successfully`() {
        // given
        val masterPassword = "123"
        val uuid = ""

        val passwordManager = mockk<PasswordManager>()
        val repository = mockk<PasswordManagerRepository>()
        val encryptService = mockk<EncryptService>()
        val service = AddPasswordManagerAdapter(repository, encryptService)

        every { repository.add(passwordManager) } returns uuid
        every { encryptService.encrypt(masterPassword, passwordManager) } returns passwordManager

        // when
        val result = service.add(masterPassword, passwordManager)

        // then
        verify { repository.add(passwordManager) }
        verify { encryptService.encrypt(masterPassword, passwordManager) }
        expect(result).toBeTheSameAs(uuid)
    }
}