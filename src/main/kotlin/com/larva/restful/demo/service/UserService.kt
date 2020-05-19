package com.larva.restful.demo.service

import com.larva.restful.demo.data.UserDto
import com.larva.restful.demo.domain.master.entity.User
import com.larva.restful.demo.domain.master.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
        private val repository: UserRepository
) {

    fun find(id: String) : UserDto {
        val user: User = repository.findById(id).orElse(User("1","1","1"))
        return UserDto(user.id, user.name, user.address)
    }

    fun save(userDto: UserDto) : User {
        return repository.save(
                User(userDto.id, userDto.name, userDto.address)
        )
    }

    fun delete(id: String) : Boolean {
        repository.deleteById(id)
        return true
    }
}