package io.vaultinator.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class PasswordManagerRestController() {

    @GetMapping
    fun getAllPasswords() : String {
        return "Message 2"
    }

}