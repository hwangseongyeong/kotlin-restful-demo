package com.larva.restful.demo.domain.repository

import com.larva.restful.demo.domain.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String>{
}