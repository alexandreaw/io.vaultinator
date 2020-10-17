package io.vaultinator.model

import org.hibernate.annotations.Type

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Table
import javax.persistence.Id;

@Entity
@Table(name="password_manager")
data class PasswordManagerEntity(
        @Id @Type(type="pg-uuid") @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID,
        val name: String,
        val url: String,
        val username: String,
        val password: String
)