package com.larva.restful.demo.controller

import com.larva.restful.demo.data.UserDto
import com.larva.restful.demo.service.UserService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.*

@Api(value = "User CRUD", tags = ["User"])
@RestController
@RequestMapping("/api/user")
class UserController (
        private val service: UserService
) {

    @GetMapping("/{id}")
    fun get(@PathVariable(value = "id", required = true) id: String )
            = service.find(id)

    @PostMapping
    fun post(@RequestBody user: UserDto)
            = service.save(user)

    @PutMapping
    fun put(@RequestBody user: UserDto, @PathVariable(value = "id", required = true) id: String)
            = service.save(user)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id", required = true) id: String)
            = service.delete(id)
}