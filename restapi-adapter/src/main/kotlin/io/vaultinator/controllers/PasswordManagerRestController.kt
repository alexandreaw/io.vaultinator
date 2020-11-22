package io.vaultinator.controllers

import io.vaultinator.model.AddPasswordManagerResponse
import io.vaultinator.model.PasswordManager
import io.vaultinator.port.input.AddPasswordManagerUseCase
import io.vaultinator.port.input.GetAllPasswordManagerUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/password-manager")
class PasswordManagerRestController(
        val addPasswordManagerUseCase: AddPasswordManagerUseCase,
        val getAllPasswordManagerUseCase: GetAllPasswordManagerUseCase
) {

    @PostMapping
    fun addPasswordManager(@RequestHeader("vaultinator.master-password") masterPassword: String, @RequestBody passwordManager: PasswordManager) =
        AddPasswordManagerResponse(addPasswordManagerUseCase.add(masterPassword, passwordManager))

    @GetMapping
    fun getAllPasswordManager() : List<PasswordManager> =
            getAllPasswordManagerUseCase.getAll()
}