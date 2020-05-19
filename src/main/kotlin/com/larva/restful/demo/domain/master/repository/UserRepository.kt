package com.larva.restful.demo.domain.master.repository

import com.larva.restful.demo.domain.master.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String>{
}