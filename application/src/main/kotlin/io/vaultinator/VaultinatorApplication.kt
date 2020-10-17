package io.vaultinator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VaultinatorApplication

    fun main(args: Array<String>) {
        runApplication<VaultinatorApplication>(*args)
    }

