package com.demospring.demospring.model

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    val name: String,

    @Column(nullable = false, unique = true)
    @Email(message = "Email should be valid")
    val email: String,

    @Column(nullable = false)
    @Size(min = 6, message = "Password should be at least 6 characters long")
    val password: String,

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be 10 digits")
    val phone: String,

    @Column(nullable = false)
    @Pattern(regexp = "^(male|female|other)$", message = "Gender should be 'male', 'female' or 'other'")
    val gender: String
)
