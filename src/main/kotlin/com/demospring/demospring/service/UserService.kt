package com.demospring.demospring.service

import com.demospring.demospring.model.User
import com.demospring.demospring.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: UserRepository) {

    @Transactional
    fun registerUser(user: User): User {
        if (userRepository.findByEmail(user.email) != null) {
            throw IllegalArgumentException("Email already exists")
        }
        if (userRepository.findByPhone(user.phone) != null) {
            throw IllegalArgumentException("Phone number already exists")
        }
        return userRepository.save(user)
    }
}
