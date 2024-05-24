package com.demospring.demospring.controller

import com.demospring.demospring.model.User
import com.demospring.demospring.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @PostMapping("/signup")
    fun signUp(@Validated @RequestBody user: User): ResponseEntity<Any> {
        return try {
            val newUser = userService.registerUser(user)
            ResponseEntity(newUser, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            ResponseEntity(mapOf("error" to e.message), HttpStatus.CONFLICT)
        }
    }
}
